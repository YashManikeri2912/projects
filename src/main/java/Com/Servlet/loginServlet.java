package Com.Servlet;
import java.io.IOException;
import Com.Dao.*;
import java.io.PrintWriter;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;


public class loginServlet extends HttpServlet {
	private String username;
	private String password;
     public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

         username = request.getParameter("username");
         password = request.getParameter("password");
        
        //out.println("welcome");
    
         //Add your authentication logic here

         SignUpDAO signUpDAO =new SignUpDAO();
   	  
        if (isValidUser(username, password)) {
            //out.println("<h3>Login successful</h3>");
            //RequestDispatcher dispatcher=request.getRequestDispatcher("/home.jsp");
        	//dispatcher.forward(request,response);
        	
        	 request.getSession().setAttribute("loggedIn", true);
        	 response.sendRedirect("home.jsp");
        	//response.sendRedirect("home.jsp");
        } else {
            out.println("<h3>Login failed. Invalid username or password</h3>");
           
        }
    }
     
     private boolean isValidUser(String username, String pass) {
         try {
             
             // Iterate through the result set to check for a matching user
        	 SignUpDAO signUpDAO =new SignUpDAO();
        	 boolean b =signUpDAO.Select(username, pass);
        	 
             return b;
             
         } catch (Exception e) {
             e.printStackTrace(); // Handle this exception properly in a real-world scenario
         }

         // No valid user found
         return false;
     }

	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
    	
    }
