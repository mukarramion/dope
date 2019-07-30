<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<input type="hidden" name="actionvalue" value="${action}" />
   <table style="color:#fff; font-family:courier;">
    <tr>
 
     <td>First Name</td>
    	<c:if test="${action eq 'Add'}">
    		<td><input type="text" name="firstName" pattern="[A-Za-z]+" required /></td>
		</c:if>
     	<c:if test="${action eq 'view'}">
     		<td><input type="text" name="firstName" value="${user.firstName}" disabled="disabled" /></td>
		</c:if>
		<c:if test="${action eq 'Edit'}">
		<td><input type="text" name="firstName" pattern="[A-Za-z]+" required value="${user.firstName}" /></td>
			</c:if>
   	
   	 
   
    
     </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="lastName" pattern="[A-Za-z]+" required /></td>
    </tr>
    <tr>
     <td>UserName</td>
     <c:if test="${action eq 'Add'}">
    		<td><input type="text" name="username" pattern="[A-Za-z]+" required /></td>
		</c:if>
     	<c:if test="${action eq 'view'}">
     		<td><input type="text" name="username" value="${user.firstName}" disabled="disabled" /></td>
		</c:if>
		<c:if test="${action eq 'Edit'}">
		<td><input type="text" name="username"  required value="${user.firstName}" disabled="disabled" /></td>
			</c:if>
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
     <td><input type="text" name="contact" pattern="[0-9]{10}" required/></td>
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