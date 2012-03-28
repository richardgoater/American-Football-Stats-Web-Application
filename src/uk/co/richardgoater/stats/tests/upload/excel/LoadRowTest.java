package uk.co.richardgoater.stats.tests.upload.excel;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.persistence.dao.StatsDAO;
import uk.co.richardgoater.stats.tests.fake.FakeMultipartFile;
import uk.co.richardgoater.stats.upload.StatsUploadException;
import uk.co.richardgoater.stats.upload.excel.ExcelParser;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;
import uk.co.richardgoater.stats.upload.excel.ExcelStatsLoader;
import uk.co.richardgoater.stats.upload.excel.jxl.JxlExcelParser;
import uk.co.richardgoater.stats.upload.excel.mapping.ExcelRowMapper;

public class LoadRowTest {
	
	public ExcelStatsLoader statsLoaderWithMockMap;
	public ExcelStatsLoader statsLoaderWithRealMap;
	public FakeMultipartFile file;
	public ExcelRow mockRow;
	public ExcelRowMapper mockRowMapper;
	public Map<String, ExcelRowMapper> mockMap;
	public String dataType = "Defense";
	public String incorrectDataType;
	public int seasonid = 1;
	public int weeknum = 1;
	public StatsDAO mockStatsDAO;
	private ExcelParser mockJxlParser;
	
	@Before
	public void setUp() throws StatsUploadException {
		setUpMocks();
		setExpectations();
		
		statsLoaderWithMockMap = new ExcelStatsLoader(mockJxlParser);
		statsLoaderWithMockMap.setRowMappers(mockMap);
		
		statsLoaderWithRealMap = new ExcelStatsLoader(mockJxlParser);
		statsLoaderWithRealMap.setRowMappers(getRowMappers());
	}
	
	@SuppressWarnings("unchecked")
	private void setUpMocks() {
		mockStatsDAO = createMock(StatsDAO.class);
		mockRow = createMock(ExcelRow.class);
		mockRowMapper = createMock(ExcelRowMapper.class);
		mockJxlParser = createMock(JxlExcelParser.class);
		mockMap = createMock(Map.class);	
	}
	
	private void setExpectations() throws StatsUploadException {
		expect(mockRowMapper.getDao()).andReturn(mockStatsDAO);
		expect(mockRowMapper.map(mockRow)).andReturn(null);
		replay(mockRowMapper);
		
		expect(mockMap.get(dataType)).andReturn(null);
		replay(mockMap);
	}
	
	private HashMap<String, ExcelRowMapper> getRowMappers() {
		HashMap<String, ExcelRowMapper> map = new HashMap<String, ExcelRowMapper>();
		map.put(dataType, mockRowMapper);
		return map;
	}
	
	@Test
	public void shouldAttemptToFetchDataMapper() {		
		statsLoaderWithMockMap.loadRow(mockRow, dataType);
		verify(mockMap);
	}
	
	@Test
	public void shouldReturnErrorMessageForUnknownType() {
		String result = statsLoaderWithRealMap.loadRow(mockRow, incorrectDataType);
		assertEquals("Unknown Datatype: '" + incorrectDataType + "'", result);
	}
	
	@Test
	public void shouldAttemptToMapData() {
		statsLoaderWithRealMap.loadRow(mockRow, dataType);
		verify(mockRowMapper);
	}
	
	@Test
	public void shouldNotReturnErrorMessageForCorrectType() {
		String result = statsLoaderWithRealMap.loadRow(mockRow, dataType);
		assertTrue(!result.contains("Unknown Datatype"));
	}
}