package com.hibernate.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Customer;
import com.hibernate.util.HibernateUtil;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		
//
//		out.println("In the registration servlet");
//		String customerName = request.getParameter("customer_name");
//		String email = request.getParameter("customer_email");
//		String phoneNumber = request.getParameter("customer_phone");
//		String address = request.getParameter("customer_address");
//		String passportNumber = request.getParameter("customer_passport");
//		
//		
//
//		Customer customer = new Customer();
//		customer.setCustName(customerName);
//		customer.setCustEmail(email);
//		customer.setCustPhone(Long.parseLong(phoneNumber));
//		customer.setAddress(address);
//		customer.setPassportNumber(passportNumber);
//
//		
//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//
//		session.save(customer);
//		tx.commit();
//		session.close();
//		out.append("Registered Successfully!");
	}

}
