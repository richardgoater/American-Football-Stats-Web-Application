package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.dao.gamedata.GameDataDAO;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public abstract class ExcelRowMapperImpl {

	protected GameDataDAO dao;
	protected Object mappedObject;
	
	public void setDao(GameDataDAO dao) {
		this.dao = dao;
	}
	
	public GameDataDAO getDao() {
		return dao;
	}
	
	public Object map(ExcelRow row) {
		mappedObject = getNewInstance();
		
		setScheduleData(row);		
		row.resetIterator();
		setPlayerId(row);
		mapColumns(row);
		
		return mappedObject;
	}
	
	protected void setScheduleData(ExcelRow row) {
		((GameData) mappedObject).setSeasonid(row.getSeasonid());
		((GameData) mappedObject).setWeeknum(row.getWeeknum());
	}
	
	protected void setPlayerId(ExcelRow row) {
		((GameData) mappedObject).setPlayerid(dao.getPlayeridForName(row.nextCell().asString()));
	}

	public abstract void mapColumns(ExcelRow row);
	protected abstract Object getNewInstance();
	
}
