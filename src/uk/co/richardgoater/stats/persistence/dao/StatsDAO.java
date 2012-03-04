package uk.co.richardgoater.stats.persistence.dao;

import java.util.List;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;

import com.googlecode.ehcache.annotations.Cacheable;

public interface StatsDAO {
	@Cacheable(cacheName="statsCache")
	List<GameData> getGameDataForWeek(ScheduleWeek week);
	@Cacheable(cacheName="statsCache")
	List<GameData> getGameDataTotals(int seasonid);
	void saveGameData(GameData gameData);
	
	@Cacheable(cacheName="playerCache")
	List<Player> getPlayers(int seasonid);
	void savePlayer(Player p);
	
	void saveOrReplace(Object mappedObject);
}
