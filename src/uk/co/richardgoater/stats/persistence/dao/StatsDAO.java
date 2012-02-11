package uk.co.richardgoater.stats.persistence.dao;

import java.util.List;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;

import com.googlecode.ehcache.annotations.Cacheable;

public interface StatsDAO {
	@Cacheable(cacheName="statsCache")
	List<GameData> getGameDataForWeek(ScheduleWeek week, String statsCategory);
	@Cacheable(cacheName="statsCache")
	List<GameData> getGameDataTotals(int seasonid, String statsCategory);
	void saveGameData(GameData gameData);
	
	@Cacheable(cacheName="playerCache")
	List<Player> getPlayers(int seasonid, String statsCategory);
	void savePlayer(Player p);
}
