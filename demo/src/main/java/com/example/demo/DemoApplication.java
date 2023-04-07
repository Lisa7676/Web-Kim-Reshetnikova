package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.model.Cart;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@SpringBootApplication
public class DemoApplication {
	
	@Bean
    public HttpSessionListener httpSessionListener() {
        return new HttpSessionListener() {
            @Override
            public void sessionDestroyed(HttpSessionEvent se) {
                // Здесь можно добавить код для удаления временных данных, связанных с сессией
            }
        };
    }
	@Bean
    @SessionScope
    public Cart cart() {
        return new Cart();
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
