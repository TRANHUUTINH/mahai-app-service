package com.example.maHai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // áp dụng cho tất cả endpoint /api/...
                        .allowedOrigins(
                            "https://mahai-pay2oxjqv-tranhuutinhs-projects.vercel.app",
                            "https://mahai-app-tawny.vercel.app", // thêm origin mới
                            "http://localhost:5173" // dev local
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // các phương thức cần thiết
                        .allowedHeaders("*") // cho phép tất cả headers
                        .allowCredentials(true) // nếu có cookie hoặc token
                        .maxAge(3600); // cache preflight request 1 giờ
            }
        };
    }
}
