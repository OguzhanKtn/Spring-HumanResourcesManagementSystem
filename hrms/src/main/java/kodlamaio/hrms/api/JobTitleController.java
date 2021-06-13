package kodlamaio.hrms.api;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.JobTitles;

@RestController
@RequestMapping("/api/jobTitles")
public class JobTitleController {

	private JobTitleService jobTitleService;

	public JobTitleController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	 @GetMapping("/getall")
      public DataResult<List<JobTitles>> getAll(){
	  return jobTitleService.getAll();
	  }

	  @PostMapping("/add")
	   public Result add(@RequestBody JobTitles jobTitle){
		  
	     return this.jobTitleService.add(jobTitle);
	    }
}
