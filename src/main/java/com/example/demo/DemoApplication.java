package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;
import java.util.*;
import com.example.demo.student.student;
import java.time.LocalDate;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	//	@GetMapping
	//	public List<student> hello(){
	//		return List.of(new student(1L, "Mayur Khadde", "mayur.khadde@gmail.com", LocalDate.of(2000, Month.FEBRUARY, 5), 21));
	//	}
}
