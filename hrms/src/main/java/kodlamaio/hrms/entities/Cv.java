package kodlamaio.hrms.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cv")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", ""})
public class Cv {

	@Id
	@Column(name="cv_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cvId;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employees employee;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<ForeignLanguage> foreignLanguage;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<SocialMedia> socialMedia;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<Technology> technology;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<EducationInformation> educationInformation;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<WorkExperience>  workExperience;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<Photo> photo;
}
