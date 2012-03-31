package uk.co.richardgoater.stats.ui;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.persistence.dao.gamedata.GameDataDAO;

public class DefenseTable extends StatsTable {

	private static final long serialVersionUID = 2034737865345850L;
	
	public DefenseTable(GameDataDAO dao) {
		super(dao, DefenseGameData.class);
	}
	
	@Override
	protected void setVisibleColumns() {
		setVisibleColumns(new DefenseGameData().getVisibleColumns());
	}
	
	@Override
	protected void renameColumnHeaders() {
		setColumnHeader("ints", "INT");
		setColumnHeader("sckYds", "YDS");
		setColumnHeader("qbHurry", "QB HURRY");
		setColumnHeader("intYds", "YDS");
		setColumnHeader("frYds", "YDS");
	}
}
