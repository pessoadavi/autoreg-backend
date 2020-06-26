package com.project.autoreg.service;

import java.util.Optional;

import com.project.autoreg.model.User;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    Page<User> listAll(int page, int count); /* Método para lsitar todos os usuários cadastrados */

    User findByEmail(String email); /* Método para procurar um usuário pelo email  */

    void deleteUser(User user); /* Método para deletar um usuário */

    User createUser(User user); /* Método para salvar um novo usuário */

    Optional<User> findById(Long id); /* Método para achar usuário pelo id */

}