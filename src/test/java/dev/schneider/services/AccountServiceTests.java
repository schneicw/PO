package dev.schneider.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import dev.schneider.entities.Account;
import dev.schneider.entities.Customer;
import dev.schneider.utils.ConnectionUtil;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


class AccountServiceTests {
	
	private static AccountService aserv = new AccountServiceImpl();
	private static CustomerService cserv = new CustomerServiceImpl();
	
	
	@BeforeAll
	static void setup() {
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "CALL set_up_db";
			CallableStatement cs = conn.prepareCall(sql);
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Order(1)
	void createAccount() {
		Customer customer = new Customer(0, "myusername", "mypass");
		cserv.createCustomer(customer);	
		Account account = new Account(0,1,"savings",5); 
		aserv.addAccount(account);
		Assertions.assertNotEquals(0, account.getAcctID());
		}
	
	
	@Test
	@Order(2)
	void getAccount() {
		Account account = aserv.getAccountById(1);
		Assertions.assertEquals(5, account.getBalance());
		}
	
	@Test
	@Order(3)
	void updateAccount() {
		Account account = aserv.getAccountById(1);
		account.setAcctName("checking");
		account = aserv.updateAccount(account);
		Assertions.assertEquals("checking", account.getAcctName());
		}

	
	@Test
	@Order(4)
	void deleteAccount() {
		boolean result = aserv.deleteAccount(1);
		Assertions.assertEquals(true, result);
	}
	
	@Test
	@Order(5)
	void deleteAccountNegative() {
		boolean result = aserv.deleteAccount(13243);
		Assertions.assertEquals(false, result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
