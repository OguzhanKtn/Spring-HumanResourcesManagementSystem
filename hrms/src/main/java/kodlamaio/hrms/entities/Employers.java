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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity 
@Table(name="employers") 
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class Employers extends Users{
	 
	 @Column(name="company_name")
	 private String companyName;
	 
	 @Column(name="web_adress")
	 private String webAdress;
	 
	 @Column(name="phone_number")
	 private String phoneNumber;
	 
	@Column(name="password_repeat")
	private String passwordRepeat;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisement;
}
