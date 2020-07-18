package com.techelevator.tenmo.model;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

public class Transfer {  //server side
	
	private long id;
//	@NotBlank(message = "The field transfer type id is required.")
	private String transferType;
//	@NotBlank(message = "The field transfer status id is required.")
	private String transferStatus;
//	@NotBlank(message = "The field account from id is required.")
	private long accountFromId;
//	@NotBlank(message = "The field account to id is required.")
	private long accountToId;
//	@DecimalMin(value = "0.01", message = "Amount must be greater than $0.00")
	private double amount;
	private String fromUsername;
	private String toUsername;

	public Transfer() {
		
	}
	
	public Transfer(long id, String transferType, String transferStatus,
					long accountFromId, long accountToId, double amount) {
		this.id = id;
		this.transferType = transferType;
		this.transferStatus = transferStatus;
		this.accountFromId = accountFromId;
		this.accountToId = accountToId;
		this.amount = amount;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

	public long getAccountFromId() {
		return accountFromId;
	}

	public void setAccountFromId(long accountFromId) {
		this.accountFromId = accountFromId;
	}

	public long getAccountToId() {
		return accountToId;
	}

	public void setAccountToId(long accountToId) {
		this.accountToId = accountToId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFromUsername() {
		return fromUsername;
	}

	public void setFromUsername(String fromUsername) {
		this.fromUsername = fromUsername;
	}

	public String getToUsername() {
		return toUsername;
	}

	public void setToUsername(String toUsername) {
		this.toUsername = toUsername;
	}



}
