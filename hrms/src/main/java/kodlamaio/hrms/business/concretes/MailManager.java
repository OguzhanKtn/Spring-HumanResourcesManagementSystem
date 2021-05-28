package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MailService;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.users;

@Service
public class MailManager implements MailService{

	@Override
	public SuccessResult sendMail(users user) {
		
		return new SuccessResult("verification link has been sent to your e-mail address");
		
	}

}
