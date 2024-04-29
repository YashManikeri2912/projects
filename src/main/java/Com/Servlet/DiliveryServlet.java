package Com.Servlet;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Com.DB.DbConfig;
import Com.Dao.BookingDAO;
import Com.Dao.ConsumerDAO;
import Com.Dao.RateDAO;
import Com.Dao.SignUpDAO;
import Com.Dao.StockDAO;
import Com.admin.model.Booking;
import Com.admin.model.Rate;
import Com.admin.model.Stock;
import Com.admin.model.admin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import java.io.PrintWriter;
public class DiliveryServlet extends HttpServlet {
	private String username;
	private String address;
	private Long phone;
	private String password;
	private String email;
	public  int Id;
	static ArrayList consumerInfo;
	ArrayList consumer;
	int dId;
	 LocalDate currentDate = LocalDate.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     String formattedDate = currentDate.format(formatter);
     String totalamount;
     double tamt;
     String cname;
     static String ctype;
     public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
       
        String idParameter = request.getParameter("Id");
   
        submitbill( request,  response);
        if (idParameter != null && !idParameter.isEmpty()) {
            Id = Integer.parseInt(idParameter);
        }
        consumer( request,  response);
        
     }
        public void consumer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        	 PrintWriter out = response.getWriter();
        try {
        BookingDAO cd = new BookingDAO();
        consumerInfo = cd.ConsumerDilivery(Id);
       
        ConsumerDAO c = new ConsumerDAO();
        consumer = c.SelectConsumer(Id);
         cname=(String) consumer.get(1);
      
        totalamount=Double.toString(amt());
        tamt=amt();
             
            	 
             if (consumerInfo!=null&&!consumerInfo.isEmpty()) {
            	 
          	   request.setAttribute("Info", consumerInfo);
          	   request.setAttribute("getValue", true);
                   	
          	 request.setAttribute("t_amount", totalamount );
        	 request.setAttribute("name", cname );
          	 dId= (int) consumerInfo.get(0);
             } 
            else {
            	 
            	 request.setAttribute("getValue", false);
                 request.setAttribute("invalid", " invalid id");
             }
         }
         catch (IndexOutOfBoundsException e) {
        	 request.setAttribute("m", "Consumer Id not found!");          
	        }
              
          catch (Exception e) {
         e.printStackTrace(); // Handle this exception properly in a real-world scenario
         out.println("<html><head><title>Error Page</title></head><body>");
         out.println("<h2>Oops! An error occurred.</h2>");
         out.println("<p>Error details: " + e.getMessage() + "</p>");
         out.println("</body></html>");
     }
         
        request.getRequestDispatcher("dilivery.jsp").forward(request, response);
        
    }
  
    public double amt() {
    	
    	
    	 double r;
    	 RateDAO rateDao = new RateDAO();
         Rate rate = rateDao.SelectRate();
         String ctype=(String) consumerInfo.get(2);
         int cno=(int) consumerInfo.get(3);
         if(ctype.equals("Domestic")) {
        	 
        	  r=cno* rate.getDomRate();
         }
         else {
        	 
             r= cno*rate.getCommRate();
         }
    	
     	return r;
    	}
     
public void submitbill(HttpServletRequest request, HttpServletResponse response) {
	  String buttonClicked = request.getParameter("save");
	  boolean diliveryCheck=false;
	if("Confirm Dilivery".equals(buttonClicked)&& buttonClicked!=null) {
		  BookingDAO b=new BookingDAO();
		  diliveryCheck=true;
	        Booking dbook=new Booking(formattedDate,tamt,diliveryCheck,cname);
	        b.Insert_Bill(Id,dbook);
	        try { request.setAttribute("Info", consumerInfo);
	        request.getRequestDispatcher("bill.jsp").forward(request, response);
	        
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
}


