package com.techelevator.tenmo.models;

public class Transfer { //Client side

	
	private long id;
	private String transferType;
	private String transferStatus;
	private long accountFromId;
	private long accountToId;
	private double amount;
	private String fromUsername;
	private String toUsername;
	
	
//	public Transfer(long id, String transferType, String transferStatus,
//			long accountFromId, long accountToId, double amount) {
//		this.id = id;
//		this.transferType = transferType;
//		this.transferStatus = transferStatus;
//		this.accountFromId = accountFromId;
//		this.accountToId = accountToId;
//		this.amount = amount;
//	}
	
	public Transfer() {}


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


	@Override
	public String toString() {
		return "Transfer ID: " + id + "\t\tFrom: " + fromUsername + " | To: " + toUsername + "\t\t\t" + String.format("$%.2f", amount);
	}
	
	public static void printTransferHistory() {
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("     Transfer ID \t\t From/To \t\t\t\t Amount");
		System.out.println("------------------------------------------------------------------------------------------------");
	}
	
	public String showTransferDetails() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("Transfer Details");
		System.out.println("----------------------------------------------------------------");
		return "Id: " + id + "\nFrom: " + fromUsername + "\nTo: " + toUsername + "\nType: " +
		transferType + "\nStatus: " + transferStatus + "\nAmount: " + String.format("$%.2f", amount);
				
	}

	
}





