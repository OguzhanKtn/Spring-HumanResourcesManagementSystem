package kodlamaio.hrms.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.CoverLetter;
import kodlamaio.hrms.entities.EducationInformation;
import kodlamaio.hrms.entities.Employees;
import kodlamaio.hrms.entities.ForeignLanguage;
import kodlamaio.hrms.entities.Photo;
import kodlamaio.hrms.entities.SocialMedia;
import kodlamaio.hrms.entities.Technology;
import kodlamaio.hrms.entities.WorkExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvPostDto {
	
	@JsonIgnore()
	private Employees employee;
	private CoverLetter coverLetter;
	private Photo photo;
	private List<EducationInformation> educationInformation;
	private List<ForeignLanguage> foreignLanguage;
	private List<SocialMedia> socialMedia;
	private List<Technology> technology;
	private List<WorkExperience> workExperience;
}
