package uk.co.richardgoater.stats.tests.view;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.co.richardgoater.stats.persistence.PassingGameData;

public class PassingGameDataTest {

	@Test
	public void PerCentTest() {
		PassingGameData pgd = new PassingGameData();
		pgd.setAtt(12);
		pgd.setComp(7);
		
		double compPerCent = pgd.getCompPerCent(); 
		
		assertEquals(58.33, compPerCent, 0);
	}
	
}
