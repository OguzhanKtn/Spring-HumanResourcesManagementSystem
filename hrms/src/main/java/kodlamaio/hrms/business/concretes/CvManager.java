package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.CvDao;
import kodlamaio.hrms.entities.Cv;

@Service
public class CvManager implements CvService{

	private CvDao cvDao;
	
	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll());
	}

	@Override
	public Result add(CvPostDto cv) {
		Cv cv2 = this.modelMapper.map(cv,Cv.class);
		this.cvDao.save(cv2);
		return new SuccessResult("Resume has added");
	}

	@Override
	public DataResult<List<Cv>> getByCvIdForEmployeeId(int employeeId) {
		
		return new SuccessDataResult<List<Cv>>(this.cvDao.getAllByEmployeeId(employeeId));
	}

}
