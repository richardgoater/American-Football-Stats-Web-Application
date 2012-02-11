package uk.co.richardgoater.stats.ui;

import uk.co.richardgoater.stats.persistence.PassingGameData;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;

public class PassingTable extends StatsTable {

	private static final long serialVersionUID = 2034737865345850L;
	
	public PassingTable(StatsDAO dao) {
		super(dao, PassingGameData.class);
	}
	
	@Override
	protected void setVisibleColumns() {
		setVisibleColumns(new PassingGameData().getVisibleColumns());
	}
	
	@Override
	protected void renameColumnHeaders() {
		setColumnHeader("compPerCent", "COMP%");
		setColumnHeader("ydsPerAtt", "YPA");
		setColumnHeader("sackYds", "YDS");
		setColumnHeader("ydsPerComp", "YPC");
		setColumnHeader("displayLong", "LONG");
	}
}
