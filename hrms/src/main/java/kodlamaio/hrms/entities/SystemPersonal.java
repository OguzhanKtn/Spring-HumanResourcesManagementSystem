package kodlamaio.hrms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity 
@Table(name="system_personal")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id") 
public class SystemPersonal extends Users{
	 
	 @Column(name="first_name")
	 private String firstName;
	 
	 @Column(name="last_name")
	 private String lastName;
	
}
