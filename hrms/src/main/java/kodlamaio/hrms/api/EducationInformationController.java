package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.EducationInformation;

@RestController
@RequestMapping("/api/EducationInformation")
public class EducationInformationController {
	
	private EducationInformationService educationInformationService;

	@Autowired
	public EducationInformationController(EducationInformationService educationInformationService) {
		super();
		this.educationInformationService = educationInformationService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<EducationInformation>> getAll(){
		return this.educationInformationService.getAll();
		
	}
	
	@PostMapping("/add")
	Result add(@RequestBody EducationInformation educationInformation) {
		return this.educationInformationService.add(educationInformation);
	}
	
	
	
	  @GetMapping("/getAllByCv") DataResult<List<EducationInformation>>
	  getAllByCv_CvIdOrderByGraduationDateDesc(int cvId){ return
	  this.educationInformationService.getAllByCv_CvIdOrderByGraduationDateDesc(
	  cvId); }
	 
	 

}
