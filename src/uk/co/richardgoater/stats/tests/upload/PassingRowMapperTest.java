package uk.co.richardgoater.stats.tests.upload;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.persistence.dao.DefenseStatsDAO;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;
import uk.co.richardgoater.stats.upload.excel.mapping.PassingRowMapper;


public class PassingRowMapperTest extends RowMapperTest { 
	
	private PassingRowMapper passingRowMapper;
	private DefenseGameData mappedPassingGameData;
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
		
		passingRowMapper = new PassingRowMapper();
		passingRowMapper.setDAO(mockDAO);
		
		mappedPassingGameData = (DefenseGameData) passingRowMapper.map(mockRow);
	}

	protected void setCellExpectations() {
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
		StatsDAO dao = passingRowMapper.getDAO();
		
		assertNotNull(dao);
		assertTrue(dao instanceof DefenseStatsDAO);
	}
	
	@Test
	public void returnsCorrectGameDataType() {
		assertNotNull(mappedPassingGameData);
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
		assertEquals(playerid, mappedPassingGameData.getPlayerid());
	}
	
	@Test
	public void mapsTackles() {
		assertEquals(tckl, mappedPassingGameData.getTckl());
	}
	
	@Test
	public void mapsSolo() {
		assertEquals(solo, mappedPassingGameData.getSolo());
	}
	
	@Test
	public void mapsAssist() {
		assertEquals(assist, mappedPassingGameData.getAssist());
	}
	
	@Test
	public void mapsSck() {
		assertEquals(sck, mappedPassingGameData.getSck(), 0);
	}
	
	@Test
	public void mapsQBHurry() {
		assertEquals(qbHurry, mappedPassingGameData.getQbHurry());
	}
	
	@Test
	public void mapsInts() {
		assertEquals(ints, mappedPassingGameData.getInts());
	}
	
	@Test
	public void mapsIntYds() {
		assertEquals(intYds, mappedPassingGameData.getIntYds());
	}
	
	@Test
	public void mapsBp() {
		assertEquals(bp, mappedPassingGameData.getBp());
	}
	
	@Test
	public void mapsFf() {
		assertEquals(ff, mappedPassingGameData.getFf());
	}
	
	@Test
	public void mapsFr() {
		assertEquals(fr, mappedPassingGameData.getFr());
	}
	
	@Test
	public void mapsFrYds() {
		assertEquals(frYds, mappedPassingGameData.getFrYds());
	}
	
	@Test
	public void mapsTd() {
		assertEquals(td, mappedPassingGameData.getTd());
	}
	
	@Test
	public void mapsSafety() {
		assertEquals(safety, mappedPassingGameData.getSafety());
	}
	
	@Test
	public void mapsBk() {
		assertEquals(bk, mappedPassingGameData.getBk());
	}

	@Override
	protected void setPlayerName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setPlayerID() {
		// TODO Auto-generated method stub
		
	}	
	
}
