<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="signup.css">
</head>
<body>

    <div class="container">
        <h2>Sign Up</h2>

        <form action="SignUpServlet" method="post">
        
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br>
            
             <label for="address">Address:</label>
            <input type="text" id="address" name="address" required><br>
            
            <label for="phone">Phone No.:</label>
            <input type="text" id="phone" name="phone" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br>

            <input type="submit" value="Sign Up">
          <a href="Login.jsp">I am Alredy Login</a> 
        </form>
    </div>

</body>
</html>

