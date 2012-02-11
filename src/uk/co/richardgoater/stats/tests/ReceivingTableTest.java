package uk.co.richardgoater.stats.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import uk.co.richardgoater.stats.ui.ReceivingTable;

public class ReceivingTableTest {

	@Test
	public void testReceivingTable() {
//		ReceivingGameData rgd = new ReceivingGameData();
		ReceivingTable rt = new ReceivingTable(null);
		assertNotNull(rt);
	}
}
