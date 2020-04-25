package com.project.autoreg.repository;

import com.project.autoreg.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {

    User findByEmail(String email);

}