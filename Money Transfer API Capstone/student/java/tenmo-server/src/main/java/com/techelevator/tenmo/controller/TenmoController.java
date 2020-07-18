package com.techelevator.tenmo.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.AccountSqlDAO;
import com.techelevator.tenmo.dao.TransferDAO;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

@RestController
public class TenmoController {
	
	private AccountDAO dao;
	private TransferDAO tDao;

	public TenmoController(TransferDAO tDao, AccountDAO dao) {
		this.dao = dao;
		this.tDao = tDao;
	}
	
	@RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
	public double returnAccountBalanceById(@PathVariable long id) {
		return dao.returnAccountBalance(id);
	}
	
	
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public User[] userTransferList(){
		List<User> userList = tDao.userTransferList();
		User[] userArray = new User[userList.size()];
		for(int i = 0; i < userList.size(); i++) {
			userArray[i] = userList.get(i);
		}
		return userArray;
	}
	
	@RequestMapping(path = "/users/transfer/send", method = RequestMethod.POST)
	public Transfer transferFundsSend(@RequestBody Transfer transfer) {
		if (dao.returnAccountBalance(transfer.getAccountFromId()) >= transfer.getAmount()) {
			return tDao.transferFundsSend(transfer);
		}
		return null;
	}
	
	@RequestMapping(path = "/users/transfer/request", method = RequestMethod.POST)
	public Transfer transferFundsRequest(@RequestBody Transfer transfer) {
			return tDao.transferFundsRequest(transfer);
	}
	
	
	@RequestMapping(path = "/transfer/{id}", method = RequestMethod.GET)
	public Transfer[] showAllTransfers(@PathVariable long id){
		List<Transfer> transferList = tDao.showAllTransfers(id);
		Transfer[] transferArray = new Transfer[transferList.size()];
		for(int i = 0; i < transferList.size(); i++) {
			transferArray[i] = transferList.get(i);			
		}		
		return transferArray;
	}
	
	@RequestMapping(path = "/users/transfer/{id}", method = RequestMethod.GET)
	public Transfer getTransferById(@PathVariable int id) {
		return tDao.getTransferById(id);
	}
	
	
}










