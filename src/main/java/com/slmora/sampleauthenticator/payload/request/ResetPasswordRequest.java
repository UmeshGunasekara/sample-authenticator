/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/31/2021 3:03 AM
 */
package com.slmora.sampleauthenticator.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 5/31/2021 3:03 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/31/2021      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResetPasswordRequest
{
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String resetToken;
}
