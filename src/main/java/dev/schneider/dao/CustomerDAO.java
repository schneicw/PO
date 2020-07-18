package dev.schneider.dao;

import java.sql.SQLDataException;
import java.util.Set;

import dev.schneider.entities.Customer;

public interface CustomerDAO {
	//where sql statements will go to insert into database
	
	//create
	Customer createCustomer(Customer customer);
	
	//read
	Set<Customer> getAllCustomer();
	Customer getCustomerByID(int cID) ;
	
	//update
	Customer updateCustomer(Customer customer);
	
	//delete
	boolean deleteCustomer(int cID);
}
