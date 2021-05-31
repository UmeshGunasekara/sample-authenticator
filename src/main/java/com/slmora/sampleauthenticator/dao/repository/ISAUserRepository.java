/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 12:36 PM
 */
package com.slmora.sampleauthenticator.dao.repository;

import com.slmora.sampleauthenticator.entity.SAUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * This Interface created for
 *
 * @Author: SLMORA
 * @DateTime: 5/30/2021 12:36 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
public interface ISAUserRepository extends CrudRepository<SAUser, Integer>
{
    Optional<SAUser> findByUserName(String userName);
    Optional<SAUser> findByResetToken(String resetToken);
    Optional<SAUser> findByEmail(String email);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
    Boolean existsByResetToken(String resetToken);
}
