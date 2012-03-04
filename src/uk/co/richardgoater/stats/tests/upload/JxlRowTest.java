package uk.co.richardgoater.stats.tests.upload;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.upload.excel.jxl.JxlRow;

public class JxlRowTest extends JxlTest {

	private JxlRow row;
	
	@Before
	public void setUp() throws BiffException, IOException {
		setUpMocks();
		setExpectations();
		
		row = new JxlRow(getCells());
	}

	private void setUpMocks() {
		// TODO Auto-generated method stub
		
	}

	private void setExpectations() {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void test() {
		
	}
}

