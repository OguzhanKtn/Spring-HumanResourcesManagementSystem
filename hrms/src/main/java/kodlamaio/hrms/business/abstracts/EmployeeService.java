package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.Employees;

public interface EmployeeService {

	   DataResult<List<Employees>> getAll();
	   Result add(Employees employee);
}
