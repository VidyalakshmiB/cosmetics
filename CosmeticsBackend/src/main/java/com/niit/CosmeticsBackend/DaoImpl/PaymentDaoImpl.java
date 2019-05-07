package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.CosmeticsBackend.Dao.PaymentDao;
import com.niit.CosmeticsBackend.Model.Payment;
	
	@Transactional
	@Repository("paymentDao")
	@EnableTransactionManagement
	public class PaymentDaoImpl implements PaymentDao {
		
		@Autowired
		SessionFactory sessionFactory;

		public PaymentDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		public boolean saveorupdate(Payment Payment) {
			sessionFactory.getCurrentSession().saveOrUpdate(Payment);
			return true;
		}

		@Override
		public boolean delete(Payment Payment) {
			// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().delete(Payment);
			return true;
		}

		@Override
		public  Payment getPayment(String payment_Id) {
			// TODO Auto-generated method stub
			String payment = "from Payment where payment_Id='" + payment_Id + "'";
			Query q = sessionFactory.getCurrentSession().createQuery(payment);
			List<Payment> paymentlist = (List<Payment>) q.list();
			if (paymentlist == null || paymentlist.isEmpty()) {
				return null;
			} else {
				return paymentlist.get(0);
			}
		}

		@Override
		public List<Payment> list() {
			// TODO Auto-generated method stub
			@SuppressWarnings("deprecation")
			List<Payment> list = (List<Payment>) sessionFactory.getCurrentSession().createCriteria(Payment.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return list;

		}

}


