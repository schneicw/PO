package dev.schneider.app;

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
		
	}
}
