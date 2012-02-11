package uk.co.richardgoater.stats.ui;

import uk.co.richardgoater.stats.persistence.RushingGameData;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;

public class RushingTable extends StatsTable {

	private static final long serialVersionUID = 2034737865345850L;

	public RushingTable(StatsDAO dao) {
		super(dao, RushingGameData.class);
	}
	
	@Override
	protected void setVisibleColumns() {
		setVisibleColumns(new RushingGameData().getVisibleColumns());	
	}
	
	@Override
	protected void renameColumnHeaders() {
		setColumnHeader("ydsPerAtt", "YDS/ATT");
		setColumnHeader("displayLong", "LONG");
	}

}
