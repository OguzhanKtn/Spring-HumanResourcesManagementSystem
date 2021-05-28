package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.employees;
import kodlamaio.hrms.entities.jobTitles;

public interface JobTitleService {

	   DataResult<List<jobTitles>> getAll();
	   Result add(jobTitles jobTitle);
}
