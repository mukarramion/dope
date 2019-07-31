package net.web;

import java.io.IOException;
import java.util.*;
import java.io.*;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dao.dopeDao;
import net.model.dope;

public class DownloadServlet extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	       
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // TODO Auto-generated method stub
		      response.setContentType("text/html");  
		      PrintWriter out = response.getWriter();  
		      String filename = "list.txt";   
		      String filepath = "d:\\dope\\";   
		      response.setContentType("APPLICATION/OCTET-STREAM");   
		      response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");
		   try {
			   dope dope=new dope();
			   dopeDao d1=new dopeDao();
				List<dope> l = new ArrayList<>();
				l.addAll(d1.getDope());
				
				FileWriter writer = new FileWriter(filepath+filename); 
				for (int i=0; i<l.size(); i++){
				  writer.write(l.get(i).getFirstName()+"   "+l.get(i).getLastName()+"   "+l.get(i).getUsername()+"   "+l.get(i).getEmail()+"   "+l.get(i).getDob()+"   "+l.get(i).getContact()+ System.lineSeparator());
				}
				writer.close();
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
           
		      int i;   
		      while ((i=fileInputStream.read()) != -1) {  
		      out.write(i);   
		      }   
		      fileInputStream.close();   
		      out.close();   
		      } 

	   } 
	
