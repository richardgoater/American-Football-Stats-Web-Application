package uk.co.richardgoater.stats.upload.excel.jxl;

import jxl.Cell;
import uk.co.richardgoater.stats.upload.excel.ExcelCell;

public class JxlCell implements ExcelCell {

	Cell realCell;
	
	public JxlCell(Cell cell) {
		realCell = cell;
	}	
	
	@Override
	public String asString() {
		return realCell.getContents();
	}

	@Override
	public int asInt() {
		return Integer.parseInt(realCell.getContents());
	}

	@Override
	public double asDouble() {
		return Double.parseDouble(realCell.getContents());
	}

	@Override
	public boolean asBoolean() {
		return Boolean.parseBoolean(realCell.getContents());
	}

}
