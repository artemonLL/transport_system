package com.transport.system.model;


import org.hibernate.annotations.Proxy;
import org.hibernate.mapping.Collection;

import javax.persistence.*;




/**
 * Simple JavaBean object that represents Role of {@link User}.
 */
@Entity
@Proxy(lazy=false)
@Table(name = "role")
public class Role {



    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;



    @Column(name = "role_name")
    private String role_name;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

}
