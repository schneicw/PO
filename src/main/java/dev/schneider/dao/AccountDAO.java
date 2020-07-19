package dev.schneider.dao;

import java.util.Set;

import dev.schneider.entities.Account;

public interface AccountDAO {
	//where sql statements will go to insert into database
	
	//create
	Account createAccount(Account account);
	
	//read
	Account getAccountByAcctID(int acctID);
	Set<Account> getAllCustomerAccounts(int cID);
	//update
	Account updateAccount(Account account);
	
	//delete
	boolean deleteAccount(int acctID);
}
