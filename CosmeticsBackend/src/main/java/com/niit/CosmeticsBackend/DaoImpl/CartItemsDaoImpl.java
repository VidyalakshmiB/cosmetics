package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.CartItemsDao;
import com.niit.CosmeticsBackend.Model.CartItems;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.User;

@Transactional
	@Repository("cartItemsDao")
	@EnableTransactionManagement
	public class CartItemsDaoImpl implements CartItemsDao {
		
		@Autowired
		SessionFactory sessionFactory;

		public CartItemsDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		public boolean saveorupdate(CartItems CartItems) {
			sessionFactory.getCurrentSession().saveOrUpdate(CartItems);
			return true;
		}

		@Override
		public boolean delete(CartItems CartItems) {
//			CartItems c= new CartItems();
//			c.setCartitems_Id(c.getCartitems_Id());
			sessionFactory.getCurrentSession().delete(CartItems);
			return true;
		}

		@Override
		public  CartItems getCartItems(String cartitems_Id) {
			// TODO Auto-generated method stub
			String cartitems = "from CartItems where cartitems_Id='" +cartitems_Id+ "'";
			Query q = sessionFactory.getCurrentSession().createQuery(cartitems);
			List<CartItems> cartitemslist = (List<CartItems>) q.list();
			if (cartitemslist == null || cartitemslist.isEmpty()) {
				return null;
			} else {
				return cartitemslist.get(0);
			}
		}

		@Override
		public List<CartItems> list() {
			// TODO Auto-generated method stub
			@SuppressWarnings("deprecation")
			List<CartItems> list = (List<CartItems>) sessionFactory.getCurrentSession().createCriteria(CartItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return list;
		
		}

	
		public List<CartItems> getlist(String cart_Id) {
			String cartitems = "From CartItems where cart_Id='" + cart_Id + "'";
			Query q = sessionFactory.getCurrentSession().createQuery(cartitems);
			List<CartItems> cartitemslist = (List<CartItems>) q.list();
			if (cartitemslist == null || cartitemslist.isEmpty()) {
				return null;
			} else {
				return cartitemslist;
			}
		
		}

		@Override
		public CartItems getlistall(String cart_Id, String prod_Id) {
			String cartitems = "From CartItems where cart_Id= '"+cart_Id+"' and prod_Id='" +prod_Id+ "'" ;
			Query q = sessionFactory.getCurrentSession().createQuery(cartitems);
			List<CartItems> cartitemslist = (List<CartItems>) q.list();
			if (cartitemslist == null || cartitemslist.isEmpty()) {

				return null;

			} else {
				return cartitemslist.get(0);
			}
		}

//		@Override
//		public boolean delete(String cartitems_Id) {
//			CartItems c= new CartItems();
////			c.setCartitems_Id(c.getCartitems_Id());
//			sessionFactory.getCurrentSession().delete(cartitems_Id);
//			return true;
//		}
}