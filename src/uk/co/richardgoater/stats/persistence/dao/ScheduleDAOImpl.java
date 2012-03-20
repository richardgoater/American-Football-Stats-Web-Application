package uk.co.richardgoater.stats.persistence.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.richardgoater.stats.persistence.ScheduleWeek;
import uk.co.richardgoater.stats.persistence.Season;

public class ScheduleDAOImpl extends HibernateDAO implements ScheduleDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getScheduleWeeks(int seasonID) {
		return hibernateTemplate.find("from ScheduleWeek where seasonid = " + seasonID);
	}
	
	@Override
	public void saveScheduleWeek(ScheduleWeek s) {
		hibernateTemplate.saveOrUpdate(s);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getSeasons() {
		return hibernateTemplate.find("from Season");
	}

	@Override
	public void saveSeason(Season s) {
		hibernateTemplate.saveOrUpdate(s);
	}

	@Override
	public Map<Integer, String> getSeasonsAsMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		List<Object> seasonList = getSeasons();
		for (Object s : seasonList) {
			if(s instanceof Season) {
				Season season = (Season) s;
				map.put(season.getSeasonid(), season.getYear());
			}
		}
		
		return map;
	}
}
