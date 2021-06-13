package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import kodlamaio.hrms.entities.JobAdvertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
   public class JobAdvertisementPostDto {
	  
	private int id;
	private String jobDescription;
	private int openPositionCount;
	private LocalDateTime PublishedAt;
	private String DeadlineAt;
	private int minSalary;
	private int maxSalary;
	private int cityId;
	private int employerId;
	private int jobTitleId;
	 
	 
	 
	 
	 
	 
	 
}
