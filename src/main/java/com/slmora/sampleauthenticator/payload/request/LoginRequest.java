/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 9:25 PM
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
 * @DateTime: 5/30/2021 9:25 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginRequest
{
    @NotBlank
    private String userName;

    @NotBlank
    private String password;
}
