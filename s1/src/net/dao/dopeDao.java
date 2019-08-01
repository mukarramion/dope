package net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.model.dope;

public class dopeDao {
	public int registerDOPE(dope dope) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO dope_acc (first_name, last_name, username,email , password,dob, contact) VALUES (?,?, ?, ?, ?,?,?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/mysql_database", "mukarram", "mysql1234");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, dope.getFirstName());
            preparedStatement.setString(2, dope.getLastName());
            preparedStatement.setString(3, dope.getUsername());
            preparedStatement.setString(4, dope.getEmail());
            preparedStatement.setString(5, dope.getPassword());
            preparedStatement.setString(6, dope.getDob());
            preparedStatement.setString(7, dope.getContact());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

	
    public void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
   
    public dope getByName(String name) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "select first_name,last_name,username,email,dob,contact from dope_acc where username=?";
        

        Class.forName("com.mysql.cj.jdbc.Driver");
        dope dope = new dope();
        ResultSet result;
		try { 
        	Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/mysql_database", "mukarram", "mysql1234");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, name);
        	result = preparedStatement.executeQuery();
        	
        	while (result.next()) {
				dope.setFirstName(result.getString("first_name"));
				dope.setLastName(result.getString("last_name"));
				dope.setUsername(result.getString("username"));
				dope.setEmail(result.getString("email"));
				
				dope.setDob(result.getString("dob"));
				dope.setContact(result.getString("contact"));
			}
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }

        return  dope;


}
    public List<dope> getDope() throws ClassNotFoundException {
        String INSERT_USERS_SQL = "SELECT first_name,last_name,username,email,dob,contact FROM dope_acc;";

        
        List<dope> list = new ArrayList<dope>();
        Class.forName("com.mysql.cj.jdbc.Driver");

      
		ResultSet result;
		try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/mysql_database", "mukarram", "mysql1234");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeQuery();
            while(result.next()){
            	dope dope = new dope();
            	//TODO: set the value
            	dope.setFirstName(result.getString("first_name"));
				dope.setLastName(result.getString("last_name"));
				dope.setUsername(result.getString("username"));
				dope.setEmail(result.getString("email"));
				dope.setDob(result.getString("dob"));
				dope.setContact(result.getString("contact"));
            	list.add(dope);
            }
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return list;
    }
    
    public boolean updateUser(dope dope) throws SQLException {
        boolean rowUpdated;
        System.out.println(dope.toString());
        
        final String UPDATE_USERS_SQL = "update dope_acc set first_name=?, last_name=?, dob=? , contact=? where username = ?;";
        
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/mysql_database", "mukarram", "mysql1234");
        		
        PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, dope.getFirstName());
            statement.setString(2, dope.getLastName());
            statement.setString(3, dope.getDob());
            statement.setString(4, dope.getContact());
            statement.setString(5, dope.getUsername());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    


	
}
