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
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import java.io.PrintWriter;
public class Logout extends HttpServlet {
	
     public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html");
    	 HttpSession session = request.getSession(false);
         if (session != null) {
             session.invalidate();
             request.getSession().setAttribute("loggedIn", false);
         }
         response.sendRedirect("Login.jsp"); // Redirect to your login page
     }
     }


