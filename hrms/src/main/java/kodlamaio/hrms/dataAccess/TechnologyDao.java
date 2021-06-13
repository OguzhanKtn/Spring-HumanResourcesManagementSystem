package kodlamaio.hrms.dataAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.Technology;

public interface TechnologyDao extends JpaRepository<Technology,Integer>{

}
