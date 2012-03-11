package uk.co.richardgoater.stats.tests.upload;

import uk.co.richardgoater.stats.persistence.PassingGameData;
import uk.co.richardgoater.stats.upload.excel.mapping.PassingRowMapper;


public class PassingRowMapperTest extends RowMapperTest { 
	
	private PassingRowMapper passingRowMapper;
	private PassingGameData mappedPassingGameData;
	
	@Override
	protected void setPlayerName() {
		// TODO Auto-generated method stub
		
	}
	
	private int att;
	private int comp;
	private int yds;
	private int longest;
	private boolean isLongTD;
	private int td;
	private int ints;
	private int sck;
	private int sackYds;
	
	@Override
	protected void instantiateRowMapper() {
		passingRowMapper = new PassingRowMapper();;
		passingRowMapper.setDAO(mockDAO);
	}

	@Override
	protected void mapGameData() {
		mappedPassingGameData = (PassingGameData) passingRowMapper.map(mockRow);
	}
	
	@Override
	protected void setMapperRowExpectations() {
		setNextCellNumberOfTimesExpectation(7);
	}
	
	@Override
	protected void setMapperCellExpectations() {
		
	}
	
}
