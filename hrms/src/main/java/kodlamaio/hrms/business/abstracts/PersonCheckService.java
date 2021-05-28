package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.users;

public interface PersonCheckService {

	public boolean checkIfRealPerson(users user);
}
