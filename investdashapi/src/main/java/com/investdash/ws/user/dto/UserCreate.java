package com.investdash.ws.user.dto;

import com.investdash.ws.user.User;
import com.investdash.ws.user.validation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserCreate(

        @Size(min = 4, max = 50)
        @NotBlank(message = "{investdash.constraint.username.notblank}")
        String username,
        @NotBlank
        @Email
        @UniqueEmail
        String email,
        @Size(min = 8, max = 255)
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{investdash.constraint.password.pattern}")
        String password
) {

    public User toUser() {
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
