package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
	Result publish(JobAdvertisement jobAdvertisement);
	Result deactive(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> findAllByIsActive();
	
	DataResult<List<JobAdvertisement>> findAllByIsActiveSorted();
	
	DataResult<List<JobAdvertisement>> findAllByIsActiveAndCompanyName(int id);
	
	DataResult<JobAdvertisement> jobAdvertisementDisabled(int id);
}
