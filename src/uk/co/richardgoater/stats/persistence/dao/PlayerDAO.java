package uk.co.richardgoater.stats.persistence.dao;

import java.util.List;

import uk.co.richardgoater.stats.persistence.Player;

public class PlayerDAO extends AbstractStatsDAO implements StatsDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getPlayers(int seasonid) {
		return hibernateTemplate.find("from Player where seasonid = " + seasonid);
	}

	@Override
	public String getExistingRecordsQuery(Object mappedObject) {
		Player player = (Player) mappedObject;
		return "from Player where " + 
			"playerid = " + player.getPlayerid() + " and " +
			"seasonid = " + player.getSeasonid();
	}
	
}
