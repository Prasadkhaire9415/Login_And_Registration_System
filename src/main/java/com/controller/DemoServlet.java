package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.StoreDao;

import bean.Login;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DemoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String mob=request.getParameter("mob");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String Add=request.getParameter("add");
		
		PrintWriter pw=response.getWriter();
	   Login l=new Login();
	   l.setName(name);
	   l.setMobile(mob);
	   l.setEmail(email);
	   l.setAddress(Add);
	   l.setPassword(password);
	   
	   int status =StoreDao.insert(l);
	   if(status!=0) {
		   pw.println("<h1>Data saved successfully..</h1>");
		   response.sendRedirect("login.html");
	   }
	}

}
