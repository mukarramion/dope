@@ -0,0 +1,66 @@
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "mysql_database";
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
<h2 align="center"><font><strong>User list</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1" style="color:#ffffff; font-size:170%; font-family:courier;text-align:center;">>
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
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM dope_acc";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>

<td><%=resultSet.getString("firstName") %></td>
<td><%=resultSet.getString("lastName") %></td>
<td><%=resultSet.getString("username") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("password") %></td>
<td><%=resultSet.getString("dob") %></td>
<td><%=resultSet.getString("contact") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
