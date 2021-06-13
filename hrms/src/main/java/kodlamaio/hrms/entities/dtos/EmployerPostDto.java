package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class EmployerPostDto extends Users{
	
	private String companyName;
	private String webAdress;
	private String phoneNumber;
	private String passwordRepeat;

}
