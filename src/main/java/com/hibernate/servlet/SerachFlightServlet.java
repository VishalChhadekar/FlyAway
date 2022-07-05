package com.hibernate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.entity.Flight;
import com.hibernate.entity.FlightDetails;
import com.hibernate.util.HibernateUtil;

@WebServlet("/search-flight")
public class SerachFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SerachFlightServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tripType = request.getParameter("tripType");
		String departing = request.getParameter("fromPlace");
		String destination = request.getParameter("destination");
		String departingDate = request.getParameter("date");
		
		Date new_date = null;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
		try {
			new_date = (Date) formatter.parse(departingDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		String query = "from Flight where Departing=:x and Destination=:y and Date=:z";
		Query q = session.createQuery(query);
		q.setParameter("x", departing);
		q.setParameter("y", destination);
		q.setParameter("z", new_date);

		List<Flight> flights = q.list();

		if (flights.isEmpty()) {
			out.println("<h1>Sorry, No flights available<h1>");
		} else {
			out.println("<h1>Flight List :-</h1>");
			out.println("<style> table,td,th { border:2px solid green; padding:10px; } </style>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th> BOOK </th>");
			out.println("<th> Flight ID </th>");
			out.println("<th> Flight Number </th>");
			out.println("<th> Company </th>");
			out.println("<th> Departing From </th>");
			out.println("<th> Destination </th>");
			out.println("<th> Date </th>");
			out.println("<th> Time </th>");
			out.println("<th> Seats </th>");
			out.println("<th> Economy Class</th>");
			out.println("<th> Business Class</th>");
			out.println("</tr>");
			for (Flight ft : flights) {
				out.println("<tr>");
				out.println("<td>" + "<a href='flight-details.jsp?company=" + ft.getCompany() + "&departing="
						+ ft.getDeparting() + "&destination=" + ft.getDestination() + "&date=" + ft.getDate() + "&time"
						+ ft.getTime() + "&seats=" + ft.getSeats() + "&bcPrice=" + ft.getBc_price() + "&ecPrice="
						+ ft.getEc_price() + "&flightNumber=" + ft.getFlightNumber() + 
						 "&flightId=" + ft.getF_Id()+ "'>Book</a>" + "</td>");
				out.println("<td>" + ft.getF_Id() + "</td>");
				out.println("<td>" + ft.getFlightNumber() + "</td>");
				out.println("<td>" + ft.getCompany() + "</td>");
				out.println("<td>" + ft.getDeparting() + "</td>");
				out.println("<td>" + ft.getDestination() + "</td>");
				out.println("<td>" + ft.getDate() + "</td>");
				out.println("<td>" + ft.getTime() + "</td>");
				out.println("<td>" + ft.getSeats() + "</td>");
				out.println("<td>" + ft.getEc_price() + "</td>");
				out.println("<td>" + ft.getBc_price() + "</td>");
				out.println("</tr>");
			}
		}

		out.println("</table></body></html>");
		session.close();
		out.println("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
