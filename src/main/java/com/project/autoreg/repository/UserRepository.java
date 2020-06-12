package com.project.autoreg.repository;

import com.project.autoreg.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    User findByEmail(String email);

}