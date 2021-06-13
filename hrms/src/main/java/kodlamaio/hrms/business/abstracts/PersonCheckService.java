package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.Users;

public interface PersonCheckService {

	public boolean checkIfRealPerson(Users user);
}
