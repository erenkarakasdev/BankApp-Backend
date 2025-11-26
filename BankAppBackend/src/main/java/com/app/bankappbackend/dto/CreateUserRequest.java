package com.app.bankappbackend.dto;

import lombok.Builder;

import com.app.bankappbackend.entities.Role;

@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Role authority
){
}
