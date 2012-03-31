package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.dao.gamedata.GameDataDAO;
import uk.co.richardgoater.stats.upload.StatsUploadException;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;


public interface ExcelRowMapper {

	Object map(ExcelRow row) throws StatsUploadException;

	GameDataDAO getDao();

}
