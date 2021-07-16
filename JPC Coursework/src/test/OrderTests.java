package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import util.Order;

public class OrderTests {
	
	@Test
	/*
	 *  Should successfully create an Order object due to the 
	 *  correct parameters being used.
	 */
	public void testValidParameters() {
		List<String> shelfUIDs = new ArrayList<String>(); 
		shelfUIDs.add("ss0");
		shelfUIDs.add("ss1");
		shelfUIDs.add("ss2");
		String status = "Unassigned";
		Order order = new Order(status, shelfUIDs);
		
		assertTrue(order.getUIDs().containsAll(shelfUIDs));
		assertTrue(order.getStatus().contains(status));
	}
	
	@Test
	/* 
	 * Should throw an IllegalArgumentException due to a lack of List.
	 */
	public void testNullParameter() {
		try {
			new Order("Unassigned", null);
			fail("A null parameter should fail.");
		} catch (Exception e) {
			assertEquals("An order requires at least one StorageShelf UID to demonstrate the items to be collected.",
					e.getMessage());
		}
	}
	
	//public void testNullParameter() throws IllegalArgumentException {
		//new Order("Unassigned", null);
	// }

}
