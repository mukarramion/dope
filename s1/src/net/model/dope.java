package net.model;
import java.io.Serializable;
public class dope implements Serializable{
	 public static final long serialVersionUID = 1L ;
	   public String firstName;
	    public String lastName;
	    public String username;
	    public String password;
	    public String email;
	    public String dob;
	    public String contact;
	    public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    public String getLastName() {
	        return lastName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    public String getUsername() {
	        return username;
	    }
	    public void setUsername(String username) {
	        this.username = username;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	
	    public String getDOB() {
	        return dob;
	    }
	    public void setDOB(String dob) {
	        this.dob = dob;
	    }
	    public String getContact() {
	        return contact;
	    }
	    public void setContact(String contact) {
	        this.contact = contact;
	    }

}
