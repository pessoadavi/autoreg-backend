package com.project.autoreg.service;

import java.util.List;

import com.project.autoreg.model.User;

public interface UserService {

    List<User> findAll(); /* Método para lsitar todos os usuários cadastrados */

    User findByEmail(String email); /* Método para procurar um usuário pelo email  */

    User delete(User user); /* Método para deletar um usuário */

    User save(User user); /* Método para salvar um novo usuário */

    User findById(Long id); /* Método para achar usuário pelo id */

}