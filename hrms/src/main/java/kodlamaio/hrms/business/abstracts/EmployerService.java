package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.Employees;
import kodlamaio.hrms.entities.Employers;
import kodlamaio.hrms.entities.dtos.EmployerPostDto;

public interface EmployerService {

	   DataResult<List<Employers>> getAll();
	   Result add(EmployerPostDto employer);
}
