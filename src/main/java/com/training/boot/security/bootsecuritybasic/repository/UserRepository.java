package com.training.boot.security.bootsecuritybasic.repository;

import com.training.boot.security.bootsecuritybasic.entities.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<DAOUser, Integer> {
    DAOUser findByUsername(String name);
}
