package com.example.authservertaco;

import com.example.authservertaco.authorization.users.User;
import com.example.authservertaco.authorization.users.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthServerTacoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerTacoApplication.class, args);
    }

    @Bean
    public ApplicationRunner dataLoader(
            UserRepository repo, PasswordEncoder encoder) { return args -> {
        repo.save(
                new User("taco", encoder.encode("1234"), "ROLE_ADMIN"));
    }; }
}
