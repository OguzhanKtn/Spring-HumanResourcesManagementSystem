package kodlamaio.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.Photo;

public interface PhotoService {

	 Result add(Photo photo, MultipartFile multipartFile) throws IOException;
	
	 Result update(int cvId, MultipartFile multipartFile) throws IOException;
	
	 Result delete(String id) throws IOException;
}
