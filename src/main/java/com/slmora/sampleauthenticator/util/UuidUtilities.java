/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 9:17 PM
 */
package com.slmora.sampleauthenticator.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 5/30/2021 9:17 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
public class UuidUtilities
{
    private static final Logger logger = LoggerFactory.getLogger(UuidUtilities.class);

    public static String removeHyphens(UUID uuid){
        return uuid.toString().replace("-","");
    }
}
