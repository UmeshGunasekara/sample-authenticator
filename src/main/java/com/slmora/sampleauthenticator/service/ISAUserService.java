/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 12:38 PM
 */
package com.slmora.sampleauthenticator.service;

import com.slmora.sampleauthenticator.entity.SAUser;
import com.slmora.sampleauthenticator.payload.request.ResetPasswordRequest;
import com.slmora.sampleauthenticator.payload.request.SignUpRequest;
import com.slmora.sampleauthenticator.payload.vo.UserVo;

import java.util.List;

/**
 * This Interface created for
 *
 * @Author: SLMORA
 * @DateTime: 5/30/2021 12:38 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
public interface ISAUserService
{
    public List<UserVo> getAllUsers();
    public String isUserExist(SignUpRequest signUpRequest);
    public String isUserExist(ResetPasswordRequest resetPasswordRequest);
    public SAUser save(SignUpRequest signUpRequest);
    public SAUser save(ResetPasswordRequest resetPasswordRequest);
    public SAUser updateForgetPassword(String email, String newPassword);
}
