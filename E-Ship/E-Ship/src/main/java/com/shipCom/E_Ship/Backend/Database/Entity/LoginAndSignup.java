package com.shipCom.E_Ship.Backend.Database.Entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "UserEntry")
public class LoginAndSignup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long UserId;

    @Column(nullable = false, unique = true)
    private String Username;

    @Column(nullable = false)
    private String Email;

    @Column(nullable = false)
    private String Password;

    @Column
    private String ConfirmPassword;  // This field is not stored in the DB, only used for validation.

    //roles
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private List<String> roles;

    // Getters and Setters

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        this.UserId = userId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.ConfirmPassword = confirmPassword;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "LoginAndSignup{" +
                "userId=" + UserId +
                ", username='" + Username + '\'' +
                ", email='" + Email + '\'' +
                ", password='" + Password + '\'' +
                ", ConfirmPassword='" + ConfirmPassword + '\'' +
                ", roles=" + roles +
                '}';
    }

    // Constructors

    public LoginAndSignup(String username, String email, String password, List<String> roles) {
        this.Username = username;
        this.Email = email;
        this.Password = password;
        this.roles = roles;
    }

    public LoginAndSignup() {
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convert the list of role names into GrantedAuthority objects
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))  // Prefix roles with "ROLE_" if needed
                .collect(Collectors.toList());
    }
}
