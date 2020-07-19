package dev.schneider.services;

import java.util.Set;

import dev.schneider.entities.Account;


public interface AccountService {
	//CRUD like operation
	Account addAccount(Account account);
	Set<Account> getAccountsByCustomer(int cID);
	Account getAccountById(int id);
	Account updateAccount(Account account);
	boolean deleteAccount(int id);
	
	Set<Account> getTasksLessThan(int num);
	Set<Account> getTasksGreaterThan(int num);
}
