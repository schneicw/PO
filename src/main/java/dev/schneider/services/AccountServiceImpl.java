package dev.schneider.services;

import java.util.Set;

import dev.schneider.dao.AccountDAO;
import dev.schneider.dao.AccountDAOImpl;
import dev.schneider.entities.Account;

public class AccountServiceImpl implements AccountService {
	
	private static AccountDAO adao = AccountDAOImpl.getAccountDAO();

	@Override
	public Account addAccount(Account account) {
		return adao.createAccount(account);
	}

	@Override
	public Account getAccountById(int id) {
		return adao.getAccountByAcctID(id);
	}

	@Override
	public Account updateAccount(Account account) {
		return adao.updateAccount(account);
	}

	@Override
	public boolean deleteAccount(int id) {
		return adao.deleteAccount(id);
	}

	@Override
	public Set<Account> getTasksLessThan(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Account> getTasksGreaterThan(int num) {
		// TODO Auto-generated method stub
		return null;
	}

}
