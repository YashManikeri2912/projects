<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="Com.Servlet.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Consumer Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .my-div {
            margin: 20px;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        input[type="text"], input[type="date"] {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            box-sizing: border-box;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        label {
            margin-bottom: 5px;
            display: block;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<%
boolean edit = false;
edit = request.getAttribute("edit") != null && (boolean)request.getAttribute("edit");

if(edit == true) {
    java.util.ArrayList arr = (java.util.ArrayList) request.getAttribute("Info");
%>
<div class="my-div">
    <form action="EditConsumer" method="post">
        <table>
            <tr>
                <th>Id</th>
                <td><%= arr.get(0)%></td>
            </tr>
            <tr>
                <th>Name</th>
                <td><input type="text" name="Name" placeholder="<%= arr.get(1)%>"></td>
            </tr>
            <tr>
                <th>Passbook No.</th>
                <td><input type="text" name="Passbook" placeholder="<%= arr.get(2)%>"></td>
            </tr>
            <tr>
                <th>Adhar Card No.</th>
                <td><input type="text" name="Adhar" placeholder="<%= arr.get(3)%>"></td>
            </tr>
            <tr>
                <th>Ration Card No.</th>
                <td><input type="text" name="Ration" placeholder="<%= arr.get(4)%>"></td>
            </tr>
            <tr>
                <th>Gender</th>
                <td>
                    <label><input type="radio" name="Gender" value="Male" <%= arr.get(5).equals("Male") ? "checked" : "" %>> Male</label>
                    <label><input type="radio" name="Gender" value="Female" <%= arr.get(5).equals("Female") ? "checked" : "" %>> Female</label>
                </td>
            </tr>
            <tr>
                <th>Address</th>
                <td><input type="text" name="address" placeholder="<%= arr.get(6)%>"></td>
            </tr>
            <tr>
                <th>Pincode</th>
                <td><input type="text" name="pincode" placeholder="<%= arr.get(7)%>"></td>
            </tr>
            <tr>
                <th>Phone</th>
                <td><input type="text" name="phone" placeholder="<%= arr.get(8)%>"></td>
            </tr>
            <tr>
                <th>DOB</th>
                <td><input type="date" name="DOB" placeholder="<%= arr.get(9)%>"></td>
            </tr>
            <tr>
                <th>Registration</th>
                <td><input type="date" name="Registration" placeholder="<%= arr.get(10)%>"></td>
            </tr>
            <tr>
                <th>Consumer Type</th>
                <td>
                    <label><input type="radio" name="ConsumerType" value="commercial" <%= arr.get(11).equals("comercial") ? "checked" : "" %>> Commercial</label>
                    <label><input type="radio" name="ConsumerType" value="domestic" <%= arr.get(11).equals("domestic") ? "checked" : "" %>> Domestic</label>
                </td>
            </tr>
            <tr>
                <th>No of Cylinders</th>
                <td><input type="text" name="no_of_consumer" placeholder="<%= arr.get(12)%>"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form>
</div>
<%
}
%>

</body>
</html>
