package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PersonCheckService;
import kodlamaio.hrms.entities.Users;

@Service
public class PersonCheckManager implements PersonCheckService{

	@Override
	public boolean checkIfRealPerson(Users user) {
		
		return true;
	}

}
