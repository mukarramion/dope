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
    		<td><input type="text" name="firstName" required /></td>
		</c:if>
     	<c:if test="${action eq 'view'}">
     		<td><input type="text" name="firstName" value="${user.firstName}" disabled="disabled" /></td>
		</c:if>
		<c:if test="${action eq 'Edit'}">
		<td><input type="text" name="firstName" required value="${user.firstName}" /></td>
			</c:if>
   	
   	 
   
    
     </tr>
    <tr>
     <td>Last Name</td>
     <c:if test="${action eq 'Add'}">
    		<td><input type="text" name="lastName"  required /></td>
		</c:if>
     	<c:if test="${action eq 'view'}">
     		<td><input type="text" name="lastName" value="${user.lastName}" disabled="disabled" /></td>
		</c:if>
		<c:if test="${action eq 'Edit'}">
		<td><input type="text" name="lastName" required value="${user.lastName}" /></td>
			</c:if>
    
    </tr>
    <tr>
     <td>UserName</td>
     <c:if test="${action eq 'Add'}">
    		<td><input type="text" name="username"  required /></td>
		</c:if>
     	<c:if test="${action eq 'view'}">
     		<td><input type="text" name="username" value="${user.username}" disabled="disabled" /></td>
		</c:if>
		<c:if test="${action eq 'Edit'}">
		<td>
		<input type="text" name="username"  required value="${user.username}" disabled="disabled" />
		<input type="hidden" name="usernamevalue"  required value="${user.username}"/>
		</td>
			</c:if>
         </tr>
    <tr>
     <td>Email-ID</td>
     <c:if test="${action eq 'Add'}">
    		<td><input type="email" name="email" required /></td>
		</c:if>
     	<c:if test="${action eq 'view'}">
     		<td><input type="email" name="email" value="${user.email}" disabled="disabled" /></td>
		</c:if>
		<c:if test="${action eq 'Edit'}">
		<td><input type="email" name="email"  required value="${user.email}" /></td>
			</c:if>
    </tr>
    <c:if test="${action ne 'Edit'}">
    <tr>
     <td>Password</td>
    <c:if test="${action eq 'Add'}">
    		<td><input type="password" name="password"  required /></td>
		</c:if>
     	<c:if test="${action eq 'view'}">
     		<td><input type="password" name="password" value="${user.password}" disabled="disabled" /></td>
		</c:if>		
    </tr>
    </c:if>
    <tr>
     <td>Date of birth</td>
    <c:if test="${action eq 'Add'}">
    		<td><input type="date" name="dob"  required /></td>
		</c:if>
     	<c:if test="${action eq 'view'}">
     		<td><input type="date" name="dob" value="${user.dob}" disabled="disabled" /></td>
		</c:if>
		<c:if test="${action eq 'Edit'}">
		<td><input type="date" name="dob"  required value="${user.dob}" /></td>
			</c:if>
    </tr>
    <tr>
     <td>Contact No</td>
    <c:if test="${action eq 'Add'}">
    		<td><input type="text" name="contact" pattern="[0-9]{10}" required /></td>
		</c:if>
     	<c:if test="${action eq 'view'}">
     		<td><input type="text" name="contact" value="${user.contact}" disabled="disabled" /></td>
		</c:if>
		<c:if test="${action eq 'Edit'}">
		<td><input type="text" name="contact" pattern="[0-9]{10}" required value="${user.contact}" /></td>
			</c:if>
    </tr>
   </table>
   <br/>
   <c:if test="${action eq 'Add' || 'Edit' eq action}">
   <input type="submit" value="Submit" style="background-color: #4CAF50;color: white;text-align:center;" />
   &nbsp;
   </c:if>
   <c:if test="${action eq 'view'}">
  <a href = "DopeHome.jsp" style="color:#ffffff; font-family:courier;text-align:center;">Home</a>
   &nbsp;
   </c:if>
  </form>
 </div>
</body>
</html>