package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.hibernate.entity.Passenger;
import com.hibernate.util.HibernateUtil;

public class PassengerDao {
	public static void addPassenger(Passenger passenger) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(passenger);
		tx.commit();
		session.close();
	}

}
