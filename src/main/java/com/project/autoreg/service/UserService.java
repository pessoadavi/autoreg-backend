package com.project.autoreg.service;

import com.project.autoreg.model.User;

public interface UserService {

    User findByEmail(User email); /* Método para procurar um usuário pelo email  */

    User delete(User user); /* Método para deletar um usuário */

    User save(User user); /* Método para salvar um novo usuário */

}