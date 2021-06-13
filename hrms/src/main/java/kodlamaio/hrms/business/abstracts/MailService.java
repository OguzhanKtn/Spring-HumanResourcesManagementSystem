package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.Users;

public interface MailService {

	public SuccessResult sendMail(Users user);
}
