package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.JobTitles;
public interface JobTitleDao extends JpaRepository<JobTitles,Integer>{

}
