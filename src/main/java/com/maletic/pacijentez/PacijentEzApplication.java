package com.maletic.pacijentez;

import com.maletic.pacijentez.repository.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PacijentEzApplication {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;


    public static void main(String[] args) {
        SpringApplication.run(PacijentEzApplication.class, args);
    }

    @Bean
    public CommandLineRunner clearRefreshTokenTable() {
        return args -> {
            refreshTokenRepository.deleteAll();
        };
    }

}
