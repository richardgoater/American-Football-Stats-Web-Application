package uk.co.richardgoater.stats.tests.upload;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.persistence.dao.DefenseStatsDAO;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;
import uk.co.richardgoater.stats.persistence.dao.AbstractStatsDAO;
import uk.co.richardgoater.stats.upload.excel.ExcelCell;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;
import uk.co.richardgoater.stats.upload.excel.mapping.DefenseRowMapper;


public class DefenseRowMapperTest {
	
	private DefenseRowMapper defenseRowMapper;
	private ExcelRow mockRow;
	private AbstractStatsDAO mockDAO;
	private ExcelCell mockCell;
	
	private DefenseGameData mappedDefenseGameData;
	private String playerName = "Dave Bright";
	private int playerid = 50;
	private int tckl = 8;
	private int solo = 7;
	private int assist = 1;
	private double sck = 2.0;
	private int sckYds = 6;
	private int qbHurry = 1;
	private int ints = 1;
	private int intYds = 1;
	private int bp = 1;
	private int ff = 1;
	private int fr = 1;
	private int frYds = 1;
	private int td = 1;
	private int safety = 1;
	private int bk = 1;
	
	
	@Before
	public void setUp() {
		setUpMocks();
		setExpectations();
		
		defenseRowMapper = new DefenseRowMapper();
		defenseRowMapper.setDAO(mockDAO);
		
		mappedDefenseGameData = (DefenseGameData) defenseRowMapper.map(mockRow);
	}

	private void setUpMocks() {
		mockRow = createMock(ExcelRow.class);
		mockDAO = createMock(DefenseStatsDAO.class);
		mockCell = createMock(ExcelCell.class);
	}
	
	private void setExpectations() {
		mockRow.resetIterator();
		expectLastCall();
		expect(mockRow.nextCell()).andReturn(mockCell).times(16);
		replay(mockRow);
		
		setCellExpectations();
		
		expect(mockDAO.getPlayeridForName(playerName)).andReturn(playerid);
		replay(mockDAO);
	}

	private void setCellExpectations() {
		expect(mockCell.asString()).andReturn(playerName);
		expect(mockCell.asInt()).andReturn(tckl);
		expect(mockCell.asInt()).andReturn(solo);
		expect(mockCell.asInt()).andReturn(assist);
		expect(mockCell.asDouble()).andReturn(sck);
		expect(mockCell.asInt()).andReturn(sckYds);
		expect(mockCell.asInt()).andReturn(qbHurry);
		expect(mockCell.asInt()).andReturn(ints);
		expect(mockCell.asInt()).andReturn(intYds);
		expect(mockCell.asInt()).andReturn(bp);
		expect(mockCell.asInt()).andReturn(ff);
		expect(mockCell.asInt()).andReturn(fr);
		expect(mockCell.asInt()).andReturn(frYds);
		expect(mockCell.asInt()).andReturn(td);
		expect(mockCell.asInt()).andReturn(safety);
		expect(mockCell.asInt()).andReturn(bk);
		replay(mockCell);
	}

	@Test
	public void returnsCorrectDAOType() {
		StatsDAO dao = defenseRowMapper.getDAO();
		
		assertNotNull(dao);
		assertTrue(dao instanceof DefenseStatsDAO);
	}
	
	@Test
	public void returnsCorrectGameDataType() {
		assertNotNull(mappedDefenseGameData);
	}
	
	@Test
	public void verifyRow() {
		verify(mockRow);
	}
	
	@Test
	public void verifyCells() {
		verify(mockCell);
	}
	
	@Test
	public void mapsPlayerID() {		
		assertEquals(playerid, mappedDefenseGameData.getPlayerid());
	}
	
	@Test
	public void mapsTackles() {
		assertEquals(tckl, mappedDefenseGameData.getTckl());
	}
	
	@Test
	public void mapsSolo() {
		assertEquals(solo, mappedDefenseGameData.getSolo());
	}
	
	@Test
	public void mapsAssist() {
		assertEquals(assist, mappedDefenseGameData.getAssist());
	}
	
	@Test
	public void mapsSck() {
		assertEquals(sck, mappedDefenseGameData.getSck(), 0);
	}
	
	@Test
	public void mapsQBHurry() {
		assertEquals(qbHurry, mappedDefenseGameData.getQbHurry());
	}
	
	@Test
	public void mapsInts() {
		assertEquals(ints, mappedDefenseGameData.getInts());
	}
	
	@Test
	public void mapsIntYds() {
		assertEquals(intYds, mappedDefenseGameData.getIntYds());
	}
	
	@Test
	public void mapsBp() {
		assertEquals(bp, mappedDefenseGameData.getBp());
	}
	
	@Test
	public void mapsFf() {
		assertEquals(ff, mappedDefenseGameData.getFf());
	}
	
	@Test
	public void mapsFr() {
		assertEquals(fr, mappedDefenseGameData.getFr());
	}
	
	@Test
	public void mapsFrYds() {
		assertEquals(frYds, mappedDefenseGameData.getFrYds());
	}
	
	@Test
	public void mapsTd() {
		assertEquals(td, mappedDefenseGameData.getTd());
	}
	
	@Test
	public void mapsSafety() {
		assertEquals(safety, mappedDefenseGameData.getSafety());
	}
	
	@Test
	public void mapsBk() {
		assertEquals(bk, mappedDefenseGameData.getBk());
	}	
	
}
