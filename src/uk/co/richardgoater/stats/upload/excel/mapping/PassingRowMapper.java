package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.PassingGameData;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public class PassingRowMapper extends RowMapperDAOSupport implements ExcelRowMapper {

	@Override
	public Object map(ExcelRow row) {
		PassingGameData passingGameData = new PassingGameData();
		
		row.resetIterator();
		
		passingGameData.setPlayerid(dao.getPlayeridForName(row.nextCell().asString()));
		passingGameData.setAtt(row.nextCell().asInt());
		passingGameData.setComp(row.nextCell().asInt());
		passingGameData.setYds(row.nextCell().asInt());
		passingGameData.setLongStats(row.nextCell().asString());
		passingGameData.setTd(row.nextCell().asInt());
		passingGameData.setInts(row.nextCell().asInt());
		passingGameData.setSck(row.nextCell().asInt());
		passingGameData.setSackYds(row.nextCell().asInt());
		
		return passingGameData;
	}

}
