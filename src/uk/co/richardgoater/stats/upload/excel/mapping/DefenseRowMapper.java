package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.persistence.dao.DefenseStatsDAO;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public class DefenseRowMapper implements ExcelRowMapper {

	private DefenseStatsDAO dao;

	@Override
	public Object map(ExcelRow row) {
		return new DefenseGameData();
	}

	@Override
	public StatsDAO getDAO() {
		return dao;
	}
	
	public void setDAO(DefenseStatsDAO dao) {
		this.dao = dao;
	}

}
