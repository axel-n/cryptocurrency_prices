package com.example.prices;

import com.example.prices.services.jwt.JwtUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application  implements CommandLineRunner {
    public Application(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private final JwtUtil jwtUtil;

    @Override
    public void run(String... args) {

        String token = jwtUtil.generateToken("/orders?product_id=1");
        System.out.println(token);
    }
}
