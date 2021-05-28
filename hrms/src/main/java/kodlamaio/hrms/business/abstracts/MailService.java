package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.users;

public interface MailService {

	public SuccessResult sendMail(users user);
}
