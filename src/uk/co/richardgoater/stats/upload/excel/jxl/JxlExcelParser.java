/**
 * 
 */
package uk.co.richardgoater.stats.upload.excel.jxl;

import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.springframework.web.multipart.MultipartFile;

import uk.co.richardgoater.stats.upload.excel.ExcelParser;
import uk.co.richardgoater.stats.upload.excel.ExcelWorkbook;

public class JxlExcelParser implements ExcelParser {

	public ExcelWorkbook parse(MultipartFile file) {
		
		ExcelWorkbook genericWorkbook = null;
		
		try {
			Workbook wb = Workbook.getWorkbook(file.getInputStream());
			genericWorkbook = new JxlWorkbook(wb);
			
		} catch (BiffException e) {
			
		} catch (IOException e) {
			
		}
		
		return genericWorkbook;
	}

}