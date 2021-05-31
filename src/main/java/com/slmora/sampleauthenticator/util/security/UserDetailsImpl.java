/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 2:07 PM
 */
package com.slmora.sampleauthenticator.util.security;

import com.slmora.sampleauthenticator.entity.SAUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 5/30/2021 2:07 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
@Data
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails
{
    private static final long serialVersionUID = -1203687946527502938L;

    private Integer userId;
    private String userName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(SAUser user){
        setUserId(user.getUserId());
        setUserName(user.getUserName());
        setPassword(user.getPassword());
        setEmail(user.getEmail());
        setAuthorities(new ArrayList<>());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return this.authorities;
    }

    @Override
    public String getPassword()
    {
        return this.password;
    }

    @Override
    public String getUsername()
    {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
