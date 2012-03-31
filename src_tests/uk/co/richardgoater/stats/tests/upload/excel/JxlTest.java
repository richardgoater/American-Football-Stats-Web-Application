package uk.co.richardgoater.stats.tests.upload.excel;

import java.io.File;
import java.io.IOException;

import uk.co.richardgoater.stats.upload.excel.ExcelSheet;
import uk.co.richardgoater.stats.upload.excel.jxl.JxlSheet;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public abstract class JxlTest {
	
	String sheetTitle = "Defense";
	
	Sheet getSheet() throws BiffException, IOException {
		Workbook wb = Workbook.getWorkbook(new File(JxlLearningTest.filePath));
		return wb.getSheet(sheetTitle);
	}
	
	Cell[] getCells() throws BiffException, IOException {
		return getSheet().getRow(1);
	}
	
	ExcelSheet getExcelSheet() throws BiffException, IOException {
		return new JxlSheet(getSheet());
	}
	
}
