package kodlamaio.hrms.dataAccess;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.Cv;
public interface CvDao extends JpaRepository<Cv,Integer> {
	
	List<Cv> getAllByEmployeeId(int employeeId);
}
