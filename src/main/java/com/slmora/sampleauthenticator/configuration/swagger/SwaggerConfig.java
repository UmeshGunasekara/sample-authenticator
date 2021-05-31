/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 11:57 AM
 */
package com.slmora.sampleauthenticator.configuration.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * This Class created for Swagger Configuration
 *
 * @Author: SLMORA
 * @DateTime: 5/30/2021 11:57 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
public class SwaggerConfig
{

    @Bean
    public OpenAPI customOpenAPI(
            @Value("${app-description}") String appDesciption,
            @Value("${app-version}") String appVersion
    )
    {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Sample Authenticator Application API")
                        .version(appVersion)
                        .description(appDesciption)
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact().name("Umesh").email("umesh@slmora.com").url("http://slmora.com/"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                );
    }
}
