package kodlamaio.hrms.dataAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.ForeignLanguage;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage,Integer>{

}
