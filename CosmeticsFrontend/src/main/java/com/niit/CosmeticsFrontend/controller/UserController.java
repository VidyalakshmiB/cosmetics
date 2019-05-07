package com.niit.CosmeticsFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.Model.Cart;
import com.niit.CosmeticsBackend.Model.User;

@Controller
public class UserController {

@Autowired
User user;
@Autowired
UserDao userDao;

@RequestMapping("/User")
public ModelAndView userform()
{
	List<User> users=userDao.list();
ModelAndView obj=new ModelAndView("Signup");
obj.addObject("user",new User());
obj.addObject("users",users);
return obj;
}

@RequestMapping(value="/adduse",method=RequestMethod.POST)
public ModelAndView addcategory(@ModelAttribute("user")User user)
{
	Cart c=new Cart();
	user.setCart(c);
	ModelAndView obj= new ModelAndView("redirect:/User");
	if(userDao.saveorupdate(user)==true)
	{
		obj.addObject("echo","User is added successfully");
	}
	else
	{
		obj.addObject("echo","User is not added successfully");
	}
	return obj;

}

}

