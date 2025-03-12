package com.example.tarea3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")  // Asegura que la ruta base sea "/api"
public class HelloController {

    @GetMapping("/hello")  // Define la ruta específica "/hello"
    public Map<String, String> helloWorld() {
        return Map.of("message", "Hola Mundo desde Spring Boot");
    }
}
