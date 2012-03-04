package uk.co.richardgoater.stats.upload;

import org.springframework.web.multipart.MultipartFile;

public interface StatsLoader {
	
	StringBuilder result = new StringBuilder();
	
	String load(MultipartFile file, int seasonid, int weeknum);

}
