package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.employers;
public interface employerDao extends JpaRepository<employers,Integer>{

}
