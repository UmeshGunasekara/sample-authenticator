/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 12:39 PM
 */
package com.slmora.sampleauthenticator.service.impl;

import com.slmora.sampleauthenticator.dao.repository.ISAUserRepository;
import com.slmora.sampleauthenticator.entity.SAUser;
import com.slmora.sampleauthenticator.payload.request.ResetPasswordRequest;
import com.slmora.sampleauthenticator.service.ISAUserService;
import com.slmora.sampleauthenticator.payload.request.SignUpRequest;
import com.slmora.sampleauthenticator.payload.vo.UserVo;
import com.slmora.sampleauthenticator.util.UuidUtilities;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 5/30/2021 12:39 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
@Service
@Transactional
public class SAUserServiceImpl implements ISAUserService
{

    private final ModelMapper modelMapper;
    private final ISAUserRepository userRepository;

    @Autowired
    public SAUserServiceImpl(ModelMapper modelMapper,
                             ISAUserRepository userRepository)
    {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserVo> getAllUsers()
    {
        return StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .map(user -> modelMapper.map(user, UserVo.class))
                .collect(Collectors.toList());
    }

    @Override
    public String isUserExist(SignUpRequest signUpRequest)
    {

        if(userRepository.existsByUserName(signUpRequest.getUserName())){
            return "Error: Username is already exist!";
        }else if(userRepository.existsByEmail(signUpRequest.getEmail())){
            return "Error: Email is already exist!";
        }else{
            return "OK";
        }
    }

    @Override
    public String isUserExist(ResetPasswordRequest resetPasswordRequest)
    {
        Optional<SAUser> user = userRepository.findByResetToken(resetPasswordRequest.getResetToken());

        if(!user.isPresent()){
            return "Error: User doesn't exist for given Token";
        }else if(!user.get().getEmail().equals(resetPasswordRequest.getEmail())){
            return "Error: Email doesn't match with request";
        }else{
            return "OK";
        }
    }

    @Override
    public SAUser save(SignUpRequest signUpRequest)
    {
        SAUser user = new SAUser(
                signUpRequest.getEmail(),
                signUpRequest.getUserName(),
                signUpRequest.getPassword()
        );
        user.setResetToken(UuidUtilities.removeHyphens(UUID.randomUUID()));
        user.setCreateDateTime(new Date(System.currentTimeMillis()));
        user.setUpdateDateTime(new Date(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    @Override
    public SAUser save(ResetPasswordRequest resetPasswordRequest)
    {
        SAUser user = userRepository.findByEmail(resetPasswordRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Can't found user with email: "+resetPasswordRequest.getEmail()));
        user.setPassword(resetPasswordRequest.getPassword());
        user.setResetToken(UuidUtilities.removeHyphens(UUID.randomUUID()));
        user.setUpdateDateTime(new Date(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    @Override
    public SAUser updateForgetPassword(String email, String newPassword)
    {
        SAUser user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Can't found user with email: "+email));
        user.setPassword(newPassword);
        user.setResetToken(UuidUtilities.removeHyphens(UUID.randomUUID()));
        user.setUpdateDateTime(new Date(System.currentTimeMillis()));
        return userRepository.save(user);
    }
}
