package com.example.amiclo.config;

import com.example.amiclo.model.Role;
import com.example.amiclo.model.User;
import com.example.amiclo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Configuration
public class DataInit {

    @Bean
    CommandLineRunner initAdmin(UserRepository repo, BCryptPasswordEncoder encoder) {
        return args -> {
            if (repo.findByUsername("adminka").isEmpty()) {
                User admin = new User();
                admin.setUsername("adminka");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRoles(Set.of(Role.ADMIN));
                repo.save(admin);

                System.out.println(admin);
            }
        };
    }
}