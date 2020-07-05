package com.project.autoreg;

import com.project.autoreg.model.User;
import com.project.autoreg.repository.UserRepository;
import com.project.autoreg.security.enums.ProfileEnum;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class AutoregApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoregApplication.class, args);
	}

	@Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            initUsers(userRepository, passwordEncoder);
        };

	}
	
	private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        User admin = new User();
        admin.setEmail("davi.melo@enel.com");
        admin.setPassword(passwordEncoder.encode("123456"));
        admin.setProfile(ProfileEnum.ROLE_ADMIN);

        User find = userRepository.findByEmail("davi.melo@enel.com");
        if (find == null) {
            userRepository.save(admin);
        }
    }

}
