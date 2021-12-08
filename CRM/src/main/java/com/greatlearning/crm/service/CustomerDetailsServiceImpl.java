package com.greatlearning.crm.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.crm.entities.CustomerDetails;


@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService{
	
	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public CustomerDetailsServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException ex) {
			session = sessionFactory.openSession();
		}
	}

	@Override
	public List<CustomerDetails> findAll() {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		List<CustomerDetails> custDetails = session.createQuery("from CustomerDetails").list();
		tx.commit();
		return custDetails;
	}

	@Override
	public CustomerDetails findById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		CustomerDetails custDetails = session.get(CustomerDetails.class,id);
		tx.commit();
		return custDetails;
	}

	@Override
	public void save(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customerDetails);
		tx.commit();
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		CustomerDetails custDetails = session.get(CustomerDetails.class,id);
		session.delete(custDetails);
		tx.commit();
	}

}
