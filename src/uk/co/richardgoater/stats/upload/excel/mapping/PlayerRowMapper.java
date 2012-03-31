package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public class PlayerRowMapper 
extends ExcelRowMapperImpl
implements ExcelRowMapper {

	@Override
	protected void setScheduleData(ExcelRow row) {
		((Player) mappedObject).setSeasonid(row.getSeasonid());
	}
	
	@Override
	protected void setPlayerId(ExcelRow row) {
		((Player) mappedObject).setPlayerid(row.nextCell().asInt());
	}
	
	@Override
	public void mapColumns(ExcelRow row) {
		Player player = (Player) mappedObject;
		
		player.setName(row.nextCell().asString());
		player.setNumber(row.nextCell().asInt());
		player.setPosition(row.nextCell().asString());
		player.setCaptain(row.nextCell().asBoolean());
		player.setPassing(row.nextCell().asBoolean());
		player.setRushing(row.nextCell().asBoolean());
		player.setReceiving(row.nextCell().asBoolean());
		player.setDefense(row.nextCell().asBoolean());
	}

	@Override
	public Player getNewInstance() {
		return new Player();
	}

}
