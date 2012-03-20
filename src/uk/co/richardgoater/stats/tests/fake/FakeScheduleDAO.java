package uk.co.richardgoater.stats.tests.fake;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uk.co.richardgoater.stats.persistence.ScheduleWeek;
import uk.co.richardgoater.stats.persistence.Season;
import uk.co.richardgoater.stats.persistence.dao.ScheduleDAO;

public class FakeScheduleDAO implements ScheduleDAO {

	@Override
	public List<Object> getScheduleWeeks(int seasonid) {
		ScheduleWeek sw = new ScheduleWeek();
		sw.setWeeknum(0);
		sw.setSeasonID(seasonid);
		
		ScheduleWeek sw2 = new ScheduleWeek();
		sw2.setWeeknum(1);
		sw2.setSeasonID(seasonid);

		ArrayList<Object> l = new ArrayList<Object>();
		l.add(sw);
		l.add(sw2);
		return l;
	}
	
	@Override
	public void saveScheduleWeek(ScheduleWeek s) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Object> getSeasons() {
		List<Object> l = new ArrayList<Object>();
		Season s = new Season();
		s.setSeasonid(1);
		s.setYear("2010");
		l.add(s);
		
		Season s2 = new Season();
		s2.setSeasonid(2);
		s2.setYear("2011");
		l.add(s2);
		
		return l;
	}

	@Override
	public void saveSeason(Season s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Integer, String> getSeasonsAsMap() {
		// TODO Auto-generated method stub
		return null;
	}

}
