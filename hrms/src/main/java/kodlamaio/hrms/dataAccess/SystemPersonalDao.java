package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.SystemPersonal;
public interface SystemPersonalDao extends JpaRepository<SystemPersonal,Integer>{

}
