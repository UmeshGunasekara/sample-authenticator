/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 2:01 PM
 */
package com.slmora.sampleauthenticator.service.impl;

import com.slmora.sampleauthenticator.dao.repository.ISAUserRepository;
import com.slmora.sampleauthenticator.entity.SAUser;
import com.slmora.sampleauthenticator.util.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 5/30/2021 2:01 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private ISAUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
    {
        SAUser user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Can't found user with UserName: "+userName));
        return new UserDetailsImpl(user);
    }
}
