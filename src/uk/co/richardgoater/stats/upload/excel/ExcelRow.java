package uk.co.richardgoater.stats.upload.excel;

public interface ExcelRow {

	String asString();
	
	void setScheduleData(int seasonid, int weeknum);

	int getSeasonid();

	int getWeeknum();
	
	ExcelCell getCell(int columnIndex);

}
