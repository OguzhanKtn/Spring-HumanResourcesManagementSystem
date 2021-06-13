package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.Employees;

public interface EmployeeDao extends JpaRepository<Employees,Integer>{

}
