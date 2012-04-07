package uk.co.richardgoater.stats.upload.excel;

import java.util.Date;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import uk.co.richardgoater.stats.upload.StatsLoader;
import uk.co.richardgoater.stats.upload.UploadResponse;
import uk.co.richardgoater.stats.upload.excel.mapping.ExcelRowMapper;

public class ExcelStatsLoader implements StatsLoader {
	
	ExcelParser excelParser;
	
	Map<String, ExcelRowMapper> rowMappers;
	public void setRowMappers(Map<String, ExcelRowMapper> rowMappers) {
		this.rowMappers = rowMappers;
	}
	
	public ExcelStatsLoader(ExcelParser excelParser) {
		this.excelParser = excelParser;
	}
	
	@Override
	public UploadResponse load(MultipartFile file, int seasonid, int weeknum) {
		response.clearMessage();
		appendOpeningMessage(file.getOriginalFilename());
		ExcelWorkbook workbook = excelParser.parse(file); 
		for(ExcelSheet sheet : workbook.getSheets()) {
			appendSheetTitleMessage(sheet.getTitle());
			for(ExcelRow row : sheet.getRows()) {
				row.setScheduleData(seasonid, weeknum);
				loadRow(row, sheet.getTitle());
			}
		}
		return response;
	}

	private void appendOpeningMessage(String fileName) {
		response.appendBoldLine(fileName + " received on " + new Date());
	}
	
	private void appendSheetTitleMessage(String title) {
		response.appendBlankLine();
		response.appendBoldLine("Loading " + title + ":");		
	}

	public void loadRow(ExcelRow row, String dataType) {			
		try {
			ExcelRowMapper rowMapper = getRowMapper(dataType);
			Object mappedObject = rowMapper.map(row);
			rowMapper.getDao().saveOrReplace(mappedObject);
			response.appendLine("Row loaded: " + row.asString());
		}
		catch (Exception e) {
			response.appendError(e.getMessage());
		}
	}

	private ExcelRowMapper getRowMapper(String forDataType) throws Exception {
		ExcelRowMapper rm = rowMappers.get(forDataType);
		if(rm == null)
			throw new Exception("Unknown Datatype: '" + forDataType + "'");
		else return rm;
	}

}
