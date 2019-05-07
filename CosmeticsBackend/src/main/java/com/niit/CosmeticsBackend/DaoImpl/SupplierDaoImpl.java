package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.SupplierDao;
import com.niit.CosmeticsBackend.Model.Supplier;

@Transactional
@Repository("supplierDao")
@EnableTransactionManagement
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionFactory;

	public SupplierDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveorupdate(Supplier Supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(Supplier);
		

		return true;
	}

	@Override
	public boolean delete(Supplier Supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(Supplier);

		return true;
	}

	@Override
	public Supplier getSupplier(String supId) {
		// TODO Auto-generated method stub
		String sup = "From Supplier where supId='" + supId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(sup);
		List<Supplier> suplist = (List<Supplier>) q.list();
		if (suplist == null || suplist.isEmpty()) {

			return null;
		} else {
			return suplist.get(0);
		}
	}

	@Override
	public List<Supplier> list() {
		// TODO Auto-generated method stub
		List<Supplier> list = (List<Supplier>) sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

}
