package com.project.autoreg.security.jwt;

import java.util.ArrayList;
import java.util.List;

import com.project.autoreg.model.User;
import com.project.autoreg.security.enums.ProfileEnum;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

// Classe para converter nosso usuário em um usuário reconhecido pelo spring security//
public class JwtUserFactory {
    private JwtUserFactory() {
    }

    // Método para criar um JwtUser com base nos dados do usuário //
    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getProfile())
        );
    }

    // Mpetodo que converte o perfil do usuário par o formato utilizado no spring security //
    private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
            authorities.add(new SimpleGrantedAuthority(profileEnum.toString())); 
            return   authorities ;
    }
    
}