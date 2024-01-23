package dev.ungu.mechanicshop.model;

import java.util.List;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private Role role;
    private String token;

    public User() {}

    public User(Long id, String username, String password, String email, String role, String token) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = Role.valueOf(role);
        this.token = token;
    }


    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return this.username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return this.role.toString(); }
    public void setRole(String role) { this.role = Role.valueOf(role); }

    public String getToken() { return this.token; }
    public void setToken(String token) { this.token = token; }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
