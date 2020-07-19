package dev.schneider.controllers;

import java.util.Set;

import com.google.gson.Gson;

import dev.schneider.entities.Account;
import dev.schneider.entities.Customer;
import dev.schneider.services.AccountService;
import dev.schneider.services.AccountServiceImpl;
import io.javalin.http.Handler;

public class AccountController {

	public static AccountService aserv = new AccountServiceImpl();
	private static Gson gson = new Gson();

	public static Handler createAccount = (ctx) -> {
		String accountJson = ctx.body();
		Account account = gson.fromJson(accountJson, Account.class);
		System.out.println(account);
		aserv.addAccount(account);
		
		//usually want to return created object	
		ctx.result(gson.toJson(account));
	};
	
	public static Handler getAllCustomerAccounts = (ctx) -> {
		String id = ctx.pathParam("id");
		Set<Account> accounts = aserv.getAccountsByCustomer(Integer.parseInt(id));
		String json = gson.toJson(accounts);
		ctx.result(json);
		ctx.status(200);
			
	};
}
