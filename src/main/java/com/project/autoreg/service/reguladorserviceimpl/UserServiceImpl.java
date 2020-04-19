package com.project.autoreg.service.reguladorserviceimpl;

import com.project.autoreg.model.User;
import com.project.autoreg.repository.UserRepository;
import com.project.autoreg.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired  /* Ponto de injeção do repositório */
    UserRepository userRepository;

    @Override
    public User findByEmail(User email) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

}