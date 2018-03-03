package com.transport.system.model;


import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Date;


/**
 * Simple JavaBean  object that represents a User
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;



    @Column(name = "first_name")
    private String first_name;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Column(name = "email")
    private String email;

    @Column(name = "date_birth")
    private Date date_birth;

    @ManyToOne (optional = false,cascade = CascadeType.ALL)
    @JoinColumn (name = "role_id")
    private Role role;

    @Column(name = "last_name")
    private String last_name;






    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  public Date getDate_birth() {
    return date_birth;
 }

 public void setDate_birth(Date date_birth) {
    this.date_birth = date_birth;}

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


}
