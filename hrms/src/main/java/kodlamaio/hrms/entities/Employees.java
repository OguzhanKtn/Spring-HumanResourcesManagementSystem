package kodlamaio.hrms.entities;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity 
@Table(name="employees")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class Employees extends Users{
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_of_date")
	private String birthOfDate;
	
	@Column(name="password_repeat")
	private String passwordRepeat;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<Cv> cv;
}
