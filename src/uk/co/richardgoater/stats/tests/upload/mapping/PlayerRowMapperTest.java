package uk.co.richardgoater.stats.tests.upload.mapping;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.upload.excel.mapping.PlayerRowMapper;


public class PlayerRowMapperTest extends RowMapperTest { 
	
	private PlayerRowMapper playerRowMapper;
	private Player mappedPlayer;
	
	@Override
	protected void setPlayerName() {playerName = "Martin Brown";}
	private int playerid = 1;
	private String name = "Martin Brown";
	private int number = 18;
	private String position = "QB";
	private boolean isCaptain = true;
	private boolean isPassing = true;
	private boolean isRushing = true;
	private boolean isReceiving = true;
	private boolean isDefense = true;
	
	@Override
	protected void instantiateRowMapper() {
		playerRowMapper = new PlayerRowMapper();
		playerRowMapper.setDao(mockDAO);
	}

	@Override
	protected void mapGameData() {
		mappedPlayer = (Player) playerRowMapper.map(mockRow);
	}
	
	@Override
	protected void setMapperRowExpectations() {
		setNextCellNumberOfTimesExpectation(9);
	}
	
	@Override
	protected void setMapperCellExpectations() {
		expect(mockCell.asInt()).andReturn(playerid);
		expect(mockCell.asString()).andReturn(name);
		expect(mockCell.asInt()).andReturn(number);
		expect(mockCell.asString()).andReturn(position);
		expect(mockCell.asBoolean()).andReturn(isCaptain);
		expect(mockCell.asBoolean()).andReturn(isPassing);
		expect(mockCell.asBoolean()).andReturn(isRushing);
		expect(mockCell.asBoolean()).andReturn(isReceiving);
		expect(mockCell.asBoolean()).andReturn(isDefense);
	}
	
	@Test
	public void mapsPlayerid() {
		assertEquals(playerid, mappedPlayer.getPlayerid());
	}
	
	@Test
	public void mapsName() {
		assertEquals(name, mappedPlayer.getName());
	}
	
	@Test
	public void mapsNumber() {
		assertEquals(number, mappedPlayer.getNumber());
	}
	
	@Test
	public void mapsPosition() {
		assertEquals(position, mappedPlayer.getPosition());
	}
	
	@Test
	public void mapsIsCaptain() {
		assertEquals(isCaptain, mappedPlayer.isCaptain());
	}
	
	@Test
	public void mapsIsPassing() {
		assertEquals(isPassing, mappedPlayer.isPassing());
	}
	
	@Test
	public void mapsIsRushing() {
		assertEquals(isRushing, mappedPlayer.isRushing());
	}
	
	@Test
	public void mapsIsReceiving() {
		assertEquals(isReceiving, mappedPlayer.isReceiving());
	}
	
	@Test
	public void mapsIsDefense() {
		assertEquals(isDefense, mappedPlayer.isDefense());
	}
	
	@Test
	public void mapsSeasonid() {
		assertEquals(seasonid, mappedPlayer.getSeasonid());
	}
	
}
