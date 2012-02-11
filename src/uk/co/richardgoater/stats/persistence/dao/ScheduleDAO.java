package uk.co.richardgoater.stats.persistence.dao;

import java.util.List;

import com.googlecode.ehcache.annotations.Cacheable;

import uk.co.richardgoater.stats.persistence.ScheduleWeek;
import uk.co.richardgoater.stats.persistence.Season;

public interface ScheduleDAO {
	@Cacheable(cacheName="selectionCache")
	List<Object> getScheduleWeeks(int seasonID);
	void saveScheduleWeek(ScheduleWeek s);
	
	@Cacheable(cacheName="selectionCache")
	List<Object> getSeasons();
	void saveSeason(Season s);
}
