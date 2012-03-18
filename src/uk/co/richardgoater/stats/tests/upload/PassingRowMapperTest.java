package uk.co.richardgoater.stats.tests.upload;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.co.richardgoater.stats.persistence.PassingGameData;
import uk.co.richardgoater.stats.upload.excel.mapping.PassingRowMapper;


public class PassingRowMapperTest extends RowMapperTest { 
	
	private PassingRowMapper passingRowMapper;
	private PassingGameData mappedPassingGameData;
	
	@Override
	protected void setPlayerName() {playerName = "Martin Brown";}
	private int att = 20;
	private int comp = 9;
	private int yds = 147;
	private String displayLong = "56T";
	private int longest = 56;
	private boolean isLongTD = true;
	private int td = 3;
	private int ints = 1;
	private int sck = 1;
	private int sackYds = 1;
	
	@Override
	protected void instantiateRowMapper() {
		passingRowMapper = new PassingRowMapper();
		passingRowMapper.setDao(mockDAO);
	}

	@Override
	protected void mapGameData() {
		mappedPassingGameData = (PassingGameData) passingRowMapper.map(mockRow);
	}
	
	@Override
	protected void setMapperRowExpectations() {
		setNextCellNumberOfTimesExpectation(9);
	}
	
	@Override
	protected void setMapperCellExpectations() {
		expect(mockCell.asInt()).andReturn(att);
		expect(mockCell.asInt()).andReturn(comp);
		expect(mockCell.asInt()).andReturn(yds);
		expect(mockCell.asString()).andReturn(displayLong);
		expect(mockCell.asInt()).andReturn(td);
		expect(mockCell.asInt()).andReturn(ints);
		expect(mockCell.asInt()).andReturn(sck);
		expect(mockCell.asInt()).andReturn(sackYds);
	}
	
	@Test
	public void mapsAttempts() {
		assertEquals(att, mappedPassingGameData.getAtt());
	}
	
	@Test
	public void mapsCompletions() {
		assertEquals(comp, mappedPassingGameData.getComp());
	}
	
	@Test
	public void mapsyards() {
		assertEquals(yds, mappedPassingGameData.getYds());
	}
	
	@Test
	public void mapsLongest() {
		assertEquals(longest, mappedPassingGameData.getLongest());
	}
	
	@Test
	public void mapsIsLongTD() {
		assertEquals(isLongTD, mappedPassingGameData.isLongTD());
	}
	
	@Test
	public void mapsInterceptions() {
		assertEquals(ints, mappedPassingGameData.getInts());
	}
	
	@Test
	public void mapsSacks() {
		assertEquals(sck, mappedPassingGameData.getSck());
	}
	
	@Test
	public void mapsSackYards() {
		assertEquals(sackYds, mappedPassingGameData.getSackYds());
	}
	
	@Test
	public void mapsSeasonid() {
		assertEquals(seasonid, mappedPassingGameData.getSeasonid());
	}
	
	@Test
	public void mapsWeeknum() {
		assertEquals(weeknum, mappedPassingGameData.getWeeknum());
	}
	
}
