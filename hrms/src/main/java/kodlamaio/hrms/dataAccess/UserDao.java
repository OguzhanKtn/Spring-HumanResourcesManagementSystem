package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.Users;
public interface UserDao extends JpaRepository<Users,Integer>{

}
