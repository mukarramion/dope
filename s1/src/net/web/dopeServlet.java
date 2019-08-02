package net.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dao.dopeDao;
import net.model.dope;

public class dopeServlet extends HttpServlet {
	public static final long serialVersionUID = 1L;
	public dopeDao dopeDao;

	public void init() {
		dopeDao = new dopeDao();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doPost-------->");
		String action = request.getParameter("actionvalue");

		if(action != null && ("search".equalsIgnoreCase(action)) ) {
			String username = request.getParameter("Username");
			System.out.println("---->"+username);
			dope d;
			try {
				List<dope> list = new ArrayList<dope>();
				d = dopeDao.getByName(username);
				if(null!=d) {
					list.add(d);
					request.setAttribute("user", list);
				}else {
					request.setAttribute("user",dopeDao.getDope());
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/DopeList.jsp").forward(request, response);
		}else {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String dob = request.getParameter("dob");
			String contact = request.getParameter("contact");

			dope d = new dope();
			d.setFirstName(firstName);
			d.setLastName(lastName);
			d.setUsername(username);
			d.setPassword(password);
			d.setContact(contact);
			d.setEmail(email);
			d.setDob(dob);

			try {
				System.out.println("action-------->"+action);
				if(action != null && ("Edit".equalsIgnoreCase(action)) ) {
					username = request.getParameter("usernamevalue");
					d.setUsername(username);
					dopeDao.updateUser(d);
				}
				else if(action != null && ("Add".equalsIgnoreCase(action)) ) {
					dopeDao.registerDOPE(d);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.sendRedirect("dopedetails.jsp");
		}
	}




	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println("-doGet--->"+action);
		if(action != null && ("Edit".equalsIgnoreCase(action) || "View".equalsIgnoreCase(action)) ) {
			String username = request.getParameter("id");
			System.out.println("---->"+username);
			//TODO: Let the username base data

			dope d;
			try {
				d = dopeDao.getByName(username);
				request.setAttribute("user", d);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			request.setAttribute("action", action);
			getServletContext().getRequestDispatcher("/DopeRegister.jsp").forward(request, response);
		}




		else if(action != null && ("List".equalsIgnoreCase(action)) ) {
			//TODO: Set data from db
			try {
				request.setAttribute("user",dopeDao.getDope());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			getServletContext().getRequestDispatcher("/DopeList.jsp").forward(request, response);
		}else {
			request.setAttribute("action", action);
			getServletContext().getRequestDispatcher("/DopeRegister.jsp").forward(request, response);
		}
	}





}
