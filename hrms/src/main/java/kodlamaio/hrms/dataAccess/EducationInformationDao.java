package kodlamaio.hrms.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.EducationInformation;

public interface EducationInformationDao extends JpaRepository<EducationInformation,Integer>{
	
	List<EducationInformation> getAllByCv_CvIdOrderByGraduationDateDesc(int cvId);
	
}
