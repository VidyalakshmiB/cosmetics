package com.niit.CosmeticsFrontend.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CosmeticsBackend.Dao.CartDao;
import com.niit.CosmeticsBackend.Dao.CartItemsDao;
import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.Model.Cart;
import com.niit.CosmeticsBackend.Model.CartItems;
import com.niit.CosmeticsBackend.Model.Product;
import com.niit.CosmeticsBackend.Model.User;




@Controller
public class CartController {
	
	
	@Autowired 
	User user;
	
	
	@Autowired 
	UserDao userDao;
	
	@Autowired
	Cart cart;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;
	
	@Autowired
	Product product;
	
	@Autowired 
	ProductDao productDao;
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("/addtocart/{prod_Id}")
	public ModelAndView cart(@PathVariable("prod_Id") String id) {
		System.out.println("getting inside");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getEmail(currusername);
			if (u == null) {
				System.out.println("getting null");
				return new ModelAndView("redirect:/");
			} else {
				System.out.println("getting cart");
				 cart= u.getCart();
				product = productDao.getProduct(id);
				CartItems cartItems = new CartItems();
				cartItems.setCart(cart);
				cartItems.setProd(product);
				cartItems.setPrice(product.getProd_price());
				System.out.println(5675);
				
				cartItemsDao.saveorupdate(cartItems);
				System.out.println(7766);
				System.out.println(cart.getGrand_Total());
				System.out.println(product.getProd_price());
				cart.setGrand_Total(cart.getGrand_Total() + product.getProd_price());
				cart.setTotal_qty(cart.getTotal_qty() + 1);
				System.out.println(6564);
				cartDao.saveorupdate(cart);
				session.setAttribute("items", cart.getTotal_qty());
				session.setAttribute("gd", cart.getGrand_Total());
				return new ModelAndView("redirect:/");
			}
		} else {
			return new ModelAndView("redirect:/");
		}

	}
	@RequestMapping("/viewcart")
	public String viewcart(Model model, HttpSession session) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getEmail(currusername);
		        Cart c=u.getCart();
				List<CartItems> cartItems = cartItemsDao.getlist(u.getCart().getCart_Id());
				if(cartItems==null ||cartItems.isEmpty())
				{
					session.setAttribute("items",0);
					model.addAttribute("gtotal",0.0);
					model.addAttribute("msg", "no Items is added to cart");
					return "viewcart";		
				}
				model.addAttribute("cartItems", cartItems);
				session.setAttribute("gtotal",c.getGrand_Total());
				session.setAttribute("items",c.getTotal_qty());
			    session.setAttribute("cartId", c.getCart_Id());
					
				System.out.println(1223);
				return "viewcart";	
		}
		else
		{
			return "redirect:/";
		}
		
	}
	@RequestMapping("/addtocartR/{id}")
	public ModelAndView cartr(@PathVariable("id") String id) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getEmail(currusername);
			if (u == null) {
				return new ModelAndView("redirect:/");
			} else {

				cart = u.getCart();
				product = productDao.getProduct(id);
				CartItems cartItems = new CartItems();
				cartItems.setCart(cart);
				cartItems.setProd(product);
				cartItems.setPrice(product.getProd_price());
				cartItemsDao.saveorupdate(cartItems);
				cart.setGrand_Total(cart.getGrand_Total() + product.getProd_price());
				cart.setTotal_qty(cart.getTotal_qty() + 1);
				cartDao.saveorupdate(cart);
				session.setAttribute("items", cart.getTotal_qty());
				session.setAttribute("gd", cart.getGrand_Total());
				return new ModelAndView("redirect:/viewcart");
			}
		} else {
			return new ModelAndView("redirect:/");
		}

	}
	@RequestMapping("/addtocartC/{id}")
	public ModelAndView cartc(@PathVariable("id") String id) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getEmail(currusername);
			if (u == null) {
				return new ModelAndView("redirect:/");
			} else {

				cart = u.getCart();
				product = productDao.getProduct(id);
				CartItems cartItems = new CartItems();
				cartItems.setCart(cart);
				cartItems.setProd(product);
				cartItems.setPrice(product.getProd_price());
				cartItemsDao.saveorupdate(cartItems);
				cart.setGrand_Total(cart.getGrand_Total() + product.getProd_price());
				cart.setTotal_qty(cart.getTotal_qty() + 1);
				cartDao.saveorupdate(cart);
				session.setAttribute("items", cart.getTotal_qty());
				session.setAttribute("gd", cart.getGrand_Total());
				return new ModelAndView("redirect:/viewcart");
			}
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	@RequestMapping(value="/Remove/{cartitems_Id}")
	public String RemoveFromCart(@PathVariable("cartitems_Id") String id)
	{
		cartItems=cartItemsDao.getCartItems(id);
		Cart c=cartItems.getCart();
		c.setGrand_Total(c.getGrand_Total()-cartItems.getPrice());
		c.setTotal_qty(c.getTotal_qty()-1);
		cartDao.saveorupdate(c);
		cartItemsDao.delete(cartItems);
//		String cid=(cartItems.getCartitems_Id());
//		cartItemsDao.delete(cartItems);
//		(cartItemDao.get(cartItem.getCartItem_Id()));
		return "redirect:/viewcart";
	}
	
@RequestMapping (value="/Removeall")
	public String RemoveallFromCart(Model model,HttpSession session)
	{
		Cart c=cartDao.getCart((String)session.getAttribute("cartId"));
		String ss= ((String)session.getAttribute("cartId"));
		 try{
		List<CartItems> cartItems=cartItemsDao.getlist(ss);
		for(CartItems g:cartItems)
		{
			 CartItems cait =cartItemsDao.getCartItems(g.getCartitems_Id());
		 cartItemsDao.delete(g);
		
			
		}
		 }
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			} 
		
		c.setGrand_Total(0.0);
		c.setTotal_qty(0);
		cartDao.saveorupdate(c);
		session.setAttribute("items",c.getTotal_qty());
		return "redirect:/viewcart";
	}
}