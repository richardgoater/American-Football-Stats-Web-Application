package uk.co.richardgoater.stats.tests.upload.excel;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import jxl.read.biff.BiffException;

import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.tests.fake.FakeMultipartFile;
import uk.co.richardgoater.stats.upload.excel.ExcelSheet;
import uk.co.richardgoater.stats.upload.excel.ExcelWorkbook;
import uk.co.richardgoater.stats.upload.excel.jxl.JxlExcelParser;

public class JxlParserTest {

	private FakeMultipartFile file;
	private ExcelWorkbook workBook;
	private List<ExcelSheet> sheets;
		
	@Before
	public void setUp() throws Exception {
		file = new FakeMultipartFile(JxlLearningTest.filePath);
		workBook = new JxlExcelParser().parse(file);
		sheets = workBook.getSheets();
	}

	@Test
	public void shouldGetCorrectWorkBookAndSheets() throws BiffException, IOException {
		
		assertNotNull(workBook);
		
		assertEquals(5, sheets.size());
		assertEquals("Player", sheets.get(0).getTitle());
		assertEquals("Passing", sheets.get(1).getTitle());
		assertEquals("Rushing", sheets.get(2).getTitle());
		assertEquals("Receiving", sheets.get(3).getTitle());
		assertEquals("Defense", sheets.get(4).getTitle());
	}

}
