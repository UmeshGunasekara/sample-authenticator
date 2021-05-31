/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/31/2021 1:03 AM
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
 * @DateTime: 5/31/2021 1:03 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/31/2021      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResetPasswordTokenResponse
{
    private String resetToken;
    private String userName;
    private String email;
}
