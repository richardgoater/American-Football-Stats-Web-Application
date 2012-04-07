package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.RushingGameData;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public class RushingRowMapper
extends AbstractExcelRowMapper 
implements ExcelRowMapper {

	@Override
	public GameData getNewInstance() {
		return new RushingGameData();
	}
	
	@Override
	public void mapColumns(ExcelRow row) 
	{
		RushingGameData rushingGameData = (RushingGameData) mappedObject;
		
		rushingGameData.setAtt(row.nextCell().asInt());
		rushingGameData.setYds(row.nextCell().asInt());
		rushingGameData.setLongStats(row.nextCell().asString());
		rushingGameData.setTd(row.nextCell().asInt());
	}

}
