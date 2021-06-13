package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.CoverLetter;
import kodlamaio.hrms.entities.Cv;

public interface CvService {

	DataResult<List<Cv>> getAll();
	Result add(Cv cv);
	DataResult<List<Cv>> getByCvIdForEmployeeId(int employeeId);
	
}
