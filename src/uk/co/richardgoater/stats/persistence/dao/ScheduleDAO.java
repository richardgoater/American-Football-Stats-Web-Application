package uk.co.richardgoater.stats.persistence.dao;

import java.util.List;

import uk.co.richardgoater.stats.persistence.ScheduleWeek;
import uk.co.richardgoater.stats.persistence.Season;

import com.googlecode.ehcache.annotations.Cacheable;

public interface ScheduleDAO {
	
	@Cacheable(cacheName="selectionCache")
	List<Object> getScheduleWeeks(int seasonID);
	
	void saveScheduleWeek(ScheduleWeek s);
	
	@Cacheable(cacheName="selectionCache")
	List<Object> getSeasons();
	
	void saveSeason(Season s);

	void removeSeasonAndData(int seasonid);

	void removeWeekAndData(int weeknum, int seasonid);
	
}
