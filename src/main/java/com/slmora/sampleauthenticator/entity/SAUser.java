/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 12:17 PM
 */
package com.slmora.sampleauthenticator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * This Class created for Entity for persistent User
 *
 * @Author: SLMORA
 * @DateTime: 5/30/2021 12:17 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "sa_user")
@NamedQueries({
        @NamedQuery(name = "SAUser.findAll", query = "SELECT p FROM SAUser p")})
public class SAUser implements Serializable
{
    private static final long serialVersionUID = -5171408033268410155L;

    @Id
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name", length = 250)
    private String firstName;

    @Column(name = "last_name", length = 250)
    private String lastName;

    @Basic(optional = false)
    @Column(name = "email", length = 100)
    private String email;

    @Basic(optional = false)
    @Column(name = "user_name", length = 20)
    private String userName;

    @Basic(optional = false)
    @Column(name = "password", length = 250)
    private String password;

    @Column(name = "reset_token", length = 32)
    private String resetToken;

    @Basic(optional = false)
    @Column(name = "update_date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDateTime;

    @Basic(optional = false)
    @Column(name = "create_date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateTime;

    public SAUser(String email, String userName, String password){
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SAUser saUser = (SAUser) o;

        if (userId != null ? !userId.equals(saUser.userId) : saUser.userId != null) return false;
        if (email != null ? !email.equals(saUser.email) : saUser.email != null) return false;
        if (userName != null ? !userName.equals(saUser.userName) : saUser.userName != null) return false;
        return password != null ? password.equals(saUser.password) : saUser.password == null;
    }

    @Override
    public int hashCode()
    {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
