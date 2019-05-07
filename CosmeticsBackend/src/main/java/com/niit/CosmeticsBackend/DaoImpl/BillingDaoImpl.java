package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.BillingDao;
import com.niit.CosmeticsBackend.Model.Billing;

@Transactional
@Repository("billingDao")
@EnableTransactionManagement
public class BillingDaoImpl implements BillingDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public BillingDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(Billing Billing) {
		sessionFactory.getCurrentSession().saveOrUpdate(Billing);
		return true;
	}

	@Override
	public boolean delete(Billing Billing) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(Billing);
		return true;
	}

	@Override
	public  Billing getBilling(String bill_Id) {
		// TODO Auto-generated method stub
		String bil = "from Billing where bill_Id='" + bill_Id + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(bil);
		List<Billing> billist = (List<Billing>) q.list();
		if (billist == null || billist.isEmpty()) {
			return null;
		} else {
			return billist.get(0);
		}
	}

	@Override
	public List<Billing> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		List<Billing> list = (List<Billing>) sessionFactory.getCurrentSession().createCriteria(Billing.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

	@Override
	public Billing getUser(String user_Id) {
		String bil = "from Billing where User_Id='" + user_Id + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(bil);
		List<Billing> billist = (List<Billing>) q.list();
		if (billist == null || billist.isEmpty()) {
			return null;
		} else {
			return billist.get(0);
		}
	}
}
	
	