package kodlamaio.hrms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity 
@Table(name="system_personal")
public class systemPersonal extends users{

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    
	 @Column(name="id")
	  private int id;
	 
	 @Column(name="first_name")
	 private String firstName;
	 
	 @Column(name="last_name")
	 private String lastName;
	
}
