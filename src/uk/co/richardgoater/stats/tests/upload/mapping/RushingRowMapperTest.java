package uk.co.richardgoater.stats.tests.upload.mapping;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.co.richardgoater.stats.persistence.RushingGameData;
import uk.co.richardgoater.stats.upload.excel.mapping.RushingRowMapper;


public class RushingRowMapperTest extends RowMapperTest { 
	
	private RushingRowMapper rushingRowMapper;
	private RushingGameData mappedRushingGameData;
	
	@Override
	protected void setPlayerName() {playerName = "Craig Edmunds";}
	private int att = 5;
	private int yds = 69;
	private String displayLong = "46T";
	private int longest = 46;
	private boolean isLongTD = true;
	private int td = 2;
	
	
	
	@Override
	protected void instantiateRowMapper() {
		rushingRowMapper = new RushingRowMapper();
		rushingRowMapper.setDao(mockDAO);
	}

	@Override
	protected void mapGameData() {
		mappedRushingGameData = (RushingGameData) rushingRowMapper.map(mockRow);
	}
	
	@Override
	protected void setMapperRowExpectations() {
		setNextCellNumberOfTimesExpectation(5);
	}
	
	@Override
	protected void setMapperCellExpectations() {
		expect(mockCell.asInt()).andReturn(att);
		expect(mockCell.asInt()).andReturn(yds);
		expect(mockCell.asString()).andReturn(displayLong);
		expect(mockCell.asInt()).andReturn(td);
	}
	
	@Test
	public void mapsAttempts() {
		assertEquals(att, mappedRushingGameData.getAtt());
	}	
	
	@Test
	public void mapsyards() {
		assertEquals(yds, mappedRushingGameData.getYds());
	}
	
	@Test
	public void mapsLongest() {
		assertEquals(longest, mappedRushingGameData.getLongest());
	}
	
	@Test
	public void mapsIsLongTD() {
		assertEquals(isLongTD, mappedRushingGameData.isLongTD());
	}
	
	@Test
	public void mapsTd() {
		assertEquals(td, mappedRushingGameData.getTd());
	}
	
	@Test
	public void mapsSeasonid() {
		assertEquals(seasonid, mappedRushingGameData.getSeasonid());
	}
	
	@Test
	public void mapsWeeknum() {
		assertEquals(weeknum, mappedRushingGameData.getWeeknum());
	}

}
