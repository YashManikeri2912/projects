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
        
         .print-button {
            margin-top: 20px;
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <header>
        <h1> Bill</h1>
    </header>
    <main>
        

        
        <% 
       
            java.util.ArrayList ar = (java.util.ArrayList) request.getAttribute("Info");
        %>
        <div class="my-div">
          <img src="E:\" alt="Company Logo" class="company-logo">
            <table>
                <tr>
                    <th>Name</th>
                     <td><%= ar.get(7) %></td>
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
                    <th>Booking Date </th>
                    <td><%= ar.get(4) %></td>
                </tr>
                <tr>
                    <th>Dilivery Date</th>
                    <td><%= ar.get(5) %></td>
                </tr>
                 <tr>
                    <th>Total amount</th>
                    <td><%= ar.get(6) %></td>
                </tr>
                
            </table>
        </div>
          <button class="print-button" onclick="printBill()">Print</button>
       <script>
        function printBill() {
            window.print();
        }
    </script>
    </main>
</body>
</html>
