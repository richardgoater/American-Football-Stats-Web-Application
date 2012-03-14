package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.RushingGameData;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public class RushingRowMapper extends RowMapperDAOSupport implements
		ExcelRowMapper {

	@Override
	public Object map(ExcelRow row) {
		RushingGameData rushingGameData = new RushingGameData();
		
		row.resetIterator();
		
		rushingGameData.setPlayerid(dao.getPlayeridForName(row.nextCell().asString()));
		rushingGameData.setAtt(row.nextCell().asInt());
		rushingGameData.setYds(row.nextCell().asInt());
		rushingGameData.setLongStats(row.nextCell().asString());
		rushingGameData.setTd(row.nextCell().asInt());
		
		return rushingGameData;
	}

}
