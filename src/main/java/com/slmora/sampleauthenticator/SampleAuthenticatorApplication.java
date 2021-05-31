package com.slmora.sampleauthenticator;

import com.slmora.sampleauthenticator.dao.repository.ISAUserRepository;
import com.slmora.sampleauthenticator.entity.SAUser;
import com.slmora.sampleauthenticator.util.UuidUtilities;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@SpringBootApplication
public class SampleAuthenticatorApplication
{
    @Autowired
    private ISAUserRepository userRepository;

    public static void main(String[] args)
    {
        SpringApplication.run(SampleAuthenticatorApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer()
        {
            @Override
            public void addCorsMappings(CorsRegistry registry)
            {
                registry.addMapping("/*")
                        .allowedHeaders("*")
                        .allowedOriginPatterns("*")
                        .allowedMethods("*")
                        .allowCredentials(true);
            }
        };
    }

    @PostConstruct
    public void initUsers() {
        List<SAUser> users = Stream.of(
                new SAUser(1, "First 1", "Last 1", "umesh.gunasekara.n@gmail.com", "user1", "user1", UuidUtilities.removeHyphens(UUID.randomUUID()), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())),
                new SAUser(2, "First 2", "Last 2", "first2@slmora.com", "user2", "user2", UuidUtilities.removeHyphens(UUID.randomUUID()), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())),
                new SAUser(3, "First 3", "Last 3", "first3@slmora.com", "user3", "user3", UuidUtilities.removeHyphens(UUID.randomUUID()), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())),
                new SAUser(4, "First 4", "Last 4", "first4@slmora.com", "user4", "user4", UuidUtilities.removeHyphens(UUID.randomUUID()), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()))
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }
}
