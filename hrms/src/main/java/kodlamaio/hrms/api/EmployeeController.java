package kodlamaio.hrms.api;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.employeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.employees;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private employeeService EmployeeService;

	public EmployeeController(employeeService employeeService) {
		super();
		EmployeeService = employeeService;
	}
	
    @GetMapping("/getall")
    public DataResult<List<employees>> getAll() {
    	
        return EmployeeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody employees employee) {
        return EmployeeService.add(employee);
    }
}
