<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Consumer Register Form</title>
    <style>
    input[type="radio"] {
      margin-right: 5px;
    }

    label {
      display: inline-block;
      margin-bottom: 10px;
    }
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        div {
            text-align: center;
            margin-top: 50px;
        }

        h1 {
            color: #333;
        }

        table {
            width: 80%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        td {
            padding: 5px;
            text-align: left;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div>
        <h1>Consumer Register Form</h1>
        <form action="ConsumerRegistrationServlet" method="post">
            <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="Name" pattern="[A-Za-z]+" title="Please enter only letters" required/></td>
                </tr>
                <tr>
                    <td>Passbook No.</td>
                    <td><input type="text" name="Passbook" pattern="[0-9]+" title="Please enter only numbers" required/></td>
                </tr>
                <tr>
                    <td>Adhar Card No.</td>
                    <td><input type="text" name="Adhar" pattern="[0-9]+" title="Please enter only numbers" required/></td>
                </tr>
                <tr>
                    <td>Ration Card No.</td>
                    <td><input type="text" name="Ration" pattern="[0-9]+" title="Please enter only numbers" required/></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                     <label>
                       <input type="radio" name="gender" value="male">
                      Male
                     </label>
                     <label>
                       <input type="radio" name="gender" value="female">
                      Female
                     </label>
                    </td>
                </tr> 
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address" required/></td>
                </tr>
                <tr>
                    <td>Pincode</td>
                    <td><input type="text" name="pincode" pattern="[0-9]+" title="Please enter only numbers" required/></td>
                </tr>
                <tr>
                    <td>Phone No.</td>
                    <td><input type="text" name="phone" pattern="[0-9]+" title="Please enter only numbers" required/></td>
                </tr>
                <tr>
                    <td>DOB</td>
                    <td><input type="Date" name="DOB" required/></td>
                </tr>
                 <tr>
                    <td>Registration Date</td>
                    <td><input type="Date" name="Registration" required/></td>
                </tr>
                <tr>
                    <td>Consumer Type</td>
                    <td>
                     <label>
                       <input type="radio" name="ConsumerType" value="Commercial">
                      Commercial
                     </label>
                     <label>
                       <input type="radio" name="ConsumerType" value="Domestic">
                      Domestic
                     </label>
                    </td>
                </tr>
                
            </table>
            <input type="submit" value="Submit" />
        </form>
    </div>
    <lable><%String mm = (String)request.getAttribute("response"); %><td><%= mm%></td></lable>
</body>
</html>
