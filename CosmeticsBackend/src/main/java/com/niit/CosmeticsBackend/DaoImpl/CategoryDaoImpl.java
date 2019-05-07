package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Model.Category;

@Transactional
@Repository("categoryDao")
@EnableTransactionManagement
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(Category Category) {
		sessionFactory.getCurrentSession().saveOrUpdate(Category);
		return true;
	}

	@Override
	public boolean delete(Category Category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(Category);
		return true;
	}

	@Override
	public Category getCategory(String catId) {
		// TODO Auto-generated method stub
		String cat = "from Category where catId='" + catId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(cat);
		List<Category> catlist = (List<Category>) q.list();
		if (catlist == null || catlist.isEmpty()) {
			return null;
		} else {
			return catlist.get(0);
		}
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		List<Category> list = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

}
