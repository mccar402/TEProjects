package com.techelevator.tenmo.models;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TransferTest extends Transfer {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void transfer_id_verification_test() {
		Transfer Transfer = new Transfer();
		long result = getId();
		assertEquals(0, result);
	}

	@Test
	public void transfer_type_verification_test() {
		Transfer Transfer = new Transfer();
		String result = getTransferType();
		assertEquals(null, result);
}
	@Test
	public void transfer_status_verification_test() {
		Transfer Transfer = new Transfer();
		String result = getTransferStatus();
		assertEquals(null, result);
}
	@Test
	public void transfer_account_from_id_verification_test() {
		Transfer Transfer = new Transfer();
		long result = getAccountFromId();
		assertEquals(0, result);
}
	@Test
	public void transfer_account_to_id_verification_test() {
		Transfer Transfer = new Transfer();
		long result = getAccountToId();
		assertEquals(0, result);
		
	}
	
	
}