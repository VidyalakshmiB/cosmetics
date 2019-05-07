package com.niit.CosmeticsFrontend.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Product;
import com.niit.CosmeticsFrontend.FileInput.FileInput;


@Controller
public class ProductController {

@Autowired
Product product;
@Autowired
ProductDao productDao;

String path="C:\\Users\\Vidhya\\eclipse-workspace\\CosmeticsFrontend\\webapp\\resources\\images\\";

@RequestMapping("/Product")
public ModelAndView productform()
{
	List<Product> products=productDao.list();
ModelAndView obj=new ModelAndView("Product");
obj.addObject("product",new Product());
obj.addObject("products",products);
return obj;
}


@RequestMapping(value="/addprod",method=RequestMethod.POST)
public ModelAndView addproduct(@ModelAttribute("product")Product product)
{
	ModelAndView obj=new ModelAndView("redirect:/Product");
	
//	String filepath=req.getSession().getServletContext().getRealPath("/");
//	String filename=file.getOriginalFilename();
//	product.setImagename(filename);
	FileInput.upload(path,product.getPimg(),product.getProd_Id()+".jpg");
	if(productDao.saveorupdate(product))
{
	obj.addObject("msg","product is added successfully");
}
else
{
	obj.addObject("msg","Sorry! Product is not added");
}
//try
//{
//	byte[] imagebyte=file.getBytes();
//	BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
//	fos.write(imagebyte);
//	fos.close();
//}
//catch(Exception e)
//{
//}
return obj;
}
@RequestMapping("/editproduct/{prod_Id}")
public ModelAndView editproduct(@PathVariable("prod_Id")String prod_Id)
{
	System.out.println(123);
	List<Product> products=productDao.list();
	ModelAndView obj=new ModelAndView("Product");
	product=productDao.getProduct(prod_Id);
	obj.addObject("product",product);
	obj.addObject("products", products);
	return obj;
}


 @RequestMapping("/deleteproduct/{prod_Id}")
 public ModelAndView deleteproduct(@PathVariable("prod_Id")String  prod_Id)
 {
	 ModelAndView obj=new ModelAndView("redirect:/Product");
	 Product lists=productDao.getProduct(prod_Id);
	 if(productDao.delete(lists)==true)
	 {
		 System.out.println("Product deleted successfully");
		 obj.addObject("msg","Product deleted successfully ");
	 }
	 else
	 {
		 obj.addObject("msg","Product not deleted successfully ");
	 }
		 
	
 return obj;
 }
 
}





