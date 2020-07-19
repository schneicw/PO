package dev.schneider.app;

import dev.schneider.controllers.AccountController;
import dev.schneider.controllers.CustomerController;
import io.javalin.Javalin;

public class App {
	public static void main(String[] args) {
		Javalin app = Javalin.create().start(7000);

		//customer 
		
		//create
		app.post("/customers", CustomerController.createCustomer); //good
		//read
		app.get("/customers", CustomerController.getAllCustomers); //good
		app.get("/customers/:id", CustomerController.getCustomerByID); //good
		//update
		app.put("/customers", CustomerController.updateCustomer); //good but still add error shit
		//delete customer and all accounts
		app.delete("/customers/:id", CustomerController.deleteCustomer); //deletes customer but not account
		
		
		//account
		app.post("/customers/:id/accounts", AccountController.createAccount); //good
		app.get("/customers/:id/accounts", AccountController.getAllCustomerAccounts); //good
		
	}
}
