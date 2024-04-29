package Com.Servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import Com.Dao.ConsumerDAO;
import Com.Dao.ConsumerRegistrationDAO;
import Com.Dao.RateDAO;
import Com.Dao.SignUpDAO;
import Com.admin.model.ConsumerRegistration;
import Com.admin.model.Rate;
import Com.admin.model.admin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import java.io.PrintWriter;
public class EditConsumer extends HttpServlet {
	private String username;
	private String address;
	private Long phone;
	private String password;
	private String email;
	public  int Id;
	ArrayList consumerInfo;
     public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html");
       
    	 try {
    		    String Name = request.getParameter("Name");
    		    int Passbook = Integer.parseInt(request.getParameter("Passbook"));
    		    long adhar = Long.parseLong(request.getParameter("Adhar"));
    		    int ration = Integer.parseInt(request.getParameter("Ration"));
    		    String gender = request.getParameter("Gender");
    		    String address = request.getParameter("address");
    		    int pincode = Integer.parseInt(request.getParameter("pincode"));
    		    int phone = Integer.parseInt(request.getParameter("phone"));
    		    String DOB = request.getParameter("DOB");
    		    String dateOfRegister = request.getParameter("Registration");
    		    String ConsumerType = request.getParameter("ConsumerType");
    		    int no_of_cylinder = Integer.parseInt(request.getParameter("no_of_consumer"));

    		    ConsumerRegistrationDAO C = new ConsumerRegistrationDAO();
    		    C.EditConsumer(new ConsumerRegistration(1, Name, Passbook, adhar, ration, gender, address, pincode, phone, DOB, dateOfRegister, ConsumerType, no_of_cylinder));

    		    // Continue with the rest of your logic

    		} catch (NumberFormatException e) {
    		    // Handle the exception gracefully
    		    e.printStackTrace(); // Log the exception or print stack trace for debugging
    		    // You may set default values, show an error message, or redirect the user to an error page
    		    // For example:
    		    // response.sendRedirect("error.jsp");
    		    // or set default values:
    		    // int defaultPhone = 0;
    		    // int phone = Integer.parseInt(request.getParameter("phone", String.valueOf(defaultPhone)));
    		} catch (Exception e) {
    		    // Handle other exceptions if needed
    		    e.printStackTrace(); // Log the exception or print stack trace for debugging
    		}

		//request.setAttribute("response", "complete");
    	 response.sendRedirect("Consumer.jsp");
		
	        //response.sendRedirect("ConsumerRegistration.jsp");
	    //request.getRequestDispatcher("ConsumerRegistration.jsp").forward(request, response);
		//request.getRequestDispatcher("Consumer.jsp");
    }
     
}

