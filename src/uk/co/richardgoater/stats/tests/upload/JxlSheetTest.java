package uk.co.richardgoater.stats.tests.upload;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.upload.excel.ExcelRow;
import uk.co.richardgoater.stats.upload.excel.jxl.JxlSheet;

public class JxlSheetTest extends JxlTest {
	
	private JxlSheet sheet;

	@Before
	public void setUp() throws BiffException, IOException {		
		sheet = new JxlSheet(getSheet());
	}
	
	@Test
	public void returnsAList() {
		assertNotNull(sheet.getRows());
	}
	
	@Test
	public void returnsCorrectNumberOfRows() throws BiffException, IOException {
		List<ExcelRow> rows = sheet.getRows();
		assertEquals(getSheet().getRows(), rows.size());
	}
	
	@Test
	public void returnsCorrectSheetTitle() {
		assertEquals(sheetTitle, sheet.getTitle());
	}
}
