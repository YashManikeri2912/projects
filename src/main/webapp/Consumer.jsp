<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"
 %>
<%@ page import="Com.Servlet.*"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Home Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 1em;
            text-align: center;
        }

        nav {
            background-color: #666;
            padding: 0.5em;
            text-align: center;
        }

        nav a {
            color: #fff;
            text-decoration: none;
            margin: 0 10px;
        }

        main {
            padding: 20px;
        }

        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 1em;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <header>
        <h1>Your Website Name</h1>
        <p>Welcome to Consumer page!</p>
    </header>

    <nav>
       
        <a href="ConsumerRegistration.jsp">Add new</a>
        
    </nav>

    <main>
     <form action="ConsumerServlet" method="post">
        <input type="text" name="Id" pattern="[1-9]\d*" value="">       
        <input type="submit" name="search" value="Search Id">
    </form>
   
<head>
      
    <title>Example JSP</title>
    <style>
    
        table {
            border-collapse: collapse;
            width: 50%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
        .my-div {
    background-color: #e0e0e0;
    padding: 20px;
    text-align: center;
}
.my-button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
}
.edit-link {
    text-decoration: none;
    color: #4CAF50;
    font-weight: bold;
    padding: 5px 10px;
    border: 1px solid #4CAF50;
    border-radius: 5px;
}
        
    </style>
</head>
<body>

<%
String s=request.getParameter("Id");
String me = (String)request.getAttribute("invalid");
String Alert = (String)request.getAttribute("Alert");
if(Alert!=null){ %>
	<h4><%= Alert%></h4>
	
<% }%>
<% if(me!=null){ %>
	<h4><%= me%></h4>
	
<% }%>
<h1>Example JSP Page</h1>

<%
 Integer i=-1;
 
 String message = (String)request.getAttribute("message");
 boolean getValue = false;
   getValue = request.getAttribute("getValue") != null && (boolean)request.getAttribute("getValue");


   if(getValue == true){ 
	   
     java.util.ArrayList arr = (java.util.ArrayList) request.getAttribute("Info");
 
   %>
    
   
    <div "class="my-div">
        <table>
    <tr>
        <th>Id</th>        
        <th>Name</th>        
        <th>Passbook No.</th>
        <th>Adhar Card No.</th>
        <th>Rationcard No.</th>
        <th>Gender</th>
        <th>Address </th>      
    </tr>
    <tr>
        <td><%= arr.get(0)%></td>
        <td><%= arr.get(1)%></td>
         <td><%= arr.get(2)%></td>
         <td><%= arr.get(3)%></td>
         <td><%= arr.get(4)%></td>
         <td><%= arr.get(5)%></td>
         <td><%= arr.get(6)%></td>
        
    </tr>
    
</table>

<form action="ConsumerServlet" method="post">
 <button type="submit" name="button" value="Edit" class="my-button">Edit</button>
<button type="submit" name="button" value="Delete" class="my-button">Delete</button>

</form>
    </div> 
    <form action="ConsumerServlet" method="post">
        <input type="hidden" name="parameter1" value="<%= arr.get(0) %>">
        </form>
    <% }%>
   
</body>
</html>
   
    </main>

    <footer>
        &copy; 2023 Your Website. All rights reserved.
    </footer>
</body>
</html>
