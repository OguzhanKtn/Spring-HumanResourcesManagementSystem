package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MailService;
import kodlamaio.hrms.business.abstracts.PersonCheckService;
import kodlamaio.hrms.business.abstracts.employeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.employeeDao;
import kodlamaio.hrms.dataAccess.userDao;
import kodlamaio.hrms.entities.employees;
import kodlamaio.hrms.entities.users;

@Service
public class employeeManager implements employeeService{
	
	private employeeDao EmployeeDao;
	private MailService mailService;
	private PersonCheckService checkService;
	

	@Autowired
	public employeeManager(employeeDao EmployeeDao, MailService mailService, PersonCheckService checkService) {
		super();
		this.EmployeeDao = EmployeeDao;
		this.mailService = mailService;
		this.checkService = checkService;
		
	}

	@Override
	public DataResult<List<employees>> getAll() {
		return new SuccessDataResult<List<employees>>(this.EmployeeDao.findAll(),"Successfully Listed");
		
	}

	@Override
	public Result add(employees employee) {
		
		if(employee.getBirthOfDate()==null || employee.getEmail()==null || employee.getFirstName()==null || employee.getLastName()==null
				|| employee.getIdentityNumber()==null || employee.getPassword()==null || employee.getPasswordRepeat()==null) {
			
			return new ErrorResult("All fields are required");
			
		}else
		
		if(!employee.getPassword().equals(employee.getPasswordRepeat())) {
			
			return new ErrorResult("Check your password again");
		}
		
		List<employees> employees = this.EmployeeDao.findAll();
		for(employees Employee : employees) {
			if(employee.getEmail().equals(Employee.getEmail())) {
				
				return new ErrorResult("This e-mail adress has already exist");
			}else
			
			if(employee.getIdentityNumber().equals(Employee.getIdentityNumber())) {
				
				return new ErrorResult("This identity number has already exist");
			
			}
		}
		
		if(checkService.checkIfRealPerson(employee) == false) {
			
			return new ErrorResult("Verification failed");
			
		}else if(checkService.checkIfRealPerson(employee)==true) {
			
			mailService.sendMail(employee);
		}
			
		return new SuccessDataResult(employee,"Registration has been completed successfully");
			
	}

}
