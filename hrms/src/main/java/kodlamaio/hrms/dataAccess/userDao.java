package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.users;
public interface userDao extends JpaRepository<users,Integer>{

}
