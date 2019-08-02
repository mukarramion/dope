package net.web;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import net.dao.dopeDao;
import net.model.dope;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class DownloadServlet2 extends HttpServlet {

    private static final String File_Name = "D:\\dope\\list.pdf";
    private static final String filepath = "D:\\dope\\";
    private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		      String filename = "list.pdf";   
		   File file= new File(filepath+filename);
		   response.setContentType("application/pdf");
		    response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");
			   response.setContentLength((int)file.length());

		   try {
			writeUsingIText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   ServletOutputStream servletOutputStream=response.getOutputStream();
		   BufferedInputStream bufferedInputStream= new BufferedInputStream(new FileInputStream(file));
		   int bytesRead =bufferedInputStream.read();
		   while(bytesRead !=-1)
		   {
			   servletOutputStream.write(bytesRead);
			   bytesRead =bufferedInputStream.read();
		   }
		   
		   if(servletOutputStream!=null)servletOutputStream.close();
		   if(bufferedInputStream!=null)bufferedInputStream.close();

	   
   }

    private static void writeUsingIText() throws Exception {

        Document document = new Document();

        try {

            PdfWriter.getInstance(document, new FileOutputStream(new File(File_Name)));

            //open
            document.open();
            dope dope=new dope();
			   dopeDao d1=new dopeDao();
				List<dope> l = new ArrayList<>();
				l.addAll(d1.getDope());
            Paragraph p = new Paragraph();
            for (int i=0; i<l.size(); i++){
            p.add(l.get(i).getFirstName()+"   "+l.get(i).getLastName()+"   "+l.get(i).getUsername()+"   "+l.get(i).getEmail()+"   "+l.get(i).getDob()+"   "+l.get(i).getContact()+"\n");
            }
            p.setAlignment(Element.ALIGN_CENTER);

            document.add(p);

            //close
            document.close();

            System.out.println("Done");
         
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
	
