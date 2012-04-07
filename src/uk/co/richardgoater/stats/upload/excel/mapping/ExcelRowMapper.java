package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.dao.StatsDAO;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;


public interface ExcelRowMapper {

	Object map(ExcelRow row) throws Exception;

	StatsDAO getDao();

}
