package uk.co.richardgoater.stats.upload.excel;

import org.springframework.web.multipart.MultipartFile;

import jxl.Workbook;

public interface WorkBookLoader {

	Workbook loadWorkBook(MultipartFile file);

}
