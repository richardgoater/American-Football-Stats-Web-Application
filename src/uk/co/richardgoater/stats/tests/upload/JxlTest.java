package uk.co.richardgoater.stats.tests.upload;

import java.io.File;
import java.io.IOException;

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
		return getSheet().getRow(0);
	}
	
}
