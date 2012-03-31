package uk.co.richardgoater.stats.ui.table;

import uk.co.richardgoater.stats.persistence.ReceivingGameData;
import uk.co.richardgoater.stats.persistence.dao.gamedata.GameDataDAO;

public class ReceivingTable extends StatsTable {

	private static final long serialVersionUID = 2034737865345850L;

	public ReceivingTable(GameDataDAO dao) {
		super(dao, ReceivingGameData.class);		
	}
	
	@Override
	protected void setVisibleColumns() {
		setVisibleColumns(new ReceivingGameData().getVisibleColumns());
	}
	
	@Override
	protected void renameColumnHeaders() {
		setColumnHeader("ydsPerRec", "YDS/REC");
		setColumnHeader("displayLong", "LONG");
	}
}
