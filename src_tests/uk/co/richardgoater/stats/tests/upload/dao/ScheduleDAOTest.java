package uk.co.richardgoater.stats.tests.upload.dao;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uk.co.richardgoater.stats.persistence.Season;
import uk.co.richardgoater.stats.persistence.dao.ScheduleDAOImpl;

public class ScheduleDAOTest extends DAOTest {

	ScheduleDAOImpl dao = new ScheduleDAOImpl();
	Map<Integer, String> expectedMap;
	Season twentyEleven = new Season(1, "2011");
	Season twentyTwelve = new Season(2, "2012");
	
	private List<Season> getTestSeasons() {
		List<Season> seasonList = new ArrayList<Season>();
		seasonList.add(twentyEleven);
		seasonList.add(twentyTwelve);
		return seasonList;
	}
	
	@Override
	protected void composeObjects() {
		dao.setHibernateTemplate(mockHibernateTemplate);
	}
	
	@Override
	protected void setExpectations() {
		expect(mockHibernateTemplate.find("from Season")).andReturn(getTestSeasons());
		replay(mockHibernateTemplate);
	}
	
}
