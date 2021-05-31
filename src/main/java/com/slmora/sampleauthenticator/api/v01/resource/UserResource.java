/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 12:46 PM
 */
package com.slmora.sampleauthenticator.api.v01.resource;

import com.slmora.sampleauthenticator.service.ISAUserService;
import com.slmora.sampleauthenticator.payload.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This Class created for API V01 User Resource
 *
 * @Author: SLMORA
 * @DateTime: 5/30/2021 12:46 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
@RestController
@RequestMapping("/api/v01")
public class UserResource
{
    @Autowired
    private ISAUserService userService;

    @GetMapping("/users")
    public List<UserVo> getUsers(){
        return userService.getAllUsers();
    }
}
