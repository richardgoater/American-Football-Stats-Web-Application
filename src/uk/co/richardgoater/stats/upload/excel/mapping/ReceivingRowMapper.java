package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.ReceivingGameData;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public class ReceivingRowMapper 
extends ExcelRowMapperImpl 
implements ExcelRowMapper {

	@Override
	public GameData getNewGameDataInstance() {
		return new ReceivingGameData();
	}
	
	@Override
	public void mapStatsColumns(ExcelRow row) 
	{
		ReceivingGameData receivingGameData = (ReceivingGameData) gameData;
		
		receivingGameData.setRec(row.nextCell().asInt());
		receivingGameData.setYds(row.nextCell().asInt());
		receivingGameData.setLongStats(row.nextCell().asString());
		receivingGameData.setTd(row.nextCell().asInt());
	}

}
