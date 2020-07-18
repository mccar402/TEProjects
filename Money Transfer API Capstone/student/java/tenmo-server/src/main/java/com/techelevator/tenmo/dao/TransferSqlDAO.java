package com.techelevator.tenmo.dao;

import java.math.BigDecimal;
//import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

@Service
public class TransferSqlDAO implements TransferDAO {
	
	private JdbcTemplate jdbcTemplate;

	public TransferSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	
	}
	

	@Override
	public List<User> userTransferList() {
		List<User> users = new ArrayList<>();
		String sql = "SELECT * FROM users";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			User user = mapRowToUser(results);
			users.add(user);
		}
		
		return users;
	}

	
	@Override
	public Transfer transferFundsSend(Transfer transfer) {	
				
		String createTransfer = "INSERT INTO transfers (transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
								"VALUES(?, (SELECT transfer_type_id FROM transfer_types WHERE transfer_type_desc = 'Send'), (SELECT transfer_status_id FROM transfer_statuses WHERE transfer_status_desc = 'Approved'), ?, ?, ?)";
		
		
		transfer.setId(getNextTransferId());
		jdbcTemplate.update(createTransfer, transfer.getId(), transfer.getAccountFromId(), 
				transfer.getAccountToId(), transfer.getAmount());
		
		
		AccountDAO aDao = new AccountSqlDAO(jdbcTemplate);
		aDao.updateAccountBalanceTo(transfer.getAccountToId(), transfer.getAmount());
		aDao.updateAccountBalanceFrom(transfer.getAccountFromId(), transfer.getAmount());			
		
		return transfer;

	}
	
	@Override
	public Transfer transferFundsRequest(Transfer transfer) {	
				
		String createTransfer = "INSERT INTO transfers (transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
								"VALUES(?, ?, (SELECT transfer_status_id FROM transfer_statuses WHERE transfer_status_desc = 'Pending'), ?, ?, ?)";
		
		
		int transferType = Integer.parseInt(transfer.getTransferType());
		transfer.setId(getNextTransferId());
		jdbcTemplate.update(createTransfer, transfer.getId(), transferType, 
				transfer.getAccountFromId(), 
				transfer.getAccountToId(), transfer.getAmount());
		
		
		AccountDAO aDao = new AccountSqlDAO(jdbcTemplate);
		aDao.updateAccountBalanceTo(transfer.getAccountToId(), transfer.getAmount());
		aDao.updateAccountBalanceFrom(transfer.getAccountFromId(), transfer.getAmount());			
		
		return transfer;

	}
	

	@Override
	public List<Transfer> showAllTransfers(long id) {
		List<Transfer> transfers = new ArrayList<>();
		String sql = "SELECT t.transfer_id, t.account_from, t.account_to, t.amount, u1.username AS fromUser, u2.username AS toUser,"
				+ " ts.transfer_status_desc, tp.transfer_type_desc"
				+ " FROM transfers t "
				+ "INNER JOIN accounts a1 ON t.account_from = a1.account_id "
				+ "INNER JOIN accounts a2 ON t.account_to = a2.account_id "
				+ "INNER JOIN users u1 ON a1.user_id = u1.user_id "
				+ "INNER JOIN users u2 ON a2.user_id = u2.user_id "
				+ "INNER JOIN transfer_types tp ON t.transfer_type_id = tp.transfer_type_id "
				+ "INNER JOIN transfer_statuses ts ON t.transfer_status_id = ts.transfer_status_id "
				+ "WHERE a1.user_id = ? OR a2.user_id = ?";			
					
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id, id);
		while(results.next()) {
			Transfer transfer = mapRowToTransfer(results);
			transfers.add(transfer);
		}
		
		return transfers;
	}

	@Override
	public Transfer getTransferById(long id) {		
		String sql = "SELECT t.*, ts.transfer_status_desc, tp.transfer_type_desc FROM transfers t "
				+ "INNER JOIN transfer_types tp ON t.transfer_type_id = tp.transfer_type_id "
				+ "INNER JOIN transfer_statuses ts ON t.transfer_status_id = ts.transfer_status_id"
				+ "WHERE t.transfer_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		
		results.next();
		Transfer newTransfer = mapRowToTransfer(results);

		return newTransfer;
		
	}
	
	private long getNextTransferId() {
		SqlRowSet nextId = jdbcTemplate.queryForRowSet("SELECT nextval('seq_transfer_id')");
		if(nextId.next()) {
			return nextId.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		}
	}
	
	private User mapRowToUser(SqlRowSet rs) {
		User user = new User();
		user.setId(rs.getLong("user_id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password_hash"));
		user.setActivated(true);
		user.setAuthorities("ROLE_USER");
		return user;
	}
	
	private Transfer mapRowToTransfer(SqlRowSet rs) {
		Transfer transfer = new Transfer();
		transfer.setId(rs.getLong("transfer_id"));
		transfer.setTransferType(rs.getString("transfer_type_desc"));
		transfer.setTransferStatus(rs.getString("transfer_status_desc"));
		transfer.setAccountFromId(rs.getLong("account_from"));
		transfer.setAccountToId(rs.getLong("account_to"));
		transfer.setAmount(rs.getDouble("amount"));
		if(rs.getString("fromUser") != null) {
			transfer.setFromUsername(rs.getString("fromUser"));
		}
		if(rs.getString("toUser") != null) {
			transfer.setToUsername(rs.getString("toUser"));
		}
		return transfer;
	}

}
