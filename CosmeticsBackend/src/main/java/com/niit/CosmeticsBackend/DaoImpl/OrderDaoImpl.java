package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.OrderDao;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Order;

@Transactional
		@Repository("orderDao")
		@EnableTransactionManagement
		public class OrderDaoImpl implements OrderDao {
			
			@Autowired
			SessionFactory sessionFactory;

			public OrderDaoImpl(SessionFactory sessionFactory) {
				this.sessionFactory = sessionFactory;
			}

			public boolean saveorupdate(Order Order) {
				sessionFactory.getCurrentSession().saveOrUpdate(Order);
				return true;
			}

			@Override
			public boolean delete(Order Order) {
				// TODO Auto-generated method stub
				sessionFactory.getCurrentSession().delete(Order);
				return true;
			}

			@Override
			public  Order getOrder(String order_Id) {
				// TODO Auto-generated method stub
				String order = "from Order where order_Id='" + order_Id + "'";
				Query q = sessionFactory.getCurrentSession().createQuery(order);
				List<Order> orderlist = (List<Order>) q.list();
				if (orderlist == null || orderlist.isEmpty()) {
					return null;
				} else {
					return orderlist.get(0);
				}
			}

			@Override
			public List<Order> list() {
				// TODO Auto-generated method stub
				@SuppressWarnings("deprecation")
				List<Order> list = (List<Order>) sessionFactory.getCurrentSession().createCriteria(Order.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
				return list;
	
			}

}