package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MailService;
import kodlamaio.hrms.business.abstracts.PersonCheckService;
import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.EmployeeDao;
import kodlamaio.hrms.dataAccess.UserDao;
import kodlamaio.hrms.entities.Employees;
import kodlamaio.hrms.entities.Users;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	private MailService mailService;
	private PersonCheckService checkService;
	private Employees employee;
	

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, MailService mailService, PersonCheckService checkService) {
		super();
		this.employeeDao = employeeDao;
		this.mailService = mailService;
		this.checkService = checkService;
		
	}

	@Override
	public DataResult<List<Employees>> getAll() {
		return new SuccessDataResult<List<Employees>>(this.employeeDao.findAll(),"Successfully Listed");
		
	}

	@Override
	public Result add(Employees employee) {
		
		if(employee.getBirthOfDate()==null || employee.getEmail()==null || employee.getFirstName()==null || employee.getLastName()==null
				|| employee.getIdentityNumber()==null || employee.getPassword()==null || employee.getPasswordRepeat()==null) {
			
			return new ErrorResult("All fields are required");
			
		}else
		
		if(!employee.getPassword().equals(employee.getPasswordRepeat())) {
			
			return new ErrorResult("Check your password again");
		}
		
		List<Employees> employees = this.employeeDao.findAll();
		for(Employees Employee : employees) {
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
			this.employeeDao.save(employee);
		return new SuccessDataResult(employee,"Registration has been completed successfully");
			
	}

}
