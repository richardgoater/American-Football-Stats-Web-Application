package uk.co.richardgoater.stats.tests.upload;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import uk.co.richardgoater.stats.persistence.dao.AbstractStatsDAO;
import uk.co.richardgoater.stats.persistence.dao.DefenseStatsDAO;
import uk.co.richardgoater.stats.upload.excel.ExcelCell;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public abstract class RowMapperTest {

	protected ExcelRow mockRow;
	protected AbstractStatsDAO mockDAO;
	protected ExcelCell mockCell;
	protected String playerName;
	protected int playerid;

	protected void setUpMocks() {
		mockRow = createMock(ExcelRow.class);
		mockDAO = createMock(DefenseStatsDAO.class);
		mockCell = createMock(ExcelCell.class);
	}

	protected void setExpectations() {
		mockRow.resetIterator();
		expectLastCall();
		expect(mockRow.nextCell()).andReturn(mockCell).times(16);
		replay(mockRow);
		
		setCellExpectations();
		
		expect(mockDAO.getPlayeridForName(playerName)).andReturn(playerid);
		replay(mockDAO);
	}
	
	protected abstract void setCellExpectations();
	protected abstract void setPlayerName();
	protected abstract void setPlayerID();

}
