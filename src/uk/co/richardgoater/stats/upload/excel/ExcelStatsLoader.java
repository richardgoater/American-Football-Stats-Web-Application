package uk.co.richardgoater.stats.upload.excel;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import uk.co.richardgoater.stats.upload.StatsLoader;
import uk.co.richardgoater.stats.upload.StatsUploadException;
import uk.co.richardgoater.stats.upload.excel.mapping.ExcelRowMapper;

public class ExcelStatsLoader implements StatsLoader {
	
	ExcelParser excelParser;
	Map<String, ExcelRowMapper> rowMappers;

	public ExcelStatsLoader(ExcelParser excelParser) {
		this.excelParser = excelParser;
	}
	
	@Override
	public String load(MultipartFile file, int seasonid, int weeknum) {
		
		ExcelWorkbook workbook = excelParser.parse(file); 
		for(ExcelSheet sheet : workbook.getSheets())
			for(ExcelRow row : sheet.getRows()) {
				row.setScheduleData(seasonid, weeknum);
				result.append(loadRow(row, sheet.getTitle()));
			}
		return result.toString();
	}

	
	public String loadRow(ExcelRow row, String dataType) {
		
		ExcelRowMapper rowMapper = getRowMapper(dataType);		
		if(rowMapper == null)
			return "Unknown Datatype: '" + dataType + "'";
		
		try {
			Object mappedObject = rowMapper.map(row);
			rowMapper.getDAO().saveOrReplace(mappedObject);
		}
		catch (StatsUploadException e) {
			return e.getMessage();
		}
		
		return "Row loaded: " + row.asString();
	}
	
	private ExcelRowMapper getRowMapper(String forDataType) {
		return rowMappers.get(forDataType);
	}

	public void setRowMappers(Map<String, ExcelRowMapper> rowMappers) {
		this.rowMappers = rowMappers;
	}

}
