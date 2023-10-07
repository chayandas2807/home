package home.example.springdatajpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import home.example.springdatajpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
