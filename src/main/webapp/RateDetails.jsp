<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Com.Dao.*" %>
<%@ page import="Com.admin.model.Rate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rate Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            color: #333;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #333;
            color: #fff;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        a {
            text-decoration: none;
            color: #3498db;
        }

        a:hover {
            text-decoration: underline;
        }
        
    </style>
</head>
<body>

    <h2>Rate Details</h2>

    <table border="1">
        <tr>
            <th>id</th>
            <th>commRate</th>
            <th>DommRate</th>
            <th>Action</th>
        </tr>

        <%
            // Sample data for demonstration
            // List<Rate> rateList = new ArrayList<>();
            //rateList.add(new Rate("Commercial",23));
            // rateList.add(new Rate("Domestic", 7.5));

            // for (Rate rate : rateList) {
            RateDAO rateDao = new RateDAO();
            Rate rate = rateDao.SelectRate();
        %>
        <tr>
            <td><%= rate.getId() %></td>
            <td><%= rate.getCommRate() %></td>
            <td><%= rate.getDomRate() %></td>
            <td><a href="UpdateRate.html">update</a></td>
        </tr>
    </table>

</body>
</html>
