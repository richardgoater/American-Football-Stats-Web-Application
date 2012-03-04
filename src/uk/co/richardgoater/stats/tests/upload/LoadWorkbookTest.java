package uk.co.richardgoater.stats.tests.upload;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jxl.read.biff.BiffException;

import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.tests.fake.FakeMultipartFile;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;
import uk.co.richardgoater.stats.upload.excel.ExcelSheet;
import uk.co.richardgoater.stats.upload.excel.ExcelStatsLoader;
import uk.co.richardgoater.stats.upload.excel.ExcelWorkbook;
import uk.co.richardgoater.stats.upload.excel.jxl.JxlRow;
import uk.co.richardgoater.stats.upload.excel.jxl.JxlExcelParser;
import uk.co.richardgoater.stats.upload.excel.mapping.ExcelRowMapper;

public class LoadWorkbookTest {
	
	private ExcelStatsLoader statsLoader;
	private ExcelWorkbook mockWorkbook;
	private JxlExcelParser mockJxlParser;
	private FakeMultipartFile file;
	private ExcelSheet mockSheet;
	private ExcelRow fakeRow;
	private Map<String, ExcelRowMapper> mockMap;
	private String dataType = "Defense";
	private int seasonid = 1;
	private int weeknum = 5;
	
	@Before
	public void setUp() throws Exception {
		setUpMocks();
		setExpectations();
		
		statsLoader = new ExcelStatsLoader(mockJxlParser);
		statsLoader.setRowMappers(mockMap);
	}
	
	@SuppressWarnings("unchecked")
	private void setUpMocks() {
		mockJxlParser = createMock(JxlExcelParser.class);
		mockWorkbook = createMock(ExcelWorkbook.class);
		file = new FakeMultipartFile(JxlLearningTest.filePath);
		mockSheet = createMock(ExcelSheet.class);
		fakeRow = new JxlRow();
		mockMap = createMock(Map.class);
	}
	
	private void setExpectations() {
		expect(mockJxlParser.parse(file)).andReturn(mockWorkbook);
		replay(mockJxlParser);
		
		expect(mockWorkbook.getSheets()).andReturn(getTestSheets());
		replay(mockWorkbook);
		
		expect(mockSheet.getRows()).andReturn(getTestRows());
		expect(mockSheet.getTitle()).andReturn(dataType);
		replay(mockSheet);
	}
	
	private List<ExcelSheet> getTestSheets() {
		List<ExcelSheet> list = new ArrayList<ExcelSheet>();
		list.add(mockSheet);
		return list;
	}
	
	private List<ExcelRow> getTestRows() {
		List<ExcelRow> list = new ArrayList<ExcelRow>();
		list.add(fakeRow);
		return list;
	}
	
	@Test
	public void shouldAttemptToGetWorkBookSheetsAndRows() throws BiffException, IOException {	
				
		statsLoader.load(file, seasonid, weeknum);
		
		verify(mockJxlParser);
		verify(mockWorkbook);
		verify(mockSheet);
	}
	
	@Test
	public void shouldSetSeasonidAndWeeknumOnRow() {
				
		statsLoader.load(file, seasonid, weeknum);

		assertEquals(seasonid, fakeRow.getSeasonid());
		assertEquals(weeknum, fakeRow.getWeeknum());
	}
	
	

}
