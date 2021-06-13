package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.JobTitleDao;
import kodlamaio.hrms.entities.Employers;
import kodlamaio.hrms.entities.JobTitles;

@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<JobTitles>> getAll() {
		
		return new SuccessDataResult<List<JobTitles>>(this.jobDao.findAll(),"Successfully Listed");
	}

	@Override
	public Result add(JobTitles jobTitle) {
		// TODO Auto-generated method stub
		return new SuccessResult("Successfully added");
	}

}
