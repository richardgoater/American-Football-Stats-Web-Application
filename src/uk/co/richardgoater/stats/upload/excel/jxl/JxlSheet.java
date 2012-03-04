package uk.co.richardgoater.stats.upload.excel.jxl;

import java.util.ArrayList;
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
		List<ExcelRow> list = new ArrayList<ExcelRow>();
		
		for(int i = 0; i < realSheet.getRows(); i++)
			list.add(new JxlRow(realSheet.getRow(i)));
		
		return list;
	}

	@Override
	public String getTitle() {
		return realSheet.getName();
	}

}
