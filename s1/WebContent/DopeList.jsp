<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="ISO-8859-1">
<title>DOPE</title>
<style>
table,td,tr{
padding:5px;
border:2px solid white;
border-collapse:collapse;
}
</style>

</head>
<body style="background-image:url('backG.JPG');background-repeat: no-repeat; background-size: 100% auto;">
<h1 align="center" style="color:#ffffff; font-size:300%; font-family:courier;text-align:center;"><font><strong>User list</strong></font></h1>
<br>
<br>
<br>

<table style="color:#ffffff; font-size:100%; font-family:courier;text-align:center;">
<tr>

</tr>
<tr >
<td><b>FirstName</b></td>
<td><b>LastName</b></td>
<td><b>Username</b></td>
<td><b>Email</b></td>
<td><b>Dob</b></td>
<td><b>Contact</b></td>
<td><b>Edit</b></td>
<td><b>View</b></td>
</tr>

<tr>
<c:forEach var="user1" items="${user}">
		<tr>
			<td>${user1.firstName}</td>
			<td>${user1.lastName}</td>
			<td>${user1.username}</td>
			<td>${user1.email}</td>
			<td>${user1.dob}</td>
			<td>${user1.contact}</td>		
<td><a href="${pageContext.request.contextPath}/register?id=${user1.username}&action=Edit">Edit</a></td>
<td><a href="${pageContext.request.contextPath}/register?id=${user1.username}&action=view">View</a></td>

</tr>
</c:forEach>

</table>
</body>
