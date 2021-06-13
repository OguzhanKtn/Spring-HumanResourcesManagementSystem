package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.PhotoDao;
import kodlamaio.hrms.entities.Photo;

@Service
public class PhotoManager implements PhotoService{
	private PhotoDao photoDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao, CloudinaryService cloudinaryService) {
		super();
		this.photoDao = photoDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(Photo photo, MultipartFile multipartFile) throws IOException {
		
		Result result= new ErrorResult("Fotoğraf Eklenemedi!");
		Map photoMap = cloudinaryService.photoUpload(multipartFile);
		photo.setPhotoUrl(photoMap.get("url").toString());
		if(!this.photoDao.getAllCvId().contains(photo.getCv().getCvId())) {
			result = new SuccessResult("Fotoğraf Eklendi");
			this.photoDao.save(photo);
		}
		return result;
			
		
		
	}
	@Override
	public Result delete(String id) throws IOException {
		this.cloudinaryService.photoDelete(id);
		return new SuccessResult("Photograph has deleted");
	}

	@Override
	public Result update(int cvId, MultipartFile multipartFile) throws IOException {
		Map photoMap = cloudinaryService.photoUpload(multipartFile);
		this.photoDao.updatePhotoSetPhotoUrlForCv_cvId(photoMap.get("url").toString(), cvId);
		return new SuccessResult("Fotoğraf Güncellendi");
	}

}
