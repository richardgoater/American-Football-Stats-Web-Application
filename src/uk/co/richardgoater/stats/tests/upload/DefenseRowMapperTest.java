package uk.co.richardgoater.stats.tests.upload;

import static org.easymock.EasyMock.createMock;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.persistence.dao.DefenseStatsDAO;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;
import uk.co.richardgoater.stats.upload.excel.mapping.DefenseRowMapper;


public class DefenseRowMapperTest {
	
	private DefenseRowMapper defenseRowMapper;
	private ExcelRow mockRow;
	private DefenseStatsDAO mockDAO;

	@Before
	public void setUp() {
		setUpMocks();
		setExpectations();
		
		defenseRowMapper = new DefenseRowMapper();
		defenseRowMapper.setDAO(mockDAO);
	}

	private void setUpMocks() {
		mockRow = createMock(ExcelRow.class);
		mockDAO = createMock(DefenseStatsDAO.class);
	}
	
	private void setExpectations() {
		
	}
	
	@Test
	public void returnsCorrectDAOType() {
		StatsDAO dao = defenseRowMapper.getDAO();
		
		assertNotNull(dao);
		assertTrue(dao instanceof DefenseStatsDAO);
	}
	
	@Test
	public void returnsCorrectGameDataType() {
		Object mappedObject = defenseRowMapper.map(mockRow);
		
		assertNotNull(mappedObject);
		assertTrue(mappedObject instanceof DefenseGameData);
	}
	
}
