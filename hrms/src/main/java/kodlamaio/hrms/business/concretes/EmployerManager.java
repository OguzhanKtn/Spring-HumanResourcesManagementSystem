package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ApprovalOfSystemPersonalService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.MailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.EmployerDao;
import kodlamaio.hrms.entities.Employers;
import kodlamaio.hrms.entities.dtos.EmployerPostDto;
import kodlamaio.hrms.entities.Employees;


@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao; 
	private MailService mailService;
	private ApprovalOfSystemPersonalService confirmation; 
	private ModelMapper modelMapper;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, MailService mailService,
			ApprovalOfSystemPersonalService confirmation,ModelMapper modelMapper) {
		super();
		this.employerDao = employerDao;
		this.mailService = mailService;
		this.confirmation = confirmation;
		this.modelMapper = modelMapper;
	}

	
	
	@Override
	public DataResult<List<Employers>> getAll() {
		
		return new SuccessDataResult<List<Employers>>(this.employerDao.findAll(),"Successfully Listed");
	}

	@Override
	public Result add(EmployerPostDto employer) {
		
		Employers employer2 = this.modelMapper.map(employer,Employers.class);
		
		if(employer.getCompanyName() == null || employer.getEmail() == null || employer.getPassword() == null ||
		   employer.getPasswordRepeat() == null || employer.getPhoneNumber() == null || employer.getWebAdress() == null) {
			
			return new ErrorResult ("All fields are required");
			
			
		} 
		
		
		if(!employer.getPassword().equals(employer.getPasswordRepeat())) {
			
			return new ErrorResult("Check your password again");
			
		}
		
		 
            String[] domainsWebsite = employer.getWebAdress().split("[.]", 2); 
            String[] domainsMail = employer.getEmail().split("[@]+", 0); 
            if (!domainsMail[domainsMail.length - 1].equals(domainsWebsite[domainsWebsite.length - 1])) {
            	
            	return new ErrorResult("invalid e-mail adress"); 
          }
            	
		
		
		
		List<Employers> employers = this.employerDao.findAll();
		for(Employers Employer : employers) {
			if(employer.getEmail().equals(Employer.getEmail())) {
				
				return new ErrorResult("This e-mail adress has already exist");
				
			}
			
		}
		
		
		if(confirmation.confirmation(employer2)==false) {
			
			return new ErrorResult("Verification failed");
			
		}else if(confirmation.confirmation(employer2)==true) {
			
			mailService.sendMail(employer);
		}
			this.employerDao.save(employer2);
		return new SuccessResult("Registration has been completed successfully");
	}

	

	

}
