package uk.co.richardgoater.stats.persistence.dao;

import java.util.List;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;
import uk.co.richardgoater.stats.persistence.Season;

public class ScheduleDAOImpl extends HibernateDAO implements ScheduleDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getScheduleWeeks(int seasonID) {
		return hibernateTemplate.find(
				"from ScheduleWeek where seasonid = " + seasonID);
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
		saveScheduleWeek(new ScheduleWeek(0, "All", null, false, s.getSeasonid()));
	}

	@Override
	public void removeSeasonAndData(int seasonid) {
		String whereClause = "";
		
		if(seasonid > 0)
			whereClause = " where seasonid = " + seasonid;
	
		String[] tables = {"Season", "ScheduleWeek", "Player", "GameData"};
		for(String table : tables) {
			hibernateTemplate.deleteAll(
				hibernateTemplate.find(
					"from " + table + whereClause
				)
			);
		}
		
		if(seasonid == 0)
			saveSeason(new Season(0, "All"));
	}
}
