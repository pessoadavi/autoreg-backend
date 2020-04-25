package com.project.autoreg.service.reguladorserviceimpl;

import java.util.List;

import com.project.autoreg.model.User;
import com.project.autoreg.repository.UserRepository;
import com.project.autoreg.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired /* Ponto de injeção do repositório */
    UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User delete(User user) {
        userRepository.delete(user);
        return null;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

}