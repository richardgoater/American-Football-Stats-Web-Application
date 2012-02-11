package uk.co.richardgoater.stats.tests;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;
import uk.co.richardgoater.stats.tests.mock.StatsDAOMockImpl;

public class DefenseGameDataTest {
	
	StatsDAO dao;
	List<GameData> defenseGameData;

	@Before
	public void setUp() throws Exception {
		dao = new StatsDAOMockImpl();
		defenseGameData = dao.getGameDataForWeek(null, "");
	}

	@Test
	public void testGetDefenseForWeek() {
		Assert.assertNotNull(defenseGameData);
		Assert.assertEquals(1, defenseGameData.size());
	}
	
}
