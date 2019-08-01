<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
a{
background-color:#4CAF50 ;
color:white;
padding: 14px 25px;
text-align: center;
text-decoration:  none;
display: inline-block;
border-radius:6px;
}
input
{  padding:8px;
      box-sizing:border-box;
  border: none;
  border-radius: 4px;
}
</style>
<meta charset="ISO-8859-1">
<title>Dope</title>
</head>
<body style="background-image:url('backG.JPG');background-repeat: no-repeat; background-size: 100% auto;">
<div align="center">
  <h1 style="color:#ffffff;font-size:450%; font-family:courier;text-align:center;">DOPE</h1>
 </div> 
 <div align="center">
 <form action="/search">  
<input type="text" name="Username"/ placeholder="Username">
<input type="submit" value="search" style="background-color: #4CAF50;color: white;text-align:center;"/>
 </div> 
  <br>
  <div align="center">
<table  style="color:#ffffff; font-size:150%; font-family:courier;text-align:center;" cellpadding="10" cellspacing="10">
<tr> <td><a href = "<%= request.getContextPath() %>/register?action=Add" >Registration</a> </td> </tr>
    
    <tr> 
    <td><a href = "<%= request.getContextPath() %>/register?action=List" >User-List</a> </td> </tr>
    
</table>
</div>
</body>
</html>
