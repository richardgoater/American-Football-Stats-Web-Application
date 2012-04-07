package uk.co.richardgoater.stats.upload;

import org.springframework.web.multipart.MultipartFile;

import uk.co.richardgoater.stats.upload.UploadResponse;
import uk.co.richardgoater.stats.upload.mvc.WebUploadResponse;

public interface StatsLoader {
	
	UploadResponse response = new WebUploadResponse();
	
	UploadResponse load(MultipartFile file, int seasonid, int weeknum);

}
