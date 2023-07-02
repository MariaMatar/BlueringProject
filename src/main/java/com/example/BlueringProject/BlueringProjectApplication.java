package com.example.BlueringProject;

import com.example.BlueringProject.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.BlueringProject.Repositories"})
@EntityScan(basePackages = {"com.example.BlueringProject.Entities"})
@ComponentScan(basePackages = {"com.example.BlueringProject.Mapper", "com.example.BlueringProject.Controller", "com.example.BlueringProject.Services"})
public class BlueringProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BlueringProjectApplication.class, args);

    }

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public void run(String... args) throws Exception {

    }
}
