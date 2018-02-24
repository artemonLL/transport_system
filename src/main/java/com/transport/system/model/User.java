package com.transport.system.model;


import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Proxy(lazy=false)
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;


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

  //  public Date getDate_birth() {
    //    return date_birth;
  //  }
//
  //  public void setDate_birth(Date date_birth) {
   //     this.date_birth = date_birth;
  //  }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


}
