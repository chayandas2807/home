package home.example.springdatajpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import home.example.springdatajpa.entity.Employee;
import home.example.springdatajpa.entity.Organization;
import home.example.springdatajpa.repo.EmployeeRepository;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World");

		List<Employee> empList = new ArrayList<Employee>();
		
		int count = 1;
		while (true) {

			Employee employee = new Employee();

			employee.setName("chayan " + count);
			employee.setRole("Dev" + count);

			Organization org = new Organization();
			org.setLocation("home" + count);
			org.setOrgName("TCS" + 1);

			employee.setOrg(org);
			org.setEmp(employee);
			
			empList.add(employee);
			
			count++;

			if (count > 100000) {
				break;
			}
		}
		
		System.out.println("Total employee count "+ empList.size()+"  "+LocalDateTime.now());

		employeeRepository.saveAllAndFlush(empList);

		System.out.println("Successfully saved the employee"+"  "+LocalDateTime.now());
	}

}
