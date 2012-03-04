package uk.co.richardgoater.stats.upload.excel.jxl;

import java.util.List;

import uk.co.richardgoater.stats.upload.excel.ExcelRow;
import uk.co.richardgoater.stats.upload.excel.ExcelSheet;

import jxl.Sheet;

public class JxlSheet implements ExcelSheet {
	
	Sheet realSheet;
	
	public JxlSheet(Sheet s) {
		realSheet = s;
	}

	@Override
	public List<ExcelRow> getRows() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		return realSheet.getName();
	}

}
