package kodlamaio.hrms.entities;

import java.time.LocalDate;

import javax.persistence.*;

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
    private LocalDate PublishedAt;

    @Column(name="deadline_at")
    private LocalDate DeadlineAt;

    @Column(name="min_salary")
    private int minSalary;

    @Column(name="max_salary")
    private int maxSalary;

    @Column(name="is_active")
    private boolean isActive;
    
    @Column(name="is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted=false;
    
    @ManyToOne()
    @JoinColumn(name="city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name="employer_id", referencedColumnName = "id")
    private employers employer;

    @ManyToOne()
    @JoinColumn(name="job_position_id")
    private jobTitles jobPosition;
    
    
}
