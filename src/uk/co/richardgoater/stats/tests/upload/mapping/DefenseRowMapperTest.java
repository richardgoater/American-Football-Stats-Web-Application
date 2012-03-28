package uk.co.richardgoater.stats.tests.upload.mapping;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.upload.excel.mapping.DefenseRowMapper;


public class DefenseRowMapperTest extends RowMapperTest {
	
	private DefenseRowMapper defenseRowMapper;
	
	private DefenseGameData mappedDefenseGameData;
	
	@Override
	protected void setPlayerName() {playerName = "Dave Bright";}
	
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
	
	@Override
	protected void instantiateRowMapper() {
		defenseRowMapper = new DefenseRowMapper();
		defenseRowMapper.setDao(mockDAO);
	}

	@Override
	protected void mapGameData() {
		mappedDefenseGameData = (DefenseGameData) defenseRowMapper.map(mockRow);
	}
	
	@Override
	protected void setMapperRowExpectations() {
		setNextCellNumberOfTimesExpectation(16);
	}
	
	@Override
	protected void setMapperCellExpectations() {
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
	
	@Test
	public void mapsSeasonid() {
		assertEquals(seasonid, mappedDefenseGameData.getSeasonid());
	}
	
	@Test
	public void mapsWeeknum() {
		assertEquals(weeknum, mappedDefenseGameData.getWeeknum());
	}
	
}
