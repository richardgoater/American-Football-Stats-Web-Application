package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.RushingGameData;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public class RushingRowMapper
extends ExcelRowMapperImpl 
implements ExcelRowMapper {

	@Override
	public GameData getNewGameDataInstance() {
		return new RushingGameData();
	}
	
	@Override
	public void mapStatsColumns(ExcelRow row) 
	{
		RushingGameData rushingGameData = (RushingGameData) gameData;
		
		rushingGameData.setAtt(row.nextCell().asInt());
		rushingGameData.setYds(row.nextCell().asInt());
		rushingGameData.setLongStats(row.nextCell().asString());
		rushingGameData.setTd(row.nextCell().asInt());
	}

}