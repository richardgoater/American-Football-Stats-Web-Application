package uk.co.richardgoater.stats.persistence.dao.gamedata;

import java.util.List;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.Player;
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
	
	@SuppressWarnings("unchecked")
	public List<Player> getPlayers(int seasonid) {
		String query = "from Player p where " + getPlayerTypeColumn() + " = 1" + appendSeasonClause( " and", seasonid);
		
		if(seasonid == 0) 
			query = "select new uk.co.richardgoater.stats.persistence.Player " +
					"(p.playerid, p.name, 0, '', 'false') " + query;
		
		return hibernateTemplate.find(query);
	}
	
	protected abstract String getPlayerTypeColumn();

}
