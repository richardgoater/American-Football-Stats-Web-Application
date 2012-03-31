package uk.co.richardgoater.stats.persistence.dao.gamedata;

import java.util.List;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;

import com.googlecode.ehcache.annotations.Cacheable;

public interface GameDataDAO extends StatsDAO {
	
	@Cacheable(cacheName="statsCache")
	List<GameData> getGameDataForWeek(ScheduleWeek week);
	
	@Cacheable(cacheName="statsCache")
	List<GameData> getGameDataTotals(int seasonid);

}
