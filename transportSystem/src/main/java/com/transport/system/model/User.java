package com.transport.system.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {


    @Id
    @Column(name="usr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "date_birth")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateBirth=" + dateBirth +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!password.equals(user.password)) return false;
        if (!email.equals(user.email)) return false;
        if (!dateBirth.equals(user.dateBirth)) return false;
        if (!lastName.equals(user.lastName)) return false;
        return role.equals(user.role);
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + dateBirth.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
