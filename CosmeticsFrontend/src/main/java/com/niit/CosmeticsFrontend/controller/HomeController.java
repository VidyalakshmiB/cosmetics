package com.niit.CosmeticsFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Model.Product;

@Controller
public class HomeController {
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/")
	public String home()
	{
		return "vid";
	}

//	@RequestMapping("/Category")
//	public String category()
//	{
//		return "Category";
//		}
//	
	//@RequestMapping("/Supplier")
    //public String supplier()
    //{ 
		//return "Supplier";
    //}
   
	//@RequestMapping("/Product")
   //public String product()
	//{
	//return "Product";
	//}
//   @RequestMapping("/Signup")
//    public String signup()
//   {
//   	return "Signup";
//    }
//    @RequestMapping("/Login")
//    public String login()
//    {
//    	return "Login";
//    }
	
	
	@RequestMapping("/ProductGal")
	public ModelAndView ProductGallery()
	{
		ModelAndView mv= new ModelAndView("ProductGallery");
		mv.addObject("products",productDao.list());
		
		return mv;
		
	}
	
	@RequestMapping("/Contact")
	public String Contact()
	{
		return "Contact";
	}
  
	@RequestMapping("/About")
	public String About()
	{
		return "About";
	}

}
