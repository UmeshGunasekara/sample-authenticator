/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 1:45 PM
 */
package com.slmora.sampleauthenticator.api.v01.resource;

import com.slmora.sampleauthenticator.dao.repository.ISAUserRepository;
import com.slmora.sampleauthenticator.entity.SAUser;
import com.slmora.sampleauthenticator.payload.request.LoginRequest;
import com.slmora.sampleauthenticator.payload.request.ResetPasswordRequest;
import com.slmora.sampleauthenticator.payload.response.JWTResponse;
import com.slmora.sampleauthenticator.payload.response.MessageResponse;
import com.slmora.sampleauthenticator.payload.response.ResetPasswordTokenResponse;
import com.slmora.sampleauthenticator.service.ISAUserService;
import com.slmora.sampleauthenticator.payload.request.SignUpRequest;
import com.slmora.sampleauthenticator.util.MailUtilities;
import com.slmora.sampleauthenticator.util.security.JWTUtilities;
import com.slmora.sampleauthenticator.util.security.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 5/30/2021 1:45 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
//@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v01/auth")
public class AuthResource
{
    private static final Logger logger = LoggerFactory.getLogger(AuthResource.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtilities jwtUtilities;

    @Autowired
    private ISAUserService userService;

    @Autowired
    private MailUtilities mailUtilities;

    @Autowired
    private ISAUserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@Valid @RequestBody SignUpRequest signUpRequest){
        String msg = userService.isUserExist(signUpRequest);
        if(msg.equals("OK")){
            userService.save(signUpRequest);
            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }else{
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(msg));
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signInUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtilities.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(
                new JWTResponse(jwt,
                        userDetails.getUsername(),
                        userDetails.getEmail()));
    }

    @GetMapping("/forgetpassword")
    public ResponseEntity<?> mailPasswordResetToken(@RequestParam String email){
        SAUser user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Can't found user with email: "+email));
        try {
            mailUtilities.sendEmail(user.getEmail(), user.getResetToken());
        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (MessagingException e) {
//            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return ResponseEntity.ok(new MessageResponse("Send the password Reset Token successfully to "+user.getEmail()));
    }

    @GetMapping("/forgetpasswordtoken")
    public ResponseEntity<?> getPasswordResetToken(@RequestParam String email){
        SAUser user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Can't found user with email: "+email));
        return ResponseEntity.ok(
                new ResetPasswordTokenResponse(user.getResetToken(),
                        user.getUserName(),
                        user.getEmail()));
    }

    @PostMapping("/resetpassword")
    public ResponseEntity<?> resetPassword(
            @Valid @RequestBody ResetPasswordRequest resetPasswordRequest){
        String msg = userService.isUserExist(resetPasswordRequest);
        if(msg.equals("OK")){
            userService.save(resetPasswordRequest);
            return ResponseEntity.ok(new MessageResponse("User password reseated successfully!"));
        }else{
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(msg));
        }
    }


}
