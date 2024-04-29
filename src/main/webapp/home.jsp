<!DOCTYPE html>
<html lang="en"><%@ page import="java.util.Objects" %>

<%
response.setHeader("Cache-control", "no-Cache,no-store,must-revalidate");
    Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
    if (Objects.isNull(loggedIn) || !loggedIn) {
        response.sendRedirect("Login.jsp");
    }
%>

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
             background-image: url('E:\HP-gas-logo-eps.jpg');
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
        <h1>Your Website</h1>
        <p>Welcome to our home page!</p>
         <form action="Logout" method="get">
        <input type="submit" value="Logout">
    </form>
    </header>

    <nav>
        <a href="Consumer.jsp">Consumer</a>
        <a href="RateDetails.jsp">Rate</a>
        <a href="StockDetails.jsp">Stock</a>
        <a href="Booking.jsp">Booking</a>
        <a href="dilivery.jsp">Billing</a>
    </nav>

    <main>
   
        <h2>Featured Content</h2>
        <p>This is where you can showcase your featured content.</p>
    </main>

    <footer>
        &copy; 2023 Your Website. All rights reserved.
    </footer>
</body>
</html>