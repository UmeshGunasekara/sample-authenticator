/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 1:47 PM
 */
package com.slmora.sampleauthenticator.util.security;

import org.springframework.security.core.Authentication;

/**
 * This Interface created for
 *
 * @Author: SLMORA
 * @DateTime: 5/30/2021 1:47 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
public interface ITokenUtilities
{
    public String generateToken(Authentication authentication);
    public boolean validateToken(String token);
    public String getUserNameByToken(String token);
}
