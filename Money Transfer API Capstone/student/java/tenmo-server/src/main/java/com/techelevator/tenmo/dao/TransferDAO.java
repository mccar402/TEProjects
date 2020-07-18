package com.techelevator.tenmo.dao;

//import java.math.BigDecimal;
import java.util.List;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

public interface TransferDAO {
	
	List<User> userTransferList();

	Transfer transferFundsSend(Transfer transfer);
	
	Transfer transferFundsRequest(Transfer transfer);
	
	List<Transfer> showAllTransfers(long id);
	//SQL statement pulling * from Transfer table
	
	Transfer getTransferById(long id);
	
}
