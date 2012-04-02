package uk.co.richardgoater.stats.persistence.dao;

import java.util.List;

import uk.co.richardgoater.stats.persistence.Player;

import com.googlecode.ehcache.annotations.Cacheable;

public interface StatsDAO {
	
	@Cacheable(cacheName="playerCache")
	List<Player> getPlayers(int seasonid);
	
	int getPlayeridForName(String asString);
	
	void saveOrReplace(Object mappedObject);

}
