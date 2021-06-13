package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.EducationInformationDao;
import kodlamaio.hrms.entities.EducationInformation;

@Service
public class EducationInformationManager implements EducationInformationService{

	private EducationInformationDao educationInformationDao;
	
	@Autowired
	public EducationInformationManager(EducationInformationDao educationInformationDao) {
		super();
		this.educationInformationDao = educationInformationDao;
	}

	@Override
	public DataResult<List<EducationInformation>> getAll() {
		
		return new SuccessDataResult<List<EducationInformation>>(this.educationInformationDao.findAll());
	}

	@Override
	public Result add(EducationInformation educationInformation) {
		if(educationInformation.getGraduationDate().isEmpty()) {
			educationInformation.setGraduationDate("Devam ediyor");
		}
		this.educationInformationDao.save(educationInformation);
		return new SuccessResult("Education information has added");
	}

	//@Override
		public DataResult<List<EducationInformation>> getAllByCv_CvIdOrderByGraduationDateDesc(int employeeId) {
		
		return new SuccessDataResult<List<EducationInformation>>(this.educationInformationDao.getAllByCv_CvIdOrderByGraduationDateDesc(employeeId));
	}

}
