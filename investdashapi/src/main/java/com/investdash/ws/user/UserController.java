package com.investdash.ws.user;

import com.investdash.ws.error.ApiError;
import com.investdash.ws.shared.GenericMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("api/v1/users")
    ResponseEntity<?> createUser(@RequestBody User user){ ApiError apiError = new ApiError();
        apiError.setPath("/api/v1/users");
        apiError.setMessage("Validation error");
        apiError.setStatus(400);
        Map<String,String> validationErrors = new HashMap<>();
        if (user.getUsername() == null || user.getUsername().isEmpty()){

            validationErrors.put("username","Username cannot be null");

        }
        if (user.getEmail() == null || user.getEmail().isEmpty()){
            validationErrors.put("email","Email cannot be null");

        }

        if (validationErrors.size() > 0){
            apiError.setValidationErrors(validationErrors);
            return ResponseEntity.badRequest().body(apiError);}

        userService.save(user);
        return ResponseEntity.ok(new GenericMessage("User is created"));
    }

}