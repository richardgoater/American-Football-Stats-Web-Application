package uk.co.richardgoater.stats.upload.excel;

public interface ExcelRow {
	
	String asString();
	
	String rowIdAsString();
	
	void setScheduleData(int seasonid, int weeknum);

	int getSeasonid();

	int getWeeknum();
	
	ExcelCell nextCell();
	
	void resetIterator();

}
