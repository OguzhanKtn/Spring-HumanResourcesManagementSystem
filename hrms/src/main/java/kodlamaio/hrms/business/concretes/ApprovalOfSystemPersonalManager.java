package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ApprovalOfSystemPersonalService;
import kodlamaio.hrms.entities.employers;
@Service
public class ApprovalOfSystemPersonalManager implements ApprovalOfSystemPersonalService{

	@Override
	public boolean confirmation(employers employer) {
		
		return true;
	}

}
