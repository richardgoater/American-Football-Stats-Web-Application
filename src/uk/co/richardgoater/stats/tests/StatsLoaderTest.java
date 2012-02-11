package uk.co.richardgoater.stats.tests;


import static org.easymock.EasyMock.*;
import jxl.Sheet;
import jxl.Workbook;

import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.StatsLoader;
import uk.co.richardgoater.stats.upload.ExcelStatsLoader;
import uk.co.richardgoater.stats.upload.excel.WorkBookLoader;

public class StatsLoaderTest {

	StatsLoader statsLoader;
	WorkBookLoader workBookLoader;
	private Workbook expectedWorkbook;
	@Before
	public void setUp() throws Exception {
		workBookLoader = createMock(WorkBookLoader.class);
		statsLoader = new ExcelStatsLoader(workBookLoader);
		expectedWorkbook = createMock(Workbook.class);
	}
	
	@Test
	public void shouldGetWorkBook(){
		TestFile file = new TestFile();
		expect(workBookLoader.loadWorkBook(file)).andReturn(expectedWorkbook);
		replay(workBookLoader);
		
		statsLoader.load(file);
		
		verify(workBookLoader);
	}
	
	@Test
	public void shouldGetFirstSheet(){
		TestFile file = new TestFile();
		
		expect(expectedWorkbook.getSheet(0)).andReturn(null);
		expect(workBookLoader.loadWorkBook(file)).andReturn(expectedWorkbook);
		replay(workBookLoader);
		replay(expectedWorkbook);
		statsLoader.load(file);
		
		verify(expectedWorkbook);
	}

}
