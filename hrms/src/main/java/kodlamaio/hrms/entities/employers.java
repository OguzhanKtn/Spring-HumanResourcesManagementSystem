package kodlamaio.hrms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity 
@Table(name="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
public class employers extends users{

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    
	 @Column(name="id")
	  private int id;
	 
	 @Column(name="company_name")
	 private String companyName;
	 
	 @Column(name="web_adress")
	 private String webAdress;
	 
	 @Column(name="phone_number")
	 private String phoneNumber;
	 
	@Column(name="password_repeat")
	private String passwordRepeat;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisement;
}
