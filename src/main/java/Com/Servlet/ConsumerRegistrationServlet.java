package Com.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.*;

import Com.Dao.ConsumerDAO;
import Com.Dao.ConsumerRegistrationDAO;
import Com.admin.model.ConsumerRegistration;
public class ConsumerRegistrationServlet extends HttpServlet {
	
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	private static final LocalDate LocalDate = null;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Name = (String)request.getParameter("Name");
		int Passbook = Integer.parseInt(request.getParameter("Passbook"));
		long adhar = Long.parseLong(request.getParameter("Adhar"));
		int ration = Integer.parseInt(request.getParameter("Ration"));
		String gender = (String)request.getParameter("gender");
		String address = (String)request.getParameter("address");
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		int phone = Integer.parseInt(request.getParameter("phone"));
		String DOB = (String)request.getParameter("DOB");
		String dateOfRegister = (String)request.getParameter("Registration");
		String ConsumerType = (String)request.getParameter("ConsumerType");
		ConsumerRegistrationDAO C = new ConsumerRegistrationDAO();
		 ConsumerDAO cd = new ConsumerDAO();
		int last_id=cd.getLastIdFromDatabase()+1;
		C.UpdateRate(new ConsumerRegistration(last_id,Name,Passbook, adhar, ration, gender, address, pincode, phone, DOB, dateOfRegister, ConsumerType,0));
		
		request.setAttribute("response", "complete");
		
		
	        //response.sendRedirect("ConsumerRegistration.jsp");
	    request.getRequestDispatcher("ConsumerRegistration.jsp").forward(request, response);
		//request.getRequestDispatcher("Consumer.jsp");
	}

}
