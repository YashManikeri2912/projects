<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.concurrent.atomic.AtomicInteger" %>
<%@ page import="Com.Servlet.BookingServlet" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cylinder Booking</title>
    <link rel="stylesheet" type="text/css" href="Booking.css">
</head>
<body>
<style>
.my-div {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #009688;
            color: #fff;
            width: 30%;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
</style>

    <div class="container">
        <h2>Cylinder Booking</h2>

        <form action="BookingServlet" method="post">
        
            <label for="Consumer_Id">Consumer_Id:</label>
            <input type="Consumer_Id" id="booking_id" name="Consumer_Id" required><br>
            
           
             
           
           
          
            
            <input type="submit" value="Book">
       
            <%
            BookingServlet s=new BookingServlet();
           String presentId= (String)request.getAttribute("presentId");
           String stock= (String)request.getAttribute("stock");
            if( presentId !=null) {%>
           	 
            
            <h4><%= presentId%></h4>
            
            <% }%>
          <%  if( stock !=null) {%>
           	 
            
            <h4><%= stock%></h4>
            
            <% }%>
            <%
          
           String success= (String)request.getAttribute("success");
            if( success !=null) {%>
           	 
            
            <h4><%= success%></h4>
            
            <% }%>
        </form>
        
        <% 
        boolean getValue = false;
        getValue = request.getAttribute("getValue") != null && (boolean)request.getAttribute("getValue");
        String mm=(String)request.getAttribute("t_amount");
        String m=(String)request.getAttribute("m");
        String name=(String)request.getAttribute("name");
        if(m!=null){ %>
        
        <h4><%= m%></h4>
        
        <% }%>
        <% 
        if(getValue == true){ 
            java.util.ArrayList ar = (java.util.ArrayList) request.getAttribute("Info");
        %>
         </div>
        <div class="my-div">
            <table>
                <tr>
                    <th>Name</th>
                    <td><%= name %></td>
                </tr>
                <tr>
                    <th>Consumer Id</th>
                    <td><%= ar.get(0) %></td>
                </tr>
                <tr>
                    <th>Booking Id</th>
                    <td><%= ar.get(1) %></td>
                </tr>
                <tr>
                    <th>Cylinder Type</th>
                    <td><%= ar.get(2) %></td>
                </tr>
                <tr>
                    <th>Number of Cylinder</th>
                    <td><%= ar.get(3) %></td>
                </tr>
                <tr>
                    <th>Booking Date No.</th>
                    <td><%= ar.get(4) %></td>
                </tr>
                <tr>
                    <th>Total Amount</th>
                    <td><%= mm %></td>
                </tr>
            </table>
            <%} %>
    </div>
   
</body>
</html>
