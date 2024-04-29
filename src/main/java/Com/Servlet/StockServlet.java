package Com.Servlet;
import java.io.IOException;

import java.io.PrintWriter;

import Com.Dao.RateDAO;
import Com.Dao.SignUpDAO;
import Com.Dao.StockDAO;
import Com.admin.model.Rate;
import Com.admin.model.Stock;
import Com.admin.model.admin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;


public class StockServlet extends HttpServlet {
	private int commercial;
	private int domestic;
	
     public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         commercial = Integer.parseInt(request.getParameter("comStock"));
         domestic = Integer.parseInt(request.getParameter("domStock"));
     
        
         StockDAO s=new StockDAO();
         s.UpdateStock(new Stock(commercial,domestic));
       
         
        response.sendRedirect("StockDetails.jsp");
    }
    	
    	
    }
