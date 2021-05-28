package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.employees;

public interface employeeDao extends JpaRepository<employees,Integer>{

}
