package com.investdash.ws.user;


import com.investdash.ws.user.validation.UniqueEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users",  uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class User {


    @Id
    @GeneratedValue
    long id;

    @Size(min = 4, max = 50, message = "Username must be between 4 and 50 characters")
    @NotBlank
    String username;
    @NotBlank
    @Email
    @UniqueEmail
    String email;
    @Size(min = 8,max = 255)
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
