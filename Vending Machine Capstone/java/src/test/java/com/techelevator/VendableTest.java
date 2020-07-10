package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class VendableTest {

	Chips cheetoPuffs = new Chips("D12", "Cheeto Puffs", 5.0, "Chip");
	Candy kitKat = new Candy("B4", "KitKat", 1.0, "Candy");
	Gum zebraStripe = new Gum("A7", "Zebra Stripe", 4.0, "Gum");
	Beverage fresca = new Beverage("G6", "Fresca", 3.0, "Beverage");
	
	@Test
	public void testGetSlot() {

		assertEquals("D12", cheetoPuffs.getSlot());
		assertEquals("B4", kitKat.getSlot());
		assertEquals("A7", zebraStripe.getSlot());
		assertEquals("G6", fresca.getSlot());
	}
	 
	@Test
	public void testGetItemName() {
		
		assertEquals("Cheeto Puffs", cheetoPuffs.getItemName());
		assertEquals("KitKat", kitKat.getItemName());
		assertEquals("Zebra Stripe", zebraStripe.getItemName());
		assertEquals("Fresca", fresca.getItemName());
	}

	@Test
	public void testGetPrice() {
		
		assertEquals(5.0, cheetoPuffs.getPrice(), 0.001);
		assertEquals(1.0, kitKat.getPrice(), 0.001);
		assertEquals(4.0, zebraStripe.getPrice(), 0.001);
		assertEquals(3.0, fresca.getPrice(), 0.001);
	}
	
	@Test
	public void testGetType() {
		
		assertEquals("Chip", cheetoPuffs.getType());
		assertEquals("Candy", kitKat.getType());
		assertEquals("Gum", zebraStripe.getType());
		assertEquals("Beverage", fresca.getType());
	}
	
	@Test
	public void testGetNumberAvailable() {
		
		assertEquals(5, cheetoPuffs.getNumberAvailable());
		assertEquals(5, fresca.getNumberAvailable());
		assertEquals(5, kitKat.getNumberAvailable());
		assertEquals(5, zebraStripe.getNumberAvailable());
	}
	
}










