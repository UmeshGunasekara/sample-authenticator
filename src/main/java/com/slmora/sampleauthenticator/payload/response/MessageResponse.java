/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 8:47 PM
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
 * @DateTime: 5/30/2021 8:47 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageResponse
{
    private String message;
}
