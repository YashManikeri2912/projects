package Com.Servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import Com.Dao.ConsumerDAO;
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
import java.io.PrintWriter;
import java.io.PrintWriter;
public class ConsumerServlet extends HttpServlet {
	private String username;
	private String address;
	private Long phone;
	private String password;
	private String email;
	public  int Id;
	public ArrayList consumerInfo;
	int dId;
     public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // Id = Integer.parseInt(request.getParameter("Id"));
         String idParameter = request.getParameter("Id");
         String Parameter1 = request.getParameter("Id");
         if (idParameter != null && !idParameter.isEmpty()) {
             Id = Integer.parseInt(idParameter);
         }
         
       //String[] clickedButtons = request.getParameterValues("Button");
  //  if (containsButton(clickedButtons, "button1")) {
//    	   request.setAttribute("message", "Button Clicked!");
//       }
         String buttonClicked = request.getParameter("button");
                ConsumerDAO cd = new ConsumerDAO();
         consumerInfo = cd.SelectConsumer(Id);
         PrintWriter out = response.getWriter();
    
    	   if ("Edit".equals(buttonClicked) ) {
       
             // Logic for button1
             //response.getWriter().write("Button 1 clicked!");
         	   request.setAttribute("edit", true);
         	  request.setAttribute("Info", consumerInfo);
         	
        	 
         	  request.getRequestDispatcher("EditConsumer.jsp").forward(request, response);

            // request.setAttribute("edit", true);
         } else if ("Delete".equals(buttonClicked)) {
        	
        	 cd.deleteConsumerById(dId);
        	  response.sendRedirect("Login.jsp");
        }
    	   
          else {
             response.getWriter().write("No valid button clicked.");
         }
       
    	   
         try {
        	  
             if (consumerInfo!=null&&!consumerInfo.isEmpty()) {
          	   request.setAttribute("Info", consumerInfo);
          	   request.setAttribute("getValue", true);
          	 
          	 dId= (int) consumerInfo.get(0);
             } 
             else {
            	 request.setAttribute("getValue", false);
                 request.setAttribute("invalid", "invalid id");
             }
         }
         catch (IndexOutOfBoundsException e) {
        	 request.setAttribute("Alert", "Consumer Id not found!");          
	        }
          catch (Exception e) {
         e.printStackTrace(); // Handle this exception properly in a real-world scenario
         out.println("<html><head><title>Error Page</title></head><body>");
         out.println("<h2>Oops! An error occurred.</h2>");
         out.println("<p>Error details: " + e.getMessage() + "</p>");
         out.println("</body></html>");
     }
         
        request.getRequestDispatcher("Consumer.jsp").forward(request, response);
        
    }
     
}

