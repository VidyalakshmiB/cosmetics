package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.CartDao;
import com.niit.CosmeticsBackend.Model.Cart;

@Transactional
@Repository("cartDao")
@EnableTransactionManagement
public class CartDaoImpl implements CartDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(Cart Cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(Cart);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.niit.CosmeticsBackend.Dao.CartDao#delete(com.niit.CosmeticsBackend.Model.Cart)
	 */
	@Override
	public boolean delete(Cart Cart) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(Cart);
		return true;
	}

	@Override
	public  Cart getCart(String cart_Id) {
		// TODO Auto-generated method stub
		String cart = "from Cart where cart_Id='" + cart_Id + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(cart);
		List<Cart> cartlist = (List<Cart>) q.list();
		if (cartlist == null || cartlist.isEmpty()) {
			return null;
		} else {
			return cartlist.get(0);
		}
	}

	@Override
	public List<Cart> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		List<Cart> list = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

}