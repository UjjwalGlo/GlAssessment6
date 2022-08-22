/*Write an application using SpringMVC with SpringBoot.
You need to read data dynamically from Customer (customerid,customername,customerphone,customeraddress,customerloginid,customerpassword)
 and then display on webpage.*/

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
	@RequestMapping("/hi")
	public String home() {

		return "home";
	}

	@RequestMapping("/hello")
	public String showCustomer(@RequestParam("c_id") int customer_Id, @RequestParam("c_name") String customer_Name,
			@RequestParam("c_phone") int customer_Phone, @RequestParam("c_addr") String customer_Address,
			@RequestParam("c_logid") String customer_loginId, @RequestParam("c_pass") int customer_Password, Model m) {
		m.addAttribute("c_id", customer_Id);
		m.addAttribute("c_name", customer_Name);
		m.addAttribute("c_phone", customer_Phone);
		m.addAttribute("c_addr", customer_Address);
		m.addAttribute("c_logid", customer_loginId);
		m.addAttribute("c_pass", customer_Password);

		return "display";

	}

}