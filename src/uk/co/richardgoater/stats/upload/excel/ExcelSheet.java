package uk.co.richardgoater.stats.upload.excel;

import java.util.List;

public interface ExcelSheet {
	
	List<ExcelRow> getRows();

	String getTitle();
}
