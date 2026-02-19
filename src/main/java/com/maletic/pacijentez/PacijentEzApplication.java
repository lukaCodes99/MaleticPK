package com.maletic.pacijentez;

import com.maletic.pacijentez.repository.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class PacijentEzApplication {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;


    public static void main(String[] args) {
        SpringApplication.run(PacijentEzApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner clearRefreshTokenTable() {
//        SecurityContextHolder.clearContext();
//        return args -> {
//            refreshTokenRepository.deleteAll();
//        };
//    }

}
