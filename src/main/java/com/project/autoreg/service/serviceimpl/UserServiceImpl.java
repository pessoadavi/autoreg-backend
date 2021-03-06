package com.project.autoreg.service.serviceimpl;

import java.util.Optional;

import com.project.autoreg.model.User;
import com.project.autoreg.repository.UserRepository;
import com.project.autoreg.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired /* Ponto de injeção do repositório */
    UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Page<User> listAll(int page, int count) {
        PageRequest pages = PageRequest.of(page, count);
        return this.userRepository.findAll(pages);
    }

}