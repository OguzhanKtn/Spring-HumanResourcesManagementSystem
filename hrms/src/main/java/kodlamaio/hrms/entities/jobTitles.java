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
@Table(name="job_titles")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
public class jobTitles {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    
	 @Column(name="id")
	  private int id;
	 
	 @Column(name="title")
	 private String title;
	 
	 @OneToMany(mappedBy = "jobDescription")
	 private List<JobAdvertisement> jobAdvertisement;
}
