package com.app.bankappbackend.dto;

import lombok.Builder;

import javax.management.relation.Role;

@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Role authorities
){
}
