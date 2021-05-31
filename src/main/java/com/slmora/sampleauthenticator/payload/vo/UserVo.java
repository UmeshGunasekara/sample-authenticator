/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 12:31 PM
 */
package com.slmora.sampleauthenticator.payload.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This Class created for View Object for User Class
 *
 * @Author: SLMORA
 * @DateTime: 5/30/2021 12:31 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVo
{
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
}
