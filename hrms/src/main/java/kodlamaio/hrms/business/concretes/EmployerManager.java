package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ApprovalOfSystemPersonalService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.MailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.employerDao;
import kodlamaio.hrms.entities.employees;
import kodlamaio.hrms.entities.employers;

@Service
public class EmployerManager implements EmployerService{
	
	private employerDao EmployerDao;
	private MailService mailService;
	private ApprovalOfSystemPersonalService confirmation;

	@Autowired
	public EmployerManager(employerDao employerDao, MailService mailService,
			ApprovalOfSystemPersonalService confirmation) {
		super();
		EmployerDao = employerDao;
		this.mailService = mailService;
		this.confirmation = confirmation;
	}

	@Override
	public DataResult<List<employers>> getAll() {
		
		return new SuccessDataResult<List<employers>>(this.EmployerDao.findAll(),"Successfully Listed");
	}

	@Override
	public Result add(employers employer) {
		
		 Pattern mailPatern = Pattern.compile("[a-z A-Z 0-9]+@[a-z A-Z 0-9]+\\.[a-z A-Z 0-9]+$");
         Matcher mailmatcher = mailPatern.matcher(employer.getEmail());
		
		if(employer.getCompanyName() == null || employer.getEmail() == null || employer.getPassword() == null ||
		   employer.getPasswordRepeat() == null || employer.getPhoneNumber() == null || employer.getWebAdress() == null) {
			
			return new ErrorResult ("All fields are required");
			
			
			
		}else if(employer.getPassword() != employer.getPasswordRepeat()) {
			
			return new ErrorResult("Check your password again");
			
		}else if(mailmatcher.matches()) {
            String[] domainsWebsite = employer.getWebAdress().split("[.]+");
            String[] domainsMail = employer.getEmail().split("[.]+");
            
            if (domainsMail[domainsMail.length - 1] !=  domainsWebsite[domainsWebsite.length - 1]) {
            	
            	return new ErrorResult("invalid e-mail adress");
            }
		}
		
		
		List<employers> employers = this.EmployerDao.findAll();
		for(employers Employer : employers) {
			if(employer.getEmail().equals(Employer.getEmail())) {
				
				return new ErrorResult("This e-mail adress has already exist");
				
			}
			
		}
		if(confirmation.confirmation(employer)==false) {
			
			return new ErrorResult("Verification failed");
			
		}else if(confirmation.confirmation(employer)==true) {
			
			mailService.sendMail(employer);
		}
		return new SuccessDataResult(employer,"Registration has been completed successfully");
	}

}
