package com.atacadista.test;

import com.atacadista.main.AtacadistaApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
    }

    @GetMapping
    public List<String> routes() {
        return List.of("teste", "produto");
    }
}
