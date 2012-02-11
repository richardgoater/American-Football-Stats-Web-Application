package uk.co.richardgoater.stats.tests.mock;

import java.util.ArrayList;
import java.util.List;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;

public class StatsDAOMockImpl implements StatsDAO {

	@Override
	public void savePlayer(Player p) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GameData> getGameDataForWeek(ScheduleWeek week, String table) {

		DefenseGameData dgd = new DefenseGameData();
		dgd.setGamedataid(1);
		dgd.setWeeknum(1);
		dgd.setPlayerid(1);
		dgd.setTckl(5);
		dgd.setInts(2);

		ArrayList<GameData> l = new ArrayList<GameData>();
		l.add(dgd);
		return l;
	}

	@Override
	public List<GameData> getGameDataTotals(int seasonid, String table) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveGameData(GameData gameData) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Player> getPlayers(int seasonid, String statsCategory) {
		
		Player p = new Player("Richard Goater", 27, "K", false);
		p.setPlayerid(1);
		p.setDefense(true);
		
		Player p2 = new Player("Richard Goater", 27, "K", false);
		p2.setPlayerid(2);
		p2.setDefense(true);
		
		ArrayList<Player> l = new ArrayList<Player>();
		l.add(p);
		l.add(p2);
		return l;
	}

}
