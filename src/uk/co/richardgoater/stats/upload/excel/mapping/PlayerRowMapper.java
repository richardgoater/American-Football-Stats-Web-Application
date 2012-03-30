package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public class PlayerRowMapper 
extends ExcelRowMapperImpl
implements ExcelRowMapper {

	@Override
	protected void setScheduleData(ExcelRow row) {
		gameData.setSeasonid(row.getSeasonid());
	}
	
	@Override
	protected void setPlayerId(ExcelRow row) {
		gameData.setPlayerid(row.nextCell().asInt());
	}
	
	@Override
	public void mapStatsColumns(ExcelRow row) {
//		Player player = (Player) gameData;
	}

	@Override
	public GameData getNewGameDataInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
