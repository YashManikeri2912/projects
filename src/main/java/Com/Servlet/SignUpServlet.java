package Com.Servlet;
import java.io.IOException;

import java.io.PrintWriter;

import Com.Dao.SignUpDAO;
import Com.admin.model.admin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;


public class SignUpServlet extends HttpServlet {
	private String username;
	private String address;
	private Long phone;
	private String password;
	private String email;
     public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         username = request.getParameter("username");
         address = request.getParameter("address");
         phone = (long) Integer.parseInt(request.getParameter("phone"));
         password = request.getParameter("password");
         email = request.getParameter("email");
         int id=3;
        
         SignUpDAO s=new SignUpDAO();
         s.signup(new admin(id,username,address,phone,email,password));
       
         
        response.sendRedirect("Login.jsp");
    }
    	
    	
    }
