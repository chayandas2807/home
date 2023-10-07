package home.example.springdatajpa.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORGANIZATION")
public class Organization implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORG_ID")
	private long org_id;
	
	@Column(name = "ORG_NAME")
	private String orgName;
	
	@Column(name = "ORG_LOC")
	private String location;
	
	@OneToOne
	@JoinColumn(name = "ORG_EMP_ID", foreignKey = @ForeignKey(name = "fk_EMPLOYEE_1"))
	private Employee emp;
}
