package Com.Servlet;
import java.io.IOException;

import java.io.PrintWriter;

import Com.Dao.RateDAO;
import Com.Dao.SignUpDAO;
import Com.admin.model.Rate;
import Com.admin.model.admin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;


public class RateServlet extends HttpServlet {
	private double commercial;
	private double domestic;
	
     public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         commercial = Double.parseDouble(request.getParameter("commRate"));
         domestic = Double.parseDouble(request.getParameter("domRate"));
         
         int id=1;
        
         RateDAO s=new RateDAO();
         s.UpdateRate(new Rate(id,commercial,domestic));
       
         
        response.sendRedirect("RateDetails.jsp");
    }
    	
    	
    }
