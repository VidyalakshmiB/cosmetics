//package com.niit.CosmeticsBackend.test;
//
//import java.util.List;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.CosmeticsBackend.Dao.ShippingDao;
//import com.niit.CosmeticsBackend.Dao.SupplierDao;
//import com.niit.CosmeticsBackend.Dao.UserDao;
//import com.niit.CosmeticsBackend.Model.Shipping;
//import com.niit.CosmeticsBackend.Model.Supplier;
//import com.niit.CosmeticsBackend.Model.User;
//
//public class ShippingTest {
//
//	public static void main(String args[]) {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ctx.scan("com.niit.*");
//		ctx.refresh();
//		Shipping shipping = (Shipping) ctx.getBean("shipping");
//		ShippingDao shippingDao = (ShippingDao) ctx.getBean("shippingDao");
//		User user=(User)ctx.getBean("user");
//		UserDao userDao=(UserDao)ctx.getBean("userDao");
//		
//		
//		
//		shipping.setShip_Id("s201");
//		shipping.setName("shipping1");
//		shipping.setAddress("vasanthnagar");
//		shipping.setCity("Bangalore");
//	    shipping.setPhone(740670);
//	    user=userDao.getUser("u402");
//		shipping.setUser(user);
//		
//	    
//	    
//		if (shippingDao.saveorupdate(shipping) == true) {
//			System.out.print("Shipping saved");
//
//		} else {
//			System.out.print("Shipping Not saved");
//		}
//
//		shipping.setShip_Id("s202");
//		shipping.setName("shipping2");
//		shipping.setName("shipping1");
//		shipping.setAddress("vasanthnagar");
//	    shipping.setCity("Bangalore");
//	    shipping.setPhone(740670);
//	    if (shippingDao.saveorupdate(shipping) == true) {
//			System.out.print("Shipping saved");
//
//		} else {
//			System.out.print("Shipping Not saved");
//		}
//
//	    shipping.setShip_Id("s203");
//	    shipping.setName("shipping3");
//		if (shippingDao.saveorupdate(shipping) == true) {
//			System.out.print("Shipping saved");
//
//		} else {
//			System.out.print("Shipping Not saved");
//		}
//		shipping = shippingDao.getShipping("s201");
//		if (shippingDao.delete(shipping) == true) {
//			System.out.println("Shipping deleted");
//		} else {
//			System.out.println("Shipping not deleted");
//		}
//
//		shipping = shippingDao.getShipping("s202");
//		if (shipping == null) {
//			System.out.println("Shipping is not found");
//		} else {
//			System.out.println(shipping.getShip_Id());
//			System.out.println(shipping.getName());
//			System.out.println(shipping.getAddress());
//			System.out.println(shipping.getCity());	
//			System.out.println(shipping.getPhone());
//			
//		}
//
//		List<Shipping> shippinglist = shippingDao.list();
//		if (shippinglist == null || shippinglist.isEmpty()) {
//			System.out.println("Shipping is empty");
//		} else {
//			for (Shipping s : shippinglist) {
//				System.out.println(s.getShip_Id());
//				System.out.println(s.getName());
//				System.out.println(s.getAddress());
//				System.out.println(s.getCity());
//				System.out.println(s.getPhone());
//			}
//		}
//	}
//}
