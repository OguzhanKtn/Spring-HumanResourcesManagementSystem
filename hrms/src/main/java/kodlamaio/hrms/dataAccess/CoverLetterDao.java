package kodlamaio.hrms.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter,Integer>{

	
}
