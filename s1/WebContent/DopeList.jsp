
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String username = request.getParameter("username");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/mysql_database";
String userId = "mukarram";
String password = "mysql1234";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
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
<script>
onview(name){
	
	
}
</script>
</head>
<body style="background-image:url('backG.JPG');background-repeat: no-repeat; background-size: 100% auto;">
<h1 align="center" style="color:#ffffff; font-size:300%; font-family:courier;text-align:center;"><font><strong>User list</strong></font></h1>
<br>
<br>
<br>

<table align="center" style="color:#ffffff; font-size:100%; font-family:courier;text-align:center;">
<tr>

</tr>
<tr >
<td><b>FirstName</b></td>
<td><b>LastName</b></td>
<td><b>Username</b></td>
<td><b>Email</b></td>
<td><b>Password</b></td>
<td><b>Dob</b></td>
<td><b>Contact</b></td>
<td><b>Edit</b></td>
<td><b>View</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM dope_acc";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>

<td><%=resultSet.getString("first_name") %></td>
<td><%=resultSet.getString("last_name") %></td>
<td><%=resultSet.getString("username") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("password") %></td>
<td><%=resultSet.getString("dob") %></td>
<td><%=resultSet.getString("contact") %></td>
<td><a href="${pageContext.request.contextPath}/register?id=<%=resultSet.getString("username") %>&action=Edit">Edit</a></td>
<td><a href="${pageContext.request.contextPath}/register?id=<%=resultSet.getString("username") %>&action=view">View</a></td>

</tr>

<% 
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</form>
</body>
