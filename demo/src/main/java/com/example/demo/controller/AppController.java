package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.item.StockItem;
import com.example.demo.item.StockItemService;
import com.example.demo.user.Customer;
import com.example.demo.user.CustomerServices;

@Controller
public class AppController {

	@Autowired
	private CustomerServices custService;
	
	@Autowired
	private StockItemService stockService;
	
	@RequestMapping("/welcomePage")
	public String welcome() {
		return "welcomePage";
	}
	
	@RequestMapping("/successPage")
	public String success() {
		return "successPage";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "welcomePage";
	}
	
	@RequestMapping("/addProduct")
	public String addProd() {
		return "addProduct";
	}
	
	@RequestMapping("/searchProducts")
	public String searchProducts() {
		return "searchProducts";
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
		} else if (username.equalsIgnoreCase("Admin") && password.equalsIgnoreCase("Admin123")) {
			session.setAttribute("admin", username);
			return "adminSuccess";
			
		} else {
			request.setAttribute("error", "Invalid Username or Password");
			return "welcomePage";
		}
	}
	
	@PostMapping("/addStockItem")
	public String addStock(HttpServletRequest request) {
		String title = request.getParameter("title");
		String manu = request.getParameter("manufacturer");
		double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		String image = request.getParameter("image");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		StockItem si = new StockItem(title, manu, price, category, image, quantity);
		stockService.addItem(si);
		
		return "adminSuccess";
	}
	
	@RequestMapping("/search")
	public String searchQ(@RequestParam("searchQ") String searchQ, HttpServletRequest request,HttpSession session) {
		if(request.getParameter("category") != null) {
			String type = "category";
			session.setAttribute("searchBy", type);
			session.setAttribute("query", searchQ);
			return "searchResults";
			
		} else if (request.getParameter("manufacturer") != null) {
			String type = "manufacturer";
			session.setAttribute("searchBy", type);
			session.setAttribute("query", searchQ);
			return "searchResults";
			
		} else if (request.getParameter("title") != null) {
			String type = "title";
			session.setAttribute("searchBy", type);
			session.setAttribute("query", searchQ);
			return "searchResults";
			
		} else {
			return "searchProducts";
		}
	}		
}