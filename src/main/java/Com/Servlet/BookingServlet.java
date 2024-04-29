package Com.Servlet;
import java.io.IOException;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

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
import java.time.LocalDate;
import java.time.LocalDate;
public class BookingServlet extends HttpServlet {
	private int ConsumerId;
	private int bookingId;
	private String CylinderType;
	private int NoOfCylinder;
	public boolean prsentId;
	public String ctype;
	public ArrayList consumerInfodilivery;
	public ArrayList consumer;
	public ArrayList consumerInfo;
	public String cname;
	public String totalamount;

     public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String idParameter = request.getParameter("Consumer_Id");
        
        //submitbill( request,  response);
        if (idParameter != null && !idParameter.isEmpty()) {
        	ConsumerId = Integer.parseInt(idParameter);
        }
        consumer( request,  response);
        
     
     //   ConsumerId = Integer.parseInt(request.getParameter("Consumer_Id"));
        //bookingId = Integer.parseInt(request.getParameter("autoIncrementedId"));
        //CylinderType = request.getParameter("ConsumerType");
        //NoOfCylinder = Integer.parseInt(request.getParameter("NO_Of_Cylinder"));
        String Date = (String)request.getParameter("Date");
       
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
      
        ConsumerDAO b=new ConsumerDAO();
        consumer= b.SelectConsumer(ConsumerId);
        if(cheak_id(ConsumerId)==true) {
        	 if(check_stock()) {
             	
             	request.setAttribute("stock", "out of stock");
             	request.getRequestDispatcher("Booking.jsp").forward(request, response);
             }
             else {
        BookingDAO Bd = new BookingDAO();
		int last_id=Bd.getLastbIdFromDatabase()+1;
		
	    		 
			
		       
      
        String c_type=consumer.get(11).toString();
        String c_no=consumer.get(12).toString();
        Bd.Insert_BOOKING(new Booking(ConsumerId,last_id,c_type,c_no,formattedDate));
             
        request.setAttribute("success", "cylinder Booked");}
        	
    	
   	 request.getRequestDispatcher("Booking.jsp").forward(request, response);
             }
         
       else {
        	request.setAttribute("presentId", "consumer of this Id does not exist");
        	
        	 request.getRequestDispatcher("Booking.jsp").forward(request, response);

        }
         
        }
    
     public boolean check_stock()
     { StockDAO s = new StockDAO();
     Stock stock = s.SelectStock();
     BookingDAO cd = new BookingDAO();
   consumerInfodilivery = cd.ConsumerDilivery(ConsumerId);
    
     boolean st=false;
    // DiliveryServlet.ctype=(String)consumerInfo.get(2);
     String ctype=(String) consumerInfodilivery.get(2);
     if(ctype.equals("Domestic")) {
    	 
   	if( stock.getDomstock()==0) {
   		st=true;
   		 return st;

   	}else {
   		
   		 return st;
   	}
    }
    else {
   	 
 	   if( stock.getDomstock()==0) {
 	  		st=true;
 	  		 return st;

 	  	}else {
 	  		//request.setAttribute("stock", "out of stock"); 
 	  		 return st;
 	  	}
    }
     }
    	
     public boolean cheak_id(int c_id) {
    	  prsentId=false;
    	 ConsumerDAO cd = new ConsumerDAO();
    	 boolean isPresent = cd.isIdPresent(c_id);
    	 if (isPresent) {
    		 prsentId=true;
    		 
            return prsentId;
         } else {
        	 return prsentId;
         }
    	}
     public void consumer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	 PrintWriter out = response.getWriter();
    try {
    BookingDAO cd = new BookingDAO();
    consumerInfo = cd.ConsumerDilivery(ConsumerId);
   
    ConsumerDAO c = new ConsumerDAO();
    consumer = c.SelectConsumer(ConsumerId);
     cname=(String) consumer.get(1);
  
    totalamount=Double.toString(amt());
    //tamt=amt();
         
        	 
         if (consumerInfo!=null&&!consumerInfo.isEmpty()) {
        	 
      	   request.setAttribute("Info", consumerInfo);
      	   request.setAttribute("getValue", true);
               	
      	 request.setAttribute("t_amount", totalamount );
    	 request.setAttribute("name", cname );
      	 int dId = (int) consumerInfo.get(0);
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
     
    request.getRequestDispatcher("Booking.jsp").forward(request, response);
    
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
    	
    }