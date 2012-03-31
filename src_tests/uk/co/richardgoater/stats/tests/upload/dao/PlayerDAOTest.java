package uk.co.richardgoater.stats.tests.upload.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.dao.PlayerDAO;

public class PlayerDAOTest extends DAOTest {

	PlayerDAO dao = new PlayerDAO();
	Player newPlayer = new Player("Mark Foster", 47, "S", false);
	List<Player> playerList = new ArrayList<Player>();
	
	@Override
	protected void composeObjects() {
		dao.setHibernateTemplate(mockHibernateTemplate);
		
		playerList.add(newPlayer);
	}

	@Override
	protected void setExpectations() {
				
	}

	@Test
	public void testNewPlayerAdded() {
		
	}
	
	@Test
	public void testPlayerReplaced() {
		
	}
	
}
