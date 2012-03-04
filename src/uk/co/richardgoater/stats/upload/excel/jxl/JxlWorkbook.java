package uk.co.richardgoater.stats.upload.excel.jxl;

import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import uk.co.richardgoater.stats.upload.excel.ExcelSheet;
import uk.co.richardgoater.stats.upload.excel.ExcelWorkbook;

public class JxlWorkbook implements ExcelWorkbook {

	Workbook realWorkbook;
	
	public JxlWorkbook(Workbook wb) {
		realWorkbook = wb;
	}

	@Override
	public List<ExcelSheet> getSheets() {
		Sheet[] realSheets = realWorkbook.getSheets();
		List<ExcelSheet> genericSheets = new ArrayList<ExcelSheet>();
		
		for (Sheet s : realSheets) {
			genericSheets.add(new JxlSheet(s));
		}
		return genericSheets;
	}

}
