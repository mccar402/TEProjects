package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

import com.techelevator.tenmo.model.Account;

public interface AccountDAO {

	
	public double returnAccountBalance(long id);
	
	public void updateAccountBalanceTo(long userId, double amount);
	
	public void updateAccountBalanceFrom(long userId, double amount);

	public boolean accountNotOverdrawn();
	//true if able to send transfer and false if unable to process transfer
	//include SOUT with StatusMessage of Approve

}

