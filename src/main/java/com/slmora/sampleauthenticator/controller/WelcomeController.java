/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 1:28 PM
 */
package com.slmora.sampleauthenticator.controller;

import com.slmora.sampleauthenticator.util.security.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 5/30/2021 1:28 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
@RestController
public class WelcomeController
{
    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @GetMapping("/")
    public String wellcome()
    {
        return "Wellcome "+ authenticationFacade.getAuthentication().getName();
    }
}
