package uk.co.richardgoater.stats.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.GameDataContainer;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;

import com.vaadin.ui.Table;

public abstract class StatsTable extends Table {

	private static final long serialVersionUID = -6210798727180420975L;
	protected StatsDAO dao;

	@SuppressWarnings("unchecked")
	public StatsTable(StatsDAO dao, Class beanType) {
		super("");
		this.dao = dao;
		setContainerDataSource(new GameDataContainer(beanType));
		
		setPageLength(15);
		setWidth("100%");
		
		setVisibleColumns();
		formatColumns();
	}
	
	protected abstract void setVisibleColumns();

	protected void setWeek(ScheduleWeek week) {
		List<GameData> data = null;
		if(week.getWeeknum() == 0)
			data =  dao.getGameDataTotals(week.getSeasonID());
		else 
			data = dao.getGameDataForWeek(week);
		
		Map<Integer, Player> players = createPlayerMap(dao.getPlayers(week.getSeasonID()));		
		
		GameDataContainer container = (GameDataContainer) getContainerDataSource();
		container.removeAllItems();
		container.addGameDataBeans(data, players);		
	}
	
	private void formatColumns() {
		for(Object s : getVisibleColumns()) {
			String str = (String) s;
			setColumnHeader(str, str.toUpperCase());
		}
		
		setColumnHeader("player.name", "NAME");
		setColumnHeader("player.number", "#");
		setColumnHeader("player.position", "POS");
		
		renameColumnHeaders();
	}
	
	protected abstract void renameColumnHeaders();
	
	protected Map<Integer, Player> createPlayerMap(List<Player> playerList) {
		Map<Integer, Player> m = new HashMap<Integer, Player>();
		for(Player p : playerList)
			m.put(p.getPlayerid(), p);
		return m;
	}
}
