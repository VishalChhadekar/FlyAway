package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Customer;
import com.hibernate.entity.Flight;
import com.hibernate.util.HibernateUtil;

public class CustomerDao {
	public static void addCustomer(Customer customer) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		session.close();
	}
	
	public static List<Customer> getCustomer(long  phoneNumber ) {
		List<Customer> customer = null;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		customer = session.createQuery("from Customer where Phone='"+phoneNumber+"'").list();
		session.close();
		return customer;
	}



}
