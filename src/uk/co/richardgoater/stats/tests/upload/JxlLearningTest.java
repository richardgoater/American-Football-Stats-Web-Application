package uk.co.richardgoater.stats.tests.upload;


import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class JxlLearningTest {

	ApplicationContext context;
	File f;
	Workbook wb;
	
//	static String filePath = "C:\\Users\\Public\\Documents\\Watford Cheetahs Stats\\Maidstone Away 15.05.2011_formatted.xls";
	static String filePath = "/home/richard/Maidstone Away 15.05.2011_formatted.xls";
	
	
	public JxlLearningTest() {
//		context = new ClassPathXmlApplicationContext("uk/co/richardgoater/stats/tests/Spring-test.xml");
	}
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void fileTest() {
		f = new File(filePath);
		Assert.assertNotNull(f);		
	}
	
	@Test
	public void workbookTest() throws BiffException, IOException {
		fileTest();
		wb = Workbook.getWorkbook(f);
		Assert.assertNotNull(wb);
	}
	
	@Test
	public void cellTest() throws BiffException, IOException {
		workbookTest();
		Sheet sheet = wb.getSheet("Defense");
		Assert.assertNotNull(sheet);
		
		Cell a11 = sheet.getCell("A15");
		Assert.assertNotNull(a11);
		Assert.assertEquals("Tish Pattni", a11.getContents());
	}
	
}
