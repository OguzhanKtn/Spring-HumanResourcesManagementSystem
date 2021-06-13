package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.WorkExperience;

@RestController
@RequestMapping("/api/WorkExperience")
public class WorkExperienceController {
	
	private WorkExperienceService workExperienceService;

	@Autowired
	public WorkExperienceController(WorkExperienceService workExperienceService) {
		super();
		this.workExperienceService = workExperienceService;
	}

	@PostMapping("/add")
	Result add(@RequestBody WorkExperience workExperience) {
		return this.workExperienceService.add(workExperience);
		
	}
	
	@GetMapping("/getAll")
	DataResult<List<WorkExperience>> getAll(){
		return this.workExperienceService.getAll();
		
	}
	
	
	  @GetMapping("/getAllByCvIdOrderByEndingDateDesc")
	  DataResult<List<WorkExperience>> getAllByCv_CvIdOrderByEndingDateDesc(int cvId){
	  return this.workExperienceService.getAllByCv_CvIdOrderByEndingDateDesc(cvId); }
	 
	
}
