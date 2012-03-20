package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public abstract class ExcelRowMapperImpl {

	protected StatsDAO dao;
	protected GameData gameData;
	
	public void setDao(StatsDAO dao) {
		this.dao = dao;
	}
	
	public StatsDAO getDao() {
		return dao;
	}
	
	public Object map(ExcelRow row) {
		gameData = getNewGameDataInstance();
		
		gameData.setSeasonid(row.getSeasonid());
		gameData.setWeeknum(row.getWeeknum());
		
		row.resetIterator();
		gameData.setPlayerid(dao.getPlayeridForName(row.nextCell().asString()));
		
		mapStatsColumns(row);
		
		return gameData;
	}
	
	public abstract void mapStatsColumns(ExcelRow row);
	public abstract GameData getNewGameDataInstance();
	
}