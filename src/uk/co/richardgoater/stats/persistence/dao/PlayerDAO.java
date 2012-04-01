package uk.co.richardgoater.stats.persistence.dao;

import java.util.List;

import uk.co.richardgoater.stats.persistence.Player;

public class PlayerDAO extends AbstractStatsDAO implements StatsDAO {

	public void saveOrReplace(Object mappedObject) {
		Player player = (Player) mappedObject;
		
		@SuppressWarnings("unchecked")
		List<Player> existingPlayers = hibernateTemplate.find(
				"from Player where " + 
				"playerid = " + player.getPlayerid() + " and " +
				"seasonid = " + player.getSeasonid());
		
		if(existingPlayers.size() > 0) {
			hibernateTemplate.delete(existingPlayers.get(0));
		}
		
		hibernateTemplate.saveOrUpdate(player);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getPlayers(int seasonid) {
		return hibernateTemplate.find("from Player where seasonid = " + seasonid);
	}
	
}
