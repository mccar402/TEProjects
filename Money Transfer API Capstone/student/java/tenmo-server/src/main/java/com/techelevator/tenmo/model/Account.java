package com.techelevator.tenmo.model;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

public class Account {	//Server Side
	
	private long accountId;
	@NotBlank(message = "The field user id is required.")
	private long userId;
	@DecimalMin(value = "0.00", inclusive = true, message = "Balance cannot be negative")
	private double balance;
	

	public Account() {}
	
	public Account(long accountId, long userId, double balance) {
		this.accountId = accountId;
		this.userId = userId;
		this.balance = balance;
	}


	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
}
