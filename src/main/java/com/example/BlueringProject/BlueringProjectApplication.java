package com.example.BlueringProject;

import com.example.BlueringProject.Entities.EmployeeEntity;
import com.example.BlueringProject.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlueringProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BlueringProjectApplication.class, args);

	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

//		EmployeeEntity employee1 = new EmployeeEntity();
//		employee1.setFirstName("Maria");
//		employee1.setLastName("Matar");
//		employee1.setAddress("Beirut");
//		employee1.setPhoneNumber(Integer.valueOf(70123456));
//		employeeRepository.save(employee1);
//
//		EmployeeEntity employee2 = new EmployeeEntity();
//		employee2.setFirstName("Vanessa");
//		employee2.setLastName("Matar");
//		employee2.setAddress("South");
//		employee2.setPhoneNumber(Integer.valueOf(76123456));
//		employeeRepository.save(employee2);
//
//		EmployeeEntity employee3 = new EmployeeEntity();
//		employee3.setFirstName("Perla");
//		employee3.setLastName("Matar");
//		employee3.setAddress("North");
//		employee3.setPhoneNumber(Integer.valueOf(071234567));
//		employeeRepository.save(employee3);
//
//		EmployeeEntity employee4 = new EmployeeEntity();
//		employee4.setFirstName("YYYY");
//		employee4.setLastName("XXXX");
//		employee4.setAddress("North");
//		employee4.setPhoneNumber(Integer.valueOf(79123456));
//		employeeRepository.save(employee4);
//
//		EmployeeEntity employee5 = new EmployeeEntity();
//		employee5.setFirstName("ZZZZ");
//		employee5.setLastName("AAAA");
//		employee5.setAddress("North");
//		employee5.setPhoneNumber(Integer.valueOf(70123456));
//		employeeRepository.save(employee5);
	}
}
