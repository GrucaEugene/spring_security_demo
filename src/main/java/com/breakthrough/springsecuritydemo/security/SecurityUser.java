package com.breakthrough.springsecuritydemo.security;

import com.breakthrough.springsecuritydemo.model.Status;
import com.breakthrough.springsecuritydemo.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser {

    public static UserDetails fromUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(),
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                user.getRole().getAuthorities()
        );
    }
}
