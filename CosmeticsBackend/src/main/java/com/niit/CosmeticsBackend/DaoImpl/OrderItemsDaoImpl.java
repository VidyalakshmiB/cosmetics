package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.OrderItemsDao;
import com.niit.CosmeticsBackend.Model.OrderItems;
import com.niit.CosmeticsBackend.Model.Product;

@Transactional
		@Repository("orderitemsDao")
		@EnableTransactionManagement
		public class OrderItemsDaoImpl implements OrderItemsDao {
			
			@Autowired
			SessionFactory sessionFactory;

			public OrderItemsDaoImpl(SessionFactory sessionFactory) {
				this.sessionFactory = sessionFactory;
			}

			public boolean saveorupdate(OrderItems OrderItems) {
				sessionFactory.getCurrentSession().saveOrUpdate(OrderItems);
				return true;
			}

			@Override
			public boolean delete(OrderItems OrderItems) {
				// TODO Auto-generated method stub
				sessionFactory.getCurrentSession().delete(OrderItems);
				return true;
			}

			@Override
			public  OrderItems getOrderItems(String orderitems_Id) {
				// TODO Auto-generated method stub
				String orderitems = "from OrderItems where orderitems_Id='" + orderitems_Id + "'";
				Query q = sessionFactory.getCurrentSession().createQuery(orderitems);
				List<OrderItems> orderitemslist = (List<OrderItems>) q.list();
				if (orderitemslist == null || orderitemslist.isEmpty()) {
					return null;
				} else {
					return orderitemslist.get(0);
				}
			}

			@Override
			public List<OrderItems> list() {
				// TODO Auto-generated method stub
				List<OrderItems> list = (List<OrderItems>) sessionFactory.getCurrentSession().createCriteria(OrderItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

				return list;
			}


	
}
