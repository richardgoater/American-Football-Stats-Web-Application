package uk.co.richardgoater.stats.upload.excel;

import org.springframework.web.multipart.MultipartFile;

public interface ExcelParser {

	 ExcelWorkbook parse(MultipartFile file);
}
