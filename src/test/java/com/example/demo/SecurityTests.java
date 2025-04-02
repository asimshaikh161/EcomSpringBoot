package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SecurityTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void testPasswordEncoding() {
        String rawPassword = "password";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // Verify that the raw password matches the encoded version
        assertTrue(passwordEncoder.matches(rawPassword, encodedPassword),
                "The raw password should match the encoded password");
    }
}
