package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Model.Product;

@Transactional
@Repository("productDao")
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(Product Product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(Product);
		
		return true;
	}

	@Override
	public boolean delete(Product Product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(Product);

		return true;
	}

	@Override
	public Product getProduct(String prod_Id) {
		// TODO Auto-generated method stub
		String prod = "From Product where prod_Id='" + prod_Id + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(prod);
		List<Product> prodlist = (List<Product>) q.list();
		if (prodlist == null || prodlist.isEmpty()) {

			return null;
		} else {
			return prodlist.get(0);
		}
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		List<Product> list = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

}
