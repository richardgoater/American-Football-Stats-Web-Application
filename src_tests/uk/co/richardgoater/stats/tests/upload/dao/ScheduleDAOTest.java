package uk.co.richardgoater.stats.tests.upload.dao;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import uk.co.richardgoater.stats.persistence.Season;
import uk.co.richardgoater.stats.persistence.dao.ScheduleDAOImpl;

public class ScheduleDAOTest extends DAOTest {

	ScheduleDAOImpl dao = new ScheduleDAOImpl();
	Map<Integer, String> expectedMap;
	Season twentyEleven = new Season(1, "2011");
	Season twentyTwelve = new Season(2, "2012");
	
	private void createExpectedSeasonMap() {
		expectedMap = new HashMap<Integer, String>();
		
		List<Season> seasonList = getTestSeasons();
		for(Season s: seasonList)
			expectedMap.put(s.getSeasonid(), s.getYear());
	}
	
	private List<Season> getTestSeasons() {
		List<Season> seasonList = new ArrayList<Season>();
		seasonList.add(twentyEleven);
		seasonList.add(twentyTwelve);
		return seasonList;
	}
	
	@Override
	protected void composeObjects() {
		dao.setHibernateTemplate(mockHibernateTemplate);
		createExpectedSeasonMap();
	}
	
	@Override
	protected void setExpectations() {
		expect(mockHibernateTemplate.find("from Season")).andReturn(getTestSeasons());
		replay(mockHibernateTemplate);
	}
	
	@Test
	public void shouldGetSeasonsAsMap() {
		Map<Integer, String> map = dao.getSeasonsAsMap();
		assertEquals(expectedMap, map);
	}
}
