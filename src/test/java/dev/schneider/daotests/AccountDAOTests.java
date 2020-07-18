package dev.schneider.daotests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import dev.schneider.dao.AccountDAO;
import dev.schneider.dao.AccountDAOImpl;
import dev.schneider.dao.CustomerDAO;
import dev.schneider.dao.CustomerDAOImpl;
import dev.schneider.entities.Account;
import dev.schneider.entities.Customer;
import dev.schneider.utils.ConnectionUtil;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class AccountDAOTests {

	public static AccountDAO adao = AccountDAOImpl.getAccountDAO();
	public static CustomerDAO cdao = CustomerDAOImpl.getCustomerDAO();

	
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
	
	//create
	@Test
	@Order(1)
	void createAccount() {
		Customer customer = new Customer(0, "usernameguy", "passguy"); //all entities have an id of 0 until you save/ create them
		cdao.createCustomer(customer);
		Account account = new Account(0,1,"savings",5); //all entities have an id of 0 until you save/ create them 
		adao.createAccount(account);
		System.out.println(account.getAcctID());
		Assertions.assertNotEquals(0, account.getAcctID());
		//Assertions.assertNotEquals(0, testSchool.getsID());
	}
	
	
	//read
	@Test
	@Order(2)
	void getAccountByAccountID() {
		Account account = adao.getAccountByAcctID(1);
		Assertions.assertEquals(5, account.getBalance());
//		//acctDAO.createAccount(account);
//		Assertions.assertEquals(5, account.getAcctBalance(1));
	}
	
	
	//update
	@Test
	@Order(3)
	void updateAccountName() {
		Account account = adao.getAccountByAcctID(1);
		account.setAcctName("checking");
		account = adao.updateAccount(account);
		//account = adao.getAccountByAcctID(1);
//		Account account = new Account(1,1,"savings",5);
//		account.setAcctName("checking");
//		//acctDAO.updateAccount(account);
		Assertions.assertEquals("checking", account.getAcctName());
	}
	
	@Test
	@Order(4)
	void updateAccountBalance() {
		Account account = adao.getAccountByAcctID(1);
		account.setBalance(100000);
		account = adao.updateAccount(account);
//		Account account = new Account(1,1,"savings",5);
//		account.setBalance(20);
//		//acctDAO.updateAccount(account);
		Assertions.assertEquals(100000, account.getBalance());
	}
	
	//delete
	
	@Test
	@Order(5)
	void deleteAccount() {
		boolean result = adao.deleteAccount(1);
		Assertions.assertEquals(true, result);
	}
	
	@Test
	@Order(6)
	void deleteAccountNegative() {
		boolean result = adao.deleteAccount(13243);
		Assertions.assertEquals(false, result);
	}
	
	@AfterAll
	static void tearDown() {
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "CALL tear_down_db";
			CallableStatement cs = conn.prepareCall(sql);
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	


}
