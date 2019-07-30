package net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            preparedStatement.setString(6, dope.getDOB());
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
    
    public List<dope> getDope() throws ClassNotFoundException {
        String INSERT_USERS_SQL = "SELECT * FROM dope_acc;";

        
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
				dope.setDOB(result.getString("dob"));
				dope.setContact(result.getString("contact"));
            	list.add(dope);
            }
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return list;
    }
}
