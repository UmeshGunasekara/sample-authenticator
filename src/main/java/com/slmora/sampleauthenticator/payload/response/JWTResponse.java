/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 9:42 PM
 */
package com.slmora.sampleauthenticator.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 5/30/2021 9:42 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JWTResponse
{
    private String jwt;
    private String type = "Bearer";
    private String userName;
    private String email;

    public JWTResponse(String jwt, String userName, String email){
        this.jwt = jwt;
        this.userName = userName;
        this.email = email;
    }
}
