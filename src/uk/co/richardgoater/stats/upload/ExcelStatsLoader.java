package uk.co.richardgoater.stats.upload;

import jxl.Workbook;

import org.springframework.web.multipart.MultipartFile;

import uk.co.richardgoater.stats.StatsLoader;
import uk.co.richardgoater.stats.upload.excel.WorkBookLoader;

public class ExcelStatsLoader extends StatsLoaderDAOSupport implements StatsLoader {

	private WorkBookLoader workBookLoader;
	
	
	public ExcelStatsLoader(WorkBookLoader workBookLoader){
		this.workBookLoader = workBookLoader;
	}
	
	@Override
	public String load(MultipartFile file) {
		Workbook workbook = workBookLoader.loadWorkBook(file);
		workbook.getSheet(0);
		return file.getOriginalFilename() + "!!!";
	}

}
