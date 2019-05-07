package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.Model.Authentication;
import com.niit.CosmeticsBackend.Model.Billing;
import com.niit.CosmeticsBackend.Model.Cart;
import com.niit.CosmeticsBackend.Model.User;

@Transactional
@Repository("userDao")
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


		public boolean saveorupdate(User user) {
		Authentication auth=new Authentication();
		auth.setUserName(user.getUser_EmailId());
		Billing billing = new Billing();
		Cart cart = new Cart();
		user.setBilling(billing);
		user.setCart(cart);
		user.getBilling().setUser(user);
		billing.setAddress(user.getUser_Address());
		billing.setBill_Name(user.getUser_Name());
		billing.setCity(user.getUser_city());
		billing.setUser(user);
	//	user.getBilling().setBill_email(user.getUser_EmailId());
		sessionFactory.getCurrentSession().saveOrUpdate(user.getBilling());
		 System.out.println("\t Billing is SaveorUpdate ");
//		sessionFactory.getCurrentSession().saveOrUpdate(users);
		sessionFactory.getCurrentSession().saveOrUpdate(user.getCart());
		sessionFactory.getCurrentSession().saveOrUpdate(auth);
		 System.out.println("\t Billing is authentiation ");
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		 System.out.println("\t Billing is SaveorUpdate user ");
		return true;
	}


		
		
		@Override
		public boolean delete(User User) {
			// TODO Auto-generated method stub
			

			sessionFactory.getCurrentSession().delete(User);
			return true;
		}
		
		
		
	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		String user = "From User where User_Id='" + userId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(user);
		List<User> userlist = (List<User>) q.list();
		if (userlist == null || userlist.isEmpty()) {

			return null;
		} else {
			return userlist.get(0);
		}
	}
	
	public User getEmail(String usermail) {
		// TODO Auto-generated method stub
		String user = "From User where User_EmailId='" + usermail + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(user);
		List<User> userlist = (List<User>) q.list();
		if (userlist == null || userlist.isEmpty()) {

			return null;
		} else {
			return userlist.get(0);
		}
	}
		

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		List<User> list = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	@Override
	public User isValid(String User_EmailId, String User_password) {
		// TODO Auto-generated method stub
		String user = "From User where User_EmailId= '"+User_EmailId+"' and User_password='" +User_password+ "'" ;
		Query q = sessionFactory.getCurrentSession().createQuery(user);
		List<User> userlist = (List<User>) q.list();
		if (userlist == null || userlist.isEmpty()) {

			return null;

		} else {
			return userlist.get(0);
		}
	}

	
}


