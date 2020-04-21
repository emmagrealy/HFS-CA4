package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.demo.allCustomersDetailsIterator.CustomerList;
import com.example.demo.allCustomersDetailsIterator.Iterator;
import com.example.demo.allCustomersDetailsIterator.PurchaseHistory;
import com.example.demo.cardValidationTemplateMethod.AbstractCardValidator;
import com.example.demo.cardValidationTemplateMethod.MastercardValidation;
import com.example.demo.cardValidationTemplateMethod.VisaValidation;
import com.example.demo.decorator.AdminUser;
import com.example.demo.decorator.UserType;
import com.example.demo.item.StockItem;
import com.example.demo.item.StockItemService;
import com.example.demo.loyaltyCardsStrategyAndSingleton.BasicCard;
import com.example.demo.loyaltyCardsStrategyAndSingleton.LoyaltyCard;
import com.example.demo.loyaltyCardsStrategyAndSingleton.NoCard;
import com.example.demo.loyaltyCardsStrategyAndSingleton.PremiumCard;
import com.example.demo.order.ItemOrders;
import com.example.demo.order.ItemOrdersService;
import com.example.demo.reviews.Reviews;
import com.example.demo.reviews.ReviewsService;
import com.example.demo.sortingStrategy.SortByCategory;
import com.example.demo.sortingStrategy.SortByManufacturer;
import com.example.demo.sortingStrategy.SortByName;
import com.example.demo.sortingStrategy.SortByPrice;
import com.example.demo.sortingStrategy.SortingContext;
import com.example.demo.stockState.InStock;
import com.example.demo.stockState.OutOfStock;
import com.example.demo.stockState.StockState;
import com.example.demo.user.Customer;
import com.example.demo.user.CustomerService;

@Controller
public class AppController {

	private ArrayList<StockItem> cart = new ArrayList<StockItem>();

	@Autowired
	private CustomerService custService;

	@Autowired
	private StockItemService stockService;

	@Autowired
	private ItemOrdersService orderService;
	
	@Autowired
	private ReviewsService reviewService;

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
		cart.clear();
		session.invalidate();
		return "welcomePage";
	}

	@RequestMapping("/addProduct")
	public String addProd() {
		return "addProduct";
	}

	@RequestMapping("/searchProducts")
	public String searchProductsResults() {
		return "searchProducts";
	}
	
	@RequestMapping("/adminSearch")
	public String adminSearch() {
		return "adminSearch";
	}

	@RequestMapping("/purchase")
	public String purchase() {
		return "purchasePage";
	}
	
	@RequestMapping("/adminSuccess")
	public String adminSuccess() {
		return "adminSuccess";
	}
	
	@RequestMapping("/viewReviews")
	public String viewReviews(HttpServletRequest request, HttpSession session) {
		int id = Integer.parseInt(request.getParameter("itemId"));
		StockItem item = stockService.getItemById(id);
		System.out.println(item.toString());
		session.setAttribute("reviewItem", item);
		return "viewReview";
	}
	
	@RequestMapping("purchaseStock")
	public String purchaseStock(HttpServletRequest request, HttpSession session) {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		session.setAttribute("itemID", itemId);
		return "purchaseStock";
	}
	
	@RequestMapping("/addReview")
	public String addReview(@SessionAttribute("customer") Customer c, HttpServletRequest request, HttpSession session) {
		String comment = request.getParameter("comment");
		int rating = Integer.parseInt(request.getParameter("rating"));
		
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		
		Reviews r = new Reviews(comment, rating);
		reviewService.addReview(r);
		
		int id = c.getUserId();
		c = custService.getCustomerById(id);
		c.getReviews().add(r);
		custService.updateCustomer(id, c);
		
		StockItem item = stockService.getItemById(itemId);
		item.getReviews().add(r);
		stockService.updateItem(itemId, item);
		
		return "successPage";
	}
	
	@RequestMapping("/sortResults")
	public String sortResults(@SessionAttribute("searchResult") ArrayList<StockItem> searchStock, HttpServletRequest request, HttpSession session) {
		String sortBy = request.getParameter("sortBy");
		String order = request.getParameter("orderList");
		
		SortingContext context = new SortingContext();
		if(sortBy.equals("Title")) {
			context.setSortingMethod(new SortByName());
			if(order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			}
			else if(order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		} 
		else if(sortBy.equals("Price")) {
			context.setSortingMethod(new SortByPrice());
			if(order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			}
			else if(order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		} 
		else if(sortBy.equals("Manufacturer")) {
			context.setSortingMethod(new SortByManufacturer());
			if(order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			}
			else if(order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		} 
		else if(sortBy.equals("Category")) {
			context.setSortingMethod(new SortByCategory());
			if(order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			}
			else if(order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		}
		
		
		return "searchResults";
	}
	
	@RequestMapping("/aSortResults")
	public String aSortResults(@SessionAttribute("searchResult") ArrayList<StockItem> searchStock, HttpServletRequest request, HttpSession session) {
		String sortBy = request.getParameter("sortBy");
		String order = request.getParameter("orderList");
		
		SortingContext context = new SortingContext();
		if(sortBy.equals("Title")) {
			context.setSortingMethod(new SortByName());
			if(order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			}
			else if(order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		} 
		else if(sortBy.equals("Price")) {
			context.setSortingMethod(new SortByPrice());
			if(order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			}
			else if(order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		} 
		else if(sortBy.equals("Manufacturer")) {
			context.setSortingMethod(new SortByManufacturer());
			if(order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			}
			else if(order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		} 
		else if(sortBy.equals("Category")) {
			context.setSortingMethod(new SortByCategory());
			if(order.equals("Ascending Order")) {
				context.sortAscending(searchStock);
			}
			else if(order.equals("Descending Order")) {
				context.sortDescending(searchStock);
			}
		}
		
		
		return "adminSearchResults";
	}
	
	@RequestMapping("/purchaseHistory")
	public String purchaseHist(HttpServletRequest request, HttpSession session) {
		int custId = Integer.parseInt(request.getParameter("userId"));
		Customer c = custService.getCustomerById(custId);
		session.setAttribute("viewCust", c);

		final ArrayList<ItemOrders> orders;
		orders = (ArrayList<ItemOrders>) orderService.getAllOrders();		
		
		PurchaseHistory purcHist = new PurchaseHistory(orders); 		//List of all orders made being iterated
		ArrayList<ItemOrders> listOrders = new ArrayList<ItemOrders>(); //New list that orders for this user added to
		
		//orders belonging to the current customer
		Set<ItemOrders> theOrder = c.getUserOrders(); 
		for (Iterator iter = purcHist.getIterator(); iter.hasNext();) {
			ItemOrders order = (ItemOrders) iter.next();
			for(ItemOrders o: theOrder) {
				if (order.getOrderId() == o.getOrderId()) {
					listOrders.add(o);
				}
			}
		}
		session.setAttribute("purchHist", listOrders);
		return "purchaseHistory";
	}
	
	@RequestMapping("/customerDetails")
	public String customerDetails(HttpSession session) {
		final ArrayList<Customer> customers;
		customers = (ArrayList<Customer>) custService.getAllCustomers();
		
		CustomerList listCust = new CustomerList(customers);
		ArrayList<Customer> listAll = new ArrayList<Customer>();
		for (Iterator iter = listCust.getIterator(); iter.hasNext();) {
			Customer name = (Customer) iter.next();
			int id = name.getUserId();
			String fName = name.getFirstName();
			String lName = name.getLastName();
			Customer c1 = new Customer(id, fName, lName);
			listAll.add(c1);
		}
		session.setAttribute("allCust", listAll);
		return "customerDetails";
	}

	@RequestMapping("/myCart")
	public String myCart(@SessionAttribute("customer") Customer c,HttpSession session, HttpServletRequest request) {
		int count = 0;
		double price = 0.0;
		for (StockItem currItem : cart) {
			count = count + 1;
			double prodPrice = currItem.getPrice();
			price = price + prodPrice;
		}
		
		
		String loyaltyCard = c.getLoyaltyCard();
		if (loyaltyCard.equals("Basic")) {
			LoyaltyCard lc = BasicCard.getInstance();
			double discount = lc.applyTheDiscount();
			double totalPrice = price - (price * discount);
			session.setAttribute("totalPrice", totalPrice);
		}
		else if (loyaltyCard.equals("Premium")) {
			LoyaltyCard lc = PremiumCard.getInstance();
			double discount = lc.applyTheDiscount();
			double totalPrice = price - (price * discount);
			session.setAttribute("totalPrice", totalPrice);
		}
		else {
			LoyaltyCard lc = NoCard.getInstance();
			double discount = lc.applyTheDiscount();
			double totalPrice = price - (price * discount);
			session.setAttribute("totalPrice", totalPrice);
		}
		
		session.setAttribute("quantity", count);
		session.setAttribute("subTotal", price);
		return "myCart";
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
		String loyaltyCard = request.getParameter("lc");

		Customer c = new Customer(fName, lName, dob, username, password, shipAdd, pay, loyaltyCard);
		custService.addCustomer(c);
		session.setAttribute("customer", c);
		session.setAttribute("loyalty", loyaltyCard);

		return "successPage";
	}

	@RequestMapping("/login")
	public String loginUser(@ModelAttribute Customer c, HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserType user1;
		if (custService.getUserByUsernameAndPassword(username, password) != null) {
			c = custService.getUserByUsernameAndPassword(username, password);
			session.setAttribute("customer", c);
			session.setAttribute("loyalty", c.getLoyaltyCard());
			
			user1 = new Customer();
			return user1.login();

		} else if (username.equalsIgnoreCase("Admin") && password.equalsIgnoreCase("Admin123")) {
			session.setAttribute("admin", username);
			
			user1 = new AdminUser();
			return user1.login();

		} else {
			request.setAttribute("error", "Invalid Username or Password");
			return "welcomePage";
		}
	}

	@PostMapping("/addStockItem")
	public String addStock(HttpServletRequest request, HttpSession session) {
		String title = request.getParameter("title");
		String manu = request.getParameter("manufacturer");
		double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		String image = request.getParameter("image");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		boolean state;
		StockState noStock = new OutOfStock();
		StockState hasStock = new InStock();
		
		if (quantity <= 0) {
			state = noStock.stateOfStock();
		}
		else {
			state = hasStock.stateOfStock();
		}

		StockItem si = new StockItem(title, manu, price, category, image, quantity, state);
		stockService.addItem(si);

		return "adminSuccess";
	}
	
	@RequestMapping("aSearch")
	public String aSearch(@RequestParam("searchQ") String searchQ, HttpServletRequest request, HttpSession session) {
		
		ArrayList<StockItem> items = (ArrayList<StockItem>) stockService.getAllItems();
		ArrayList<StockItem> searchStock = new ArrayList<StockItem>();
		if (request.getParameter("category") != null) {
			for(StockItem s: items) {
				if(s.getCategory().contains(searchQ)) {
					searchStock.add(s);
				}
			}
			
			session.setAttribute("searchResult", searchStock);
			
			return "adminSearchResults";

		} else if (request.getParameter("manufacturer") != null) {
			for(StockItem s: items) {
				if(s.getManufacturer().equalsIgnoreCase(searchQ)) {
					searchStock.add(s);
				}
			}
			
			session.setAttribute("searchResult", searchStock);
			return "adminSearchResults";

		} else if (request.getParameter("title") != null) {
			for(StockItem s: items) {
				if(s.getTitle().contains(searchQ)) {
					searchStock.add(s);
				}
			}
			
			session.setAttribute("searchResult", searchStock);
			return "adminSearchResults";

		} else {
			return "adminSearch";
		}
	}

	@RequestMapping("/search")
	public String searchQ(@RequestParam("searchQ") String searchQ, HttpServletRequest request, HttpSession session) {
		
		ArrayList<StockItem> items = (ArrayList<StockItem>) stockService.getAllItems();
		ArrayList<StockItem> searchStock = new ArrayList<StockItem>();
		if (request.getParameter("category") != null) {
			for(StockItem s: items) {
				if(s.getCategory().contains(searchQ)) {
					searchStock.add(s);
				}
			}
			session.setAttribute("searchResult", searchStock);
			return "searchResults";

		} else if (request.getParameter("manufacturer") != null) {
			for(StockItem s: items) {
				if(s.getManufacturer().equalsIgnoreCase(searchQ)) {
					searchStock.add(s);
				}
			}
			
			session.setAttribute("searchResult", searchStock);
			return "searchResults";

		} else if (request.getParameter("title") != null) {
			for(StockItem s: items) {
				if(s.getTitle().contains(searchQ)) {
					searchStock.add(s);
				}
			}
			
			session.setAttribute("searchResult", searchStock);
			return "searchResults";

		} else {
			return "searchProducts";
		}
	}

	@RequestMapping("/addToCart")
	public String addCart(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("itemId"));
		StockItem newItem = stockService.getItemById(id);

		cart.add(newItem);
		
		newItem.setQuantity(newItem.getQuantity() -1);

		boolean state;
		StockState noStock = new OutOfStock();
		StockState hasStock = new InStock();
		
		if (newItem.getQuantity() <= 0) {
			state = noStock.stateOfStock();
		}
		else {
			state = hasStock.stateOfStock();
		}
		newItem.setState(state);

		HttpSession session = request.getSession();
		session.setAttribute("list", cart);

		return "successPage";
	}

	@PostMapping("/completePurchase")
	public String completePurchase(@SessionAttribute("customer") Customer c, HttpServletRequest request,
			HttpSession session) {

		String cardName = request.getParameter("cardName");
		String cardNumber = request.getParameter("cardNumber");
		int expiryDateMonth = Integer.parseInt(request.getParameter("expiryDateMonth"));
		int expiryDateYear = Integer.parseInt(request.getParameter("expiryDateYear"));
		String cvv = request.getParameter("cvv");

		boolean result = false;
		AbstractCardValidator validator = null;

		String cardType = request.getParameter("cardType");
		if (cardType.equals("Visa Card")) {
			validator = new VisaValidation(AppController.this, cardName, cardNumber, expiryDateMonth, 
					expiryDateYear, cvv);

		} else if (cardType.equals("MasterCard")) {
			validator = new MastercardValidation(AppController.this, cardName, cardNumber, expiryDateMonth,
					expiryDateYear, cvv);
		}

		result = validator.validate();

		if (!result) {
			request.setAttribute("error", "Invalid Card Details");
			return "purchasePage";
			
		} else {
			double totalPrice = Double.parseDouble(request.getParameter("tp"));
			ItemOrders newOrder = new ItemOrders(totalPrice);
			orderService.addOrder(newOrder);
			ItemOrders newOrder1 = orderService.getOrderById(newOrder.getOrderId());
			
			for (StockItem s : cart) {
				newOrder1.getProducts().add(s);
			}
			orderService.updateOrder(newOrder1.getOrderId(), newOrder1);

			int customerId = c.getUserId();
			Customer newCustomer = custService.getCustomerById(customerId);
			newCustomer.getUserOrders().add(newOrder1);
			custService.updateCustomer(customerId, newCustomer);

			cart.clear();
			return "successPage";
		}
	}
	
	@PostMapping("/stockPurchase")
	public String stockPurchase(@SessionAttribute("itemID") int itemID, HttpServletRequest request,
			HttpSession session) {

		String cardName = request.getParameter("cardName");
		String cardNumber = request.getParameter("cardNumber");
		int expiryDateMonth = Integer.parseInt(request.getParameter("expiryDateMonth"));
		int expiryDateYear = Integer.parseInt(request.getParameter("expiryDateYear"));
		String cvv = request.getParameter("cvv");

		boolean result = false;
		AbstractCardValidator validator = null;

		String cardType = request.getParameter("cardType");
		if (cardType.equals("Visa Card")) {
			validator = new VisaValidation(AppController.this, cardName, cardNumber, expiryDateMonth, 
					expiryDateYear, cvv);

		} else if (cardType.equals("MasterCard")) {
			validator = new MastercardValidation(AppController.this, cardName, cardNumber, expiryDateMonth,
					expiryDateYear, cvv);

		}

		result = validator.validate();

		if (!result) {
			request.setAttribute("error", "Invalid Card Details");
			return "purchasePage";
			
		} else {
			int newQuantity = Integer.parseInt(request.getParameter("quantity"));
			
			StockItem item = stockService.getItemById(itemID);
			int oldQuantity = item.getQuantity();
			item.setQuantity(oldQuantity + newQuantity);
			
			boolean state;
			StockState noStock = new OutOfStock();
			StockState hasStock = new InStock();
			
			if (item.getQuantity() <= 0) {
				state = noStock.stateOfStock();
			}
			else {
				state = hasStock.stateOfStock();
			}
			item.setState(state);
			
			stockService.updateItem(itemID, item);

			return "adminSuccess";
		}
	}

}