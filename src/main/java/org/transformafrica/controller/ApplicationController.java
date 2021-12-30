package org.transformafrica.controller;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.transformafrica.customer.CustomerDTO;
import org.transformafrica.models.Customer;
import org.transformafrica.models.Driver;
import org.transfromafrica.responses.Response;

import io.quarkus.logging.Log;

@ApplicationScoped
@Path("/transfromapi/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ApplicationController {

	@GET
	public List<Driver> getAllDrivers() {
		return Driver.getAllDrivers();

	}

	@POST
	@Transactional
	public Response addCustomer(CustomerDTO customer) {
		Response rsp = new Response();
		if (!customer.isDataValid()) {

			rsp.setDescription("Data invalid");
			rsp.setDescriptionCode(100);
			Log.info("Data invalid!");
			return rsp;
		}

		if (Customer.getCustomerByIDNumber(customer.getIdNumber()).isEmpty()) {
			Customer cust = new Customer();
			cust.setName(customer.getName());
			cust.setsName(customer.getsName());
			cust.setIdNumber(customer.getIdNumber());
			cust.persist();
			rsp.setDescription("Success");
			rsp.setDescriptionCode(10);
			Log.info("Customer Saved!");
			return rsp;

		}

		else {
			rsp.setDescription("Failed");
			rsp.setDescriptionCode(100);
			Log.info("Customer already exist!");
			return rsp;
		}

	}

}
