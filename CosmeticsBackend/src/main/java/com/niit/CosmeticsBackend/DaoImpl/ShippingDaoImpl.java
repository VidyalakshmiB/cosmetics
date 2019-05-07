package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.ShippingDao;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Shipping;

@Transactional
		@Repository("shippingDao")
		@EnableTransactionManagement
		public class ShippingDaoImpl implements ShippingDao {
			
			@Autowired
			SessionFactory sessionFactory;

			public ShippingDaoImpl(SessionFactory sessionFactory) {
				this.sessionFactory = sessionFactory;
			}

			public boolean saveorupdate(Shipping Shipping) {
				sessionFactory.getCurrentSession().saveOrUpdate(Shipping);
				return true;
			}

			@Override
			public boolean delete(Shipping Shipping) {
				// TODO Auto-generated method stub
				sessionFactory.getCurrentSession().delete(Shipping);
				return true;
			}

			@Override
			public  Shipping getShipping(String ship_Id) {
				// TODO Auto-generated method stub
				String shipping = "from Shipping where ship_Id='" + ship_Id + "'";
				Query q = sessionFactory.getCurrentSession().createQuery(shipping);
				List<Shipping> shippinglist = (List<Shipping>) q.list();
				if (shippinglist == null || shippinglist.isEmpty()) {
					return null;
				} else {
					return shippinglist.get(0);
				}
			}

			
			@Transactional
			public List<Shipping> getaddbyuser(String u_id) {
				String q1 ="from Shipping where user_id='"+u_id+"'";
				Query w = sessionFactory.getCurrentSession().createQuery(q1);
				@SuppressWarnings("unchecked")
				List<Shipping> list = (List<Shipping>) w.list();
				if (list == null || list.isEmpty()) {
					return null;
				}
				return list;
				}
			
			@Override
			public List<Shipping> list() {
				// TODO Auto-generated method stub
				@SuppressWarnings("deprecation")
				List<Shipping> list = (List<Shipping>) sessionFactory.getCurrentSession().createCriteria(Shipping.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
				return list;
			
			
			}

}