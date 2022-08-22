/*Develop an application using SpringBoot with RestFull Web Services(CRUD Operations).
 Perform Insert,delete,update,select operations and Test this application using PostMan Tool.
Hint: TableName: Customer
columnnames: customerid,customername,customerphone,customeraddress,customerloginid,customerpassword ..etc.*/

package com.ujjwal.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujjwal.demo.dao.CustomerRepo;
import com.ujjwal.demo.model.Customer;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepo repo;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return repo.findAll();
	}

	@RequestMapping("/customer/{cid}")
	public Optional<Customer> getCustomer(@PathVariable("cid") int cid) {
		return repo.findById(cid);
	}

	@PostMapping(path = "/customer", consumes = { "application/json" })
	public Customer addCustomer(@RequestBody Customer customer) {
		repo.save(customer);
		return customer;
	}

	@DeleteMapping("/customer/{cid}")
	public String deleteAlien(@PathVariable int cid) {
		Customer c = repo.getOne(cid);
		repo.delete(c);
		return "Deleted";
	}

	@PutMapping(path = "/customer", consumes = { "application/json" })
	public Customer saveOrUpdateAlien(@RequestBody Customer customer) {
		repo.save(customer);
		return customer;
	}

}
