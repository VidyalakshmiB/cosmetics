package com.niit.CosmeticsBackend.DaoImpl;





import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.CardDao;
import com.niit.CosmeticsBackend.Model.Card;
import com.niit.CosmeticsBackend.Model.Cart;


	@Repository(value="cardDao")
	@EnableTransactionManagement

	public class CardDaoImpl implements CardDao {
		
		@Autowired
		SessionFactory sessionFactory;
		public CardDaoImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		
		@Transactional//when ever user says to save the data it will perform that action
		public boolean saveorupdate(Card card) {
			sessionFactory.getCurrentSession().saveOrUpdate(card);
			return true;
		}

		@Transactional
		public boolean delete(Card card) {
		  sessionFactory.getCurrentSession().delete(card);
			return true;
		}

		@Transactional
		public Card get(String id) {
			String q1="from Card where Card_id='"+id+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q1);
			List<Card>list =(List<Card>) w.list();//typecasting
			if(list==null||list.isEmpty())
			{
				return null;
			}
			
			return list.get(0);
		}
		
		@Transactional
		public List<Card> getcardbyuser(String User_Id) {
			String q1 ="from Card where User_Id='"+User_Id+"'";
			Query w = sessionFactory.getCurrentSession().createQuery(q1);
			@SuppressWarnings("unchecked")
			List<Card> list = (List<Card>) w.list();
			if (list == null || list.isEmpty()) {
				return null;
			}
			return list;
		}


		@Override
		public List<Card> list() {
			// TODO Auto-generated method stub
			@SuppressWarnings("deprecation")
			List<Card> list = (List<Card>) sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return list;
		}

//		@Override
//		public Cart getCart(String card_Id) {
//			// TODO Auto-generated method stub
//			return null;
//		}

	}
