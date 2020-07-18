package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;

@Service
public class AccountSqlDAO implements AccountDAO {
	
	private JdbcTemplate jdbcTemplate;
	private Account account;
	
	public AccountSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	@Override
	public void updateAccountBalanceTo(long userId, double amount) {
		
		String sql = "UPDATE accounts SET balance = (balance + ?) WHERE user_id = ?";
		jdbcTemplate.update(sql, amount, userId);

	}
	
	@Override
	public void updateAccountBalanceFrom(long userId, double amount) {
		
		String sql = "UPDATE accounts SET balance = (balance - ?) WHERE user_id = ?";
		jdbcTemplate.update(sql, amount, userId);
		
	}
	
	
	@Override
	public double returnAccountBalance(long id) {
		String sql = "SELECT balance FROM accounts WHERE user_id = ?";
		
		double balance = jdbcTemplate.queryForObject(sql, Double.class, id);
		
		return balance;
	}


	@Override
	public boolean accountNotOverdrawn() {
		if(account.getBalance() <= 0.0) {
			return false;
		} else {
		return true;
		}
	}

}
