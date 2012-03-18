package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public class DefenseRowMapper extends ExcelRowMapperImpl implements ExcelRowMapper {

	@Override
	public GameData getNewGameDataInstance() {
		return new DefenseGameData();
	}
	
	@Override
	public void mapStatsColumns(ExcelRow row) 
	{	
		DefenseGameData defenseGameData = (DefenseGameData) gameData;
		
		defenseGameData.setTckl(row.nextCell().asInt());
		defenseGameData.setSolo(row.nextCell().asInt());
		defenseGameData.setAssist(row.nextCell().asInt());
		defenseGameData.setSck(row.nextCell().asDouble());		
		defenseGameData.setSckYds(row.nextCell().asInt());
		defenseGameData.setQbHurry(row.nextCell().asInt());
		defenseGameData.setInts(row.nextCell().asInt());
		defenseGameData.setIntYds(row.nextCell().asInt());
		defenseGameData.setBp(row.nextCell().asInt());
		defenseGameData.setFf(row.nextCell().asInt());
		defenseGameData.setFr(row.nextCell().asInt());
		defenseGameData.setFrYds(row.nextCell().asInt());
		defenseGameData.setTd(row.nextCell().asInt());
		defenseGameData.setSafety(row.nextCell().asInt());
		defenseGameData.setBk(row.nextCell().asInt());
	}

}
