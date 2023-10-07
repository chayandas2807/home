package home.example.springdatajpa.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	private long empId;
	
	@Column(name = "EMP_NAME")
	private String name;
	
	@Column(name = "EMP_ROLE")
	private String role;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "emp")
	private Organization org;	
}
