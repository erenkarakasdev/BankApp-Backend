package com.app.bankappbackend.repository;

import com.app.bankappbackend.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
