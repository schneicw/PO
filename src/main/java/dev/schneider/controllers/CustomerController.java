package dev.schneider.controllers;

import java.util.Set;

import com.google.gson.Gson;

import dev.schneider.entities.Customer;
//import dev.schneider.entities.Task;
import dev.schneider.services.CustomerService;
import dev.schneider.services.CustomerServiceImpl;
import io.javalin.http.Handler;

public class CustomerController {
	public static CustomerService cserv = new CustomerServiceImpl();
	private static Gson gson = new Gson();

	
	public static Handler createCustomer = (ctx) -> {
		String customerJson = ctx.body();
		Customer customer = gson.fromJson(customerJson, Customer.class);
		cserv.createCustomer(customer);
		
		//usually want to return created object	
		ctx.result(gson.toJson(customer));
	};
	
	public static Handler getAllCustomers = (ctx) -> {
		Set<Customer> customers = cserv.getAllCustomers();
		String json = gson.toJson(customers);
		ctx.result(json);
		ctx.status(200);
			
	};
	
	public static Handler getCustomerByID = (ctx) -> {
		String id = ctx.pathParam("id");
		Customer customer = cserv.getCustomerByID(Integer.parseInt(id));
		if (customer == null) {
			ctx.result("not found");
			ctx.status(404);
		}else {
		String json = gson.toJson(customer);
		ctx.result(json);
		ctx.status(200);
		}
	};
	
	public static Handler updateCustomer = (ctx) -> {
		String CustomerJson = ctx.body();
		Customer Customer = gson.fromJson(CustomerJson, Customer.class);
		cserv.updateCustomer(Customer);
		String json = gson.toJson(Customer);
		ctx.result(json);
	};
	
	
	
}
