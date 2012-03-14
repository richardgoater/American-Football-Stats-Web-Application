package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.ReceivingGameData;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public class ReceivingRowMapper extends RowMapperDAOSupport implements
		ExcelRowMapper {

	@Override
	public Object map(ExcelRow row) {
		ReceivingGameData receivingGameData = new ReceivingGameData();
		
		row.resetIterator();
		
		receivingGameData.setPlayerid(dao.getPlayeridForName(row.nextCell().asString()));
		receivingGameData.setRec(row.nextCell().asInt());
		receivingGameData.setYds(row.nextCell().asInt());
		receivingGameData.setLongStats(row.nextCell().asString());
		receivingGameData.setTd(row.nextCell().asInt());
		
		return receivingGameData;
	}

}
