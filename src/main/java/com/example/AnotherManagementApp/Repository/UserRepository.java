package com.example.AnotherManagementApp.Repository;

import com.example.AnotherManagementApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

     boolean existsByEmail(String email);
}
