package com.project.autoreg.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.project.autoreg.model.User;
import com.project.autoreg.response.Response;
import com.project.autoreg.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UserController {

    /* Injeção de dependencia do reguladorService */
    @Autowired                                      
    private UserService userService;

    /* Método para mostrar todos os usuários */
    @GetMapping(value = "/{page}/{count}")
    public ResponseEntity<Response<Page<User>>> listAll(HttpServletRequest request, @PathVariable int page, @PathVariable int count) {
        Response<Page<User>> response = new Response<Page<User>>();

        Page<User> user = null;
        user = userService.listAll(page, count);
        response.setData(user);
        return ResponseEntity.ok(response);
    }
    /* Método para deletar um usuário */
    @DeleteMapping(value = "{/id}")
    public ResponseEntity<Response<Long>> deleteUser(@PathVariable Long id){
        Response<Long> response = new Response<Long>();
        Optional<User> userOptional = userService.findById(id);
        User user = userOptional.get();
        if(user == null) {
            response.getErrors().add("Registro não encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        userService.deleteUser(user);
        return ResponseEntity.ok(new Response<Long>());

    }

    /* Método para criar um novo usuário */
    @PostMapping
    public ResponseEntity<Response<User>> createUser(HttpServletRequest request,@RequestBody User user, BindingResult result) {
        Response<User> response = new Response<User>();
        try {
            validateCreateUser(user, result);
            if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }
        User userPersisted = (User) userService.createUser(user);
        response.setData(userPersisted);
        } catch (DuplicateKeyException duplicateKeyException) {
            response.getErrors().add("E-mail já registrado");
            return ResponseEntity.badRequest().body(response);
        } catch (Exception exception) {
            response.getErrors().add(exception.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    return ResponseEntity.ok(response);
}
    /* Método auxiliar para validar se o e-mail de cadastro está vazio */
    private void validateCreateUser(User user, BindingResult result) {
        if(user.getEmail() == null) {
            result.addError(new ObjectError("User", "E-mail não informado"));
            return;
        }
    }

    @PutMapping(value = "/{id}")
    private ResponseEntity<Response<User>> editUser (@PathVariable Long id, HttpServletRequest request, @RequestBody User user, BindingResult result) {
        Response<User> response = new Response<User>();

        try {
            validateUpdateUser(user, result);
            if(result.hasErrors()) {
                result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(response);
            }
            Optional<User> userCurrentOptional = userService.findById(user.getId());
            User userCurrent = userCurrentOptional.get();
            user.setEmail(userCurrent.getEmail());
            user.setPassword(userCurrent.getPassword());
            user.setLogin(userCurrent.getLogin());

            User reguladorPersisted = (User) userService.createUser(user);
            response.setData(reguladorPersisted);
        } catch (Exception exception) {
            response.getErrors().add(exception.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
            
        return ResponseEntity.ok(response);
    }

    private void validateUpdateUser (User user, BindingResult result) {
        if (user.getId() == null) {
            result.addError(new ObjectError("user", "Id não encontrado"));
            return;
        }
        if (user.getEmail() == null) {
            result.addError(new ObjectError("user", "Id não encontrado"));
            return;
        }
    }

}