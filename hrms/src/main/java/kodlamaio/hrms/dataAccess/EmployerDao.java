package kodlamaio.hrms.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.Employers;
public interface EmployerDao extends JpaRepository<Employers,Integer>{
		
		List<Employers> getByWebAdress(String webAdress);
		List<Employers> getByEmail(String email);
		List<Employers> existsByEmail(String email);  
}
