package kodlamaio.hrms.entities;









import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_advertisements")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name="open_position_count")
    private int openPositionCount;

    @Column(name="published_at")
    private LocalDateTime PublishedAt;

    @Column(name="deadline_at")
    private String DeadlineAt;

    @Column(name="min_salary")
    private int minSalary;

    @Column(name="max_salary")
    private int maxSalary;

    @Column(name="is_active",columnDefinition = "boolean default true")
    private boolean isActive; 
    
    @Column(name="is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;
    
    @Column(name="created_at", columnDefinition = "Date default CURRENT_DATE")
    private LocalDateTime createdAt=LocalDateTime.now();
    
  
    @ManyToOne()
    @JoinColumn(name="city_id") 
    private City city;

   
    @ManyToOne()
    @JoinColumn(name="employer_id") 
    private Employers employer; 
    
    
    @ManyToOne()
    @JoinColumn(name="job_title_id")
    private JobTitles jobTitle; 

     
}     
