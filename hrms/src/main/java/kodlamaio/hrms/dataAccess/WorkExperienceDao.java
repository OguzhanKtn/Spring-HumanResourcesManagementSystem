package kodlamaio.hrms.dataAccess;
import kodlamaio.hrms.entities.WorkExperience;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceDao extends JpaRepository<WorkExperience,Integer>{
	
	List<WorkExperience> getAllByCv_CvIdOrderByEndingDateDesc(int cvId);

}
