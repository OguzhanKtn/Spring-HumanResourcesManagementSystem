package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.jobTitleDao;
import kodlamaio.hrms.entities.employers;
import kodlamaio.hrms.entities.jobTitles;

@Service
public class JobTitleManager implements JobTitleService{

	private jobTitleDao jobDao;
	
	@Autowired
	public JobTitleManager(jobTitleDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<jobTitles>> getAll() {
		
		return new SuccessDataResult<List<jobTitles>>(this.jobDao.findAll(),"Successfully Listed");
	}

	@Override
	public Result add(jobTitles jobTitle) {
		// TODO Auto-generated method stub
		return new SuccessResult("Successfully added");
	}

}
