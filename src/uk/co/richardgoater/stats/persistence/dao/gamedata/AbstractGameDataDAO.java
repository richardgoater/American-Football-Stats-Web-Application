package uk.co.richardgoater.stats.persistence.dao.gamedata;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.dao.AbstractStatsDAO;

public abstract class AbstractGameDataDAO extends AbstractStatsDAO {

	@Override
	public String getExistingRecordsQuery(Object mappedObject) {
		GameData gameData = (GameData) mappedObject;
		return "from " + getTableName() + " where " +
				"seasonid = " + gameData.getSeasonid() + " and " +
				"weeknum = " + gameData.getWeeknum() + " and " +
				"playerid = " + gameData.getPlayerid();		
	}
		
	protected abstract String getTableName();

}
