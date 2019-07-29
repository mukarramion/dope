<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DOPE</title>
<style>
td{
padding:5px;
}
input
{  padding:8px;
      box-sizing:border-box;
  border: none;
  border-radius: 4px;
}
</style>
</head>
<body style="background-image:url('backG.JPG');background-repeat: no-repeat; background-size: 100% auto;">
 <div align="center">
  <h1 style="color:#ffffff; font-family:courier;text-align:center;">Dope SignUp</h1>
<form action="<%= request.getContextPath() %>/register" method="post">
   <table style="color:#fff; font-family:courier;">
    <tr>
     <td>First Name</td>
     <td><input type="text" name="firstName" pattern="[A-Za-z]+" required /></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="lastName" pattern="[A-Za-z]+" required /></td>
    </tr>
    <tr>
     <td>UserName</td>
     <td><input type="text" name="username" pattern="[A-Za-z0-9]+" required /></td>
    </tr>
    <tr>
     <td>Email-ID</td>
     <td><input type="email" name="email" required /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" required/></td>
    </tr>
    <tr>
     <td>Date of birth</td>
     <td><input type="date" name="dob" required /></td>
    </tr>
    <tr>
     <td>Contact No</td>
     <td><input type="text" name="contact" required/></td>
    </tr>
   </table>
   <br/>
   <input type="submit" value="Submit" style="background-color: #4CAF50;color: white;text-align:center;" />
   &nbsp;
   <input type="reset" value="Reset" style="background-color: #4CAF50;color: white;text-align:center;" />
  </form>
 </div>
</body>
</html>