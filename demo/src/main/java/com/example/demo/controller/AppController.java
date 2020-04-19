package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.user.Customer;
import com.example.demo.user.CustomerServices;

@Controller
public class AppController {

	@Autowired
	private CustomerServices custService;
	
	@RequestMapping("/welcomePage")
	public String welcome() {
		return "welcomePage";
	}
	
	@RequestMapping("/successPage")
	public String success() {
		return "successPage";
	}
	
	@PostMapping("/addUser")
	public String registerUser(HttpServletRequest request, HttpSession session) {
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String dob = request.getParameter("dob");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String shipAdd = request.getParameter("shippingAddress");
		String pay = request.getParameter("paymentMethod");

		Customer c = new Customer(fName, lName, dob, username, password, shipAdd, pay);
		custService.addCustomer(c);
		session.setAttribute("customer", c);
		
		return "successPage";
	}
	
	@RequestMapping("/login")
	public String loginUser(@ModelAttribute Customer c, HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (custService.getUserByUsernameAndPassword(username, password) != null) {
			c = custService.getUserByUsernameAndPassword(username, password);
			session.setAttribute("customer", c);
			return "successPage";
		} else {
			request.setAttribute("error", "Invalid Username or Password");
			return "welcomePage";
		}
	}
}