package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.StoreDao;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		int status=StoreDao.search(username);
		int status1=StoreDao.searchpass(username, password);
		System.out.println(status);
		System.out.println(status1);
		if(status!=0 && status1!=0) {
			pw.println("<h1>Login Successfully..</h1>");
			pw.println("<h1>Welcome To The Application..</h1>");
		}else if(status!=0 && status1==0) {
			pw.println("<p>Incorrect password!</p>");
			response.sendRedirect("login.html");
		}else if(status==0 && status1!=0) {
			pw.println("<p>Invalid username!</p>");
			response.sendRedirect("login.html");
		}else if(status==0 && status1==0){
			pw.println("<p>Invalid username and incorrect password..!</p>");
			response.sendRedirect("login.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
