package net.web;

import java.io.IOException;
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
		   createfile();
	      response.setContentType("text/html");  
	      PrintWriter out = response.getWriter();  
	      String filename = "list.txt";   
	      String filepath = "d:\\dope\\";   
	      response.setContentType("APPLICATION/OCTET-STREAM");   
	      
	      //use inline if you want to view the content in browser, helpful for pdf file
	      response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");
	      FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
	                  
	      int i;   
	      while ((i=fileInputStream.read()) != -1) {  
	      out.write(i);   
	      }   
	      fileInputStream.close();   
	      out.close();   
	      }

	private void createfile() {
		// TODO Auto-generated method stub
		
	}  
	}
