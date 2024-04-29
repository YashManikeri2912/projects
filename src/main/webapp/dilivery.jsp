<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.concurrent.atomic.AtomicInteger" %>
<%@ page import="Com.Servlet.BookingServlet" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cylinder Booking</title>
    <link rel="stylesheet" type="text/css" href="Booking.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            margin: 0;
            padding: 0;
        }

       header {
            background-color: #009688;
            color: #fff;
            text-align: center;
            padding: 20px 0;
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
        }

        main {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        form {
            margin-bottom: 20px;
        }

        form input {
            padding: 10px;
            margin-right: 10px;
        }

        h4 {
            color: #009688;
            margin-top: 0;
        }

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
        .save-button {
            text-align: center;
            margin-top: 20px;
        }

        .save-button input {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #009688;
            color: #fff;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <header>
        <h1>Cylinder Billing</h1>
    </header>
    <main>
        <form action="DiliveryServlet" method="post">
            <input type="text" name="Id" pattern="[1-9]\d*" value="">
            <input type="submit" name="search" value="Search Id">
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
        </div>
         <div class="save-button">
            <form action="DiliveryServlet" method="post">
                <input type="submit" name="save"value="Confirm Dilivery">
            </form>
        </div>
        <% } %> 
    </main>
</body>
</html>
