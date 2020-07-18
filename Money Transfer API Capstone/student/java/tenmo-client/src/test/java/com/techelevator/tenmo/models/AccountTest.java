package com.techelevator.tenmo.models; //Client Side

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountTest extends Account {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void account_Id_verification_test() {
		Account Account = new Account(0, 0, 300);
		long result = getAccountId();
		assertEquals(0, 0, result);
	}

	
	}

