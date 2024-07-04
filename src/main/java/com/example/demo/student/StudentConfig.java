package com.example.demo.student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            student s1 = new student(1L, "Mayur Khadde", "mayur.khadde@gmail.com", LocalDate.of(2000, Month.FEBRUARY, 5));
            student s2 = new student(2L, "Alex", "alex@gmail.com", LocalDate.of(2000, Month.FEBRUARY, 5));
            repository.saveAll(List.of(s1,s2));
        };

    }
}
