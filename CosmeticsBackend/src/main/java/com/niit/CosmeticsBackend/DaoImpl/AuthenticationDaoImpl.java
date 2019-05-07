package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.AuthenticationDao;
import com.niit.CosmeticsBackend.Model.Authentication;


@Transactional
@Repository("authenticationDao")
@EnableTransactionManagement
public class AuthenticationDaoImpl implements AuthenticationDao {

	@Autowired
	SessionFactory sessionFactory;

	public AuthenticationDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(Authentication Authentication) {
		sessionFactory.getCurrentSession().saveOrUpdate(Authentication);
		return true;
	}

	@Override
	public boolean delete(Authentication Authentication) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(Authentication);
		return true;
	}

	@Override
	public Authentication getAuthentication(String role_Id) {
		// TODO Auto-generated method stub
		String aut = "from Authentication where role_Id='" +role_Id + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(aut);
		List<Authentication> autlist = (List<Authentication>) q.list();
		if (autlist == null || autlist.isEmpty()) {
			return null;
		} else {
			return autlist.get(0);
		}
	}

	@Override
	public List<Authentication> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		List<Authentication> list = (List<Authentication>) sessionFactory.getCurrentSession().createCriteria(Authentication.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}
}
