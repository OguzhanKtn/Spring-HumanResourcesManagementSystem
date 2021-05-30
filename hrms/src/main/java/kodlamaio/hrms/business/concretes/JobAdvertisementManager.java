package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.JobAdvertisementDao;
import kodlamaio.hrms.entities.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Successfully Added.");
	}

	@Override
	public Result publish(JobAdvertisement jobAdvertisement) {
		
	   JobAdvertisement publishedJobAdvertisement = (JobAdvertisement) this.jobAdvertisementDao.findAll();
	   publishedJobAdvertisement.setActive(true);
	   publishedJobAdvertisement.setPublishedAt(LocalDate.now());
	   this.jobAdvertisementDao.save(publishedJobAdvertisement);
	   return new SuccessResult("The announcement has been published.");
	}

	@Override
	public Result deactive(JobAdvertisement jobAdvertisement) {
        JobAdvertisement doPassivedJobAdvertisement = (JobAdvertisement) this.jobAdvertisementDao.findAll();
        doPassivedJobAdvertisement.setActive(!doPassivedJobAdvertisement.isActive());
        this.jobAdvertisementDao.save(doPassivedJobAdvertisement);
        return new SuccessResult("The announcement has been deactivated.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(jobAdvertisementDao.findAll(),"Successfully Listed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActive() {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAllByIsActive(true),"Successfully Listed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActiveSorted() {
		
		Sort sort = Sort.by(Sort.Direction.ASC,"applicationDeadline"); 
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActiveAndCompanyName(int id) {
		
		return new SuccessDataResult <List<JobAdvertisement>>
		(this.jobAdvertisementDao.getEmployersActiveJobAdvertisement(id),"Successfully Listed");
	}

	@Override
	public DataResult<JobAdvertisement> jobAdvertisementDisabled(int id) {
		JobAdvertisement ref =  this.jobAdvertisementDao.getOne(id);
		ref.setActive(false);
		return new SuccessDataResult <JobAdvertisement>(this.jobAdvertisementDao.save(ref),"İş ilanı Pasif.");
	}

}
