package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.Employees;
import kodlamaio.hrms.entities.JobTitles;

public interface JobTitleService {

	   DataResult<List<JobTitles>> getAll();
	   Result add(JobTitles jobTitle);
}
