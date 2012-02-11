package uk.co.richardgoater.stats;

import org.springframework.web.multipart.MultipartFile;

public interface StatsLoader {
	
	StringBuilder result = new StringBuilder();
	
	String load(MultipartFile file);
	
}
