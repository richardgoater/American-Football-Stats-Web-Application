package uk.co.richardgoater.stats.upload.excel;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import uk.co.richardgoater.stats.upload.StatsLoader;
import uk.co.richardgoater.stats.upload.excel.mapping.ExcelRowMapper;

public class ExcelStatsLoader implements StatsLoader {
	
	ExcelParser excelParser;
	
	Map<String, ExcelRowMapper> rowMappers;
	public void setRowMappers(Map<String, ExcelRowMapper> rowMappers) {
		this.rowMappers = rowMappers;
	}
	
	String separator;
	public void setSeparator(String separator) {
		this.separator = separator;
	}
	
	public ExcelStatsLoader(ExcelParser excelParser) {
		this.excelParser = excelParser;
	}
	
	@Override
	public String load(MultipartFile file, int seasonid, int weeknum) {
		result.setLength(0);
		ExcelWorkbook workbook = excelParser.parse(file); 
		for(ExcelSheet sheet : workbook.getSheets()) {
			result.append("Loading " + sheet.getTitle() + ":" + getSeparator());
			for(ExcelRow row : sheet.getRows()) {
				row.setScheduleData(seasonid, weeknum);
				result.append(loadRow(row, sheet.getTitle()));
			}
		}
		return result.toString();
	}

	
	public String loadRow(ExcelRow row, String dataType) {
		
		ExcelRowMapper rowMapper = getRowMapper(dataType);		
		if(rowMapper == null)
			return "Unknown Datatype: '" + dataType + "'";
		
		try {
			Object mappedObject = rowMapper.map(row);
			rowMapper.getDao().saveOrReplace(mappedObject);
		}
		catch (Exception e) {
			return e.getClass().getName() + ": " + e.getMessage() + getSeparator();
		}
		
		return "Row loaded: " + row.asString() + getSeparator();
	}

	private ExcelRowMapper getRowMapper(String forDataType) {
		return rowMappers.get(forDataType);
	}
	
	private String getSeparator() {
		if(separator == null)
			return "<br//>";
		else
			return separator;
	}

}
