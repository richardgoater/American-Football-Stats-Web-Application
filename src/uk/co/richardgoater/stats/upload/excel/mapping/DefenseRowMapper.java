package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;
import uk.co.richardgoater.stats.persistence.dao.AbstractStatsDAO;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public class DefenseRowMapper implements ExcelRowMapper {

	private AbstractStatsDAO dao;

	@Override
	public StatsDAO getDAO() {
		return dao;
	}
	
	public void setDAO(AbstractStatsDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object map(ExcelRow row) {
		DefenseGameData defenseGameData = new DefenseGameData();
		
		mapPlayerID(row, defenseGameData);
		mapTckl(row, defenseGameData);
		mapSolo(row, defenseGameData);
		mapAssist(row, defenseGameData);		
		mapSck(row, defenseGameData);
		mapSckYds(row, defenseGameData);
		mapQBHurry(row, defenseGameData);
		mapInts(row, defenseGameData);
		mapIntYds(row, defenseGameData);
		mapBp(row, defenseGameData);
		mapFf(row, defenseGameData);
		mapFr(row, defenseGameData);
		mapFrYds(row, defenseGameData);
		mapTd(row, defenseGameData);
		mapSafety(row, defenseGameData);
		mapBk(row, defenseGameData);
		
		return defenseGameData;
	}

	private void mapPlayerID(ExcelRow row, DefenseGameData defenseGameData) {
		String playerName = row.getCell(0).asString();
		defenseGameData.setPlayerid(dao.getPlayeridForName(playerName));		
	}
	
	private void mapTckl(ExcelRow row, DefenseGameData defenseGameData) {
		Number tckl = row.getCell(1).asNumber();
		defenseGameData.setTckl(tckl.intValue());		
	}
	
	private void mapSolo(ExcelRow row, DefenseGameData defenseGameData) {
		Number solo = row.getCell(2).asNumber();
		defenseGameData.setSolo(solo.intValue());
	}
	
	private void mapAssist(ExcelRow row, DefenseGameData defenseGameData) {
		Number assist = row.getCell(3).asNumber();
		defenseGameData.setAssist(assist.intValue());
	}
	
	private void mapSck(ExcelRow row, DefenseGameData defenseGameData) {
		Number sck = row.getCell(4).asNumber();
		defenseGameData.setSck(sck.doubleValue());
	}
	
	private void mapSckYds(ExcelRow row, DefenseGameData defenseGameData) {
		Number sckYds = row.getCell(5).asNumber();
		defenseGameData.setSckYds(sckYds.intValue());
	}
	
	private void mapQBHurry(ExcelRow row, DefenseGameData defenseGameData) {
		// TODO Auto-generated method stub
		
	}
	
	private void mapInts(ExcelRow row, DefenseGameData defenseGameData) {
		// TODO Auto-generated method stub
		
	}

	private void mapIntYds(ExcelRow row, DefenseGameData defenseGameData) {
		// TODO Auto-generated method stub
		
	}

	private void mapBp(ExcelRow row, DefenseGameData defenseGameData) {
		// TODO Auto-generated method stub
		
	}

	private void mapFf(ExcelRow row, DefenseGameData defenseGameData) {
		// TODO Auto-generated method stub
		
	}

	private void mapFr(ExcelRow row, DefenseGameData defenseGameData) {
		// TODO Auto-generated method stub
		
	}

	private void mapFrYds(ExcelRow row, DefenseGameData defenseGameData) {
		// TODO Auto-generated method stub
		
	}

	private void mapTd(ExcelRow row, DefenseGameData defenseGameData) {
		// TODO Auto-generated method stub
		
	}

	private void mapSafety(ExcelRow row, DefenseGameData defenseGameData) {
		// TODO Auto-generated method stub
		
	}

	private void mapBk(ExcelRow row, DefenseGameData defenseGameData) {
		// TODO Auto-generated method stub
		
	}

}
