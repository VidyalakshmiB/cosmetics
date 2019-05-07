package com.niit.CosmeticsFrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.CosmeticsBackend.Dao.BillingDao;
import com.niit.CosmeticsBackend.Dao.CardDao;
import com.niit.CosmeticsBackend.Dao.CartDao;
import com.niit.CosmeticsBackend.Dao.CartItemsDao;
import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.OrderDao;
import com.niit.CosmeticsBackend.Dao.OrderItemsDao;
import com.niit.CosmeticsBackend.Dao.PaymentDao;
import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Dao.ShippingDao;
import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.Model.Billing;
import com.niit.CosmeticsBackend.Model.Card;
import com.niit.CosmeticsBackend.Model.Cart;
import com.niit.CosmeticsBackend.Model.CartItems;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Order;
import com.niit.CosmeticsBackend.Model.OrderItems;
import com.niit.CosmeticsBackend.Model.Payment;
import com.niit.CosmeticsBackend.Model.Product;
import com.niit.CosmeticsBackend.Model.Shipping;
import com.niit.CosmeticsBackend.Model.User;
import com.niit.CosmeticsFrontend.OTP.OtpGenerator;

	@Controller
	public class OrderController {

		
        @Autowired
        Category category;
        @Autowired
        CategoryDao categoryDao;
		@Autowired
		Cart cart;
		@Autowired
		CartDao cartDao;
		@Autowired
		CartItems cartItems;
		@Autowired
		CartItemsDao cartItemsDao;
		@Autowired
		Billing billing;
		@Autowired
		BillingDao billingDao;
		@Autowired
		Shipping shipping;
		@Autowired
		ShippingDao shippingDao;
		@Autowired
		Order order;
		@Autowired
		OrderDao orderDao;
		@Autowired
		OrderItems orderItems;
		@Autowired
		OrderItemsDao orderItemsDao;
		@Autowired
		Product product;
		@Autowired
		ProductDao productDao;
		@Autowired
		User user;
		@Autowired
		UserDao userDao;
		@Autowired
		PaymentDao paymentDao;
		
		@Autowired
	    private JavaMailSender mailSender;
		
		
		@Autowired
		List<CartItems> cartItems1;
			
		String o;
		
		@RequestMapping("/Buyall")
		public String orderall(Model model,HttpSession session) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
				String currusername = authentication.getName();
				user = userDao.getEmail(currusername);
				cart = user.getCart();
				
				product=null;
//				session.setAttribute("products", product1);			
				cartItems1= cartItemsDao.getlist(cart.getCart_Id());
					System.out.println(cartItems1.get(0));
					if(cartItems1==null || cartItems1.isEmpty())
					{
						return "redirect:/viewcart";
					}
					else
					{
											
					billing = billingDao.getUser(user.getUser_Id());
					System.out.println(2345678);
					List<Shipping> shippingAddresies = shippingDao.getaddbyuser(user.getUser_Id());
					
					model.addAttribute("billing", billing);
					model.addAttribute("user", user);
					model.addAttribute("shippingAddresies", shippingAddresies);
					model.addAttribute("shippingAddress", new Shipping());
					session.setAttribute("prot", product);
				}
				return "Billing";
			} 
			else
			{
				return "redirect:/";
			}
			}
		

		@RequestMapping("/Buy/{prodId}/{cartItemsId}")
		public String order(@PathVariable("prodId") String id,@PathVariable("cartItemsId") String id2,Model model,HttpSession session)
		{
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken))
			{
				String currusername = authentication.getName();
				user = userDao.getEmail(currusername);
				cart = user.getCart();
				cartItems1=null;
				
				product = productDao.getProduct(id);
				billing = billingDao.getUser(user.getUser_Id());
				cartItems=cartItemsDao.getCartItems(id2);
				
				System.out.println(billing.getCity());
//				for(Billing b: billing)
//				{
//					System.out.println(b.getBillId());
//					System.out.println(b.getCountry());
//				}
				List<Shipping> shippingAddresies = shippingDao.getaddbyuser(user.getUser_Id());
				user.setBilling(billing);
				model.addAttribute("billing", billing);
				model.addAttribute("user", user);
				model.addAttribute("shippingAddresies", shippingAddresies);
				model.addAttribute("shippingAddress", new Shipping());
				session.setAttribute("prot", product);
				model.addAttribute("citem",cartItems);
				List<Category> categories=categoryDao.list();
				model.addAttribute("lcat",categories);
				System.out.println(product.getProd_Name());
				return "Billing";
			} else {
				return "redirect:/";
			}

		}
		
		@RequestMapping("/shipping")
		public String shipping(Model model) {
			model.addAttribute("billing", billing);
			model.addAttribute("shippingAddress", shipping);
			model.addAttribute("prot", product);
			model.addAttribute("cartItems1",cartItems1);
			model.addAttribute("cart",cart);
			return "Shipping";
		}
		
		@RequestMapping("/orderConfirm")
		public String payment(@ModelAttribute("shippingAddress") Shipping sh, Model model) {
			sh.setUser(user);
			shipping = sh;
			model.addAttribute("billing", billing);
			model.addAttribute("shippingAddress", shipping);
			model.addAttribute("prot", product);
			System.out.println(435678);
//			System.out.println(product.getProd_Name());
			System.out.println(345678);
			model.addAttribute("cartItems1",cartItems1);
			model.addAttribute("cart",cart);
			return "orderconfirm";
		}

		@RequestMapping("/previous")
		public String previous(Model model) {
			List<Shipping> shippingAddresies = shippingDao.getaddbyuser(user.getUser_Id());
			model.addAttribute("shippingAddresies", shippingAddresies);
			model.addAttribute("billing", billing);
			model.addAttribute("shippingAddress", shipping);
			model.addAttribute("product", product);
			
			return "addressorder";
		}

		
		@RequestMapping("/pay")
		public String pay(Model model) {
			return "Pay";
				
		}
		
		
		@RequestMapping("/paym")
		public String pay(Model model, @RequestParam("paym") String paym, @ModelAttribute("payment") Payment pay) {
			int i;
			if(paym==null)
				i=4;
			else 
				i=1;
			switch (i) {
			case 1:if(true)
			{
				if(paym.equals("cod"))
			     {
					pay.setPayment_Method("COD");
					  pay.setPayment_Status("NO");
					  paymentDao.saveorupdate(pay);
					 return "Otp";	
					
			     }
				break;
				
			}
			case 2:if(true)
			{
				if(paym.equals("card"))
			     {
					pay.setPayment_Method("Card");
					pay.setPayment_Status("yes");
					paymentDao.saveorupdate(pay);
					 return "Card";	
			     }
			
				break;}
				
			case 3:if(true)
			{
				
				if(paym.equals("net"))
			     {
					pay.setPayment_Method("NetBanking");
					pay.setPayment_Status("yes");
					paymentDao.saveorupdate(pay);
					 return "net";	
			     }
			
			}
			
			
			return "redirect:/payment";
					
		}
			return paym;
		}


	

		
		@RequestMapping("/payment")
		public String paymet(
				@ModelAttribute("payment") Payment pay,
				@RequestParam("otp")String paym,
				Model model) {
					pay.setPayment_Method(paym);
					pay.setPayment_Status("yes");
					paymentDao.saveorupdate(pay);
						
					return "redirect:/orderconfirmation";
		}
		
		
		@RequestMapping("/netpayment")
		public String netpayment(Model model) {
					return "redirect:/orderconfirmation";
		}
		
		
		
		
		@RequestMapping("/orderconfirmation")
		public String orderconformation(HttpSession session) {
			System.out.println(32);
			order.setBilling(billing);
			order.setShipping(shipping);
//			order.setPay(pay);
			order.setUser(user);
			System.out.println(524);
			if (cartItems1 == null) 
			{
				order.setGrand_Total(product.getProd_price());
				orderDao.saveorupdate(order);
				orderItems.setOrder(order);
				orderItems.setProduct_Id(product.getProd_Id());
				orderItemsDao.saveorupdate(orderItems);
				System.out.println(cart.getGrand_Total());
				System.out.println(cartItems.getPrice());
				cart.setGrand_Total(cart.getGrand_Total() - cartItems.getPrice());
				cart.setTotal_qty(cart.getTotal_qty() - 1);
				session.setAttribute("items", cart.getTotal_qty());
				cartDao.saveorupdate(cart);
				String cartItem=cartItemsDao.getlistall(cart.getCart_Id(),product.getProd_Id()).getCartitems_Id();
				cartItems=cartItemsDao.getCartItems(cartItem);
				cartItemsDao.delete(cartItems);
				System.out.println(324);
			}
			else
			{ 
				System.out.println(656);
				order.setGrand_Total(cart.getGrand_Total());
				orderDao.saveorupdate(order);
				for(CartItems c:cartItems1)
				{
					System.out.println(3444);
					orderItems.setOrder(order);
					orderItems.setProduct_Id(c.getProd().getProd_Id());
					System.out.println(3443);
					orderItemsDao.saveorupdate(orderItems);
					cartItemsDao.delete(c);
				}
				cart.setGrand_Total(0.0);
				cart.setTotal_qty(0);
				System.out.println(346);
				session.setAttribute("items", cart.getTotal_qty());
				cartDao.saveorupdate(cart);
			}
			cartItems=null;
			cartItems1=null;
			product=null;
			order=new Order();
			orderItems=new OrderItems();
			System.out.println(565);
			return "Thankyou";
		}
	

		
		@RequestMapping(value="/SendMail")
		public void SendMail() {
			System.out.println(21312);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getEmail(currusername);      
			OtpGenerator otp=new OtpGenerator();
			String o=otp.Otpga();
			o=otp.Otpga();
			String recipientAddress = user.getUser_EmailId();
			String subject="OTP";
		//String subject = request.getParameter("subject");
		String message = "your one time password is "+o+" ";

		//prints debug info
		System.out.println("To:" + recipientAddress);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);

		    
		System.out.println("OTP:"+ otp);
		//creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		//email.setSubject(otp);
		 //sends the e-mail
		mailSender.send(email);

		
		// forwards to the view named "Result"
		//return "Result";
		}
		}
		
	
	}