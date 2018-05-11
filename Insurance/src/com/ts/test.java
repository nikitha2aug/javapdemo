package com.ts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
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
		
	    PrintWriter out=response.getWriter();
	   
	   
	   
	   String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		String role=new insuranceDAO().isUser(uid,pwd);
		if(role=="")
		{
			out.print("sorry user or password Error!!!");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.include(request,response);
		{
			if(role.equals("user"))
			{
				response.sendRedirect("Mainmenu_user.jsp");
				
			}else if(role.equals("admin"))
			{
				response.sendRedirect("Mainmenu_admin.jsp");
			}
		}
		
		
		
		
		
		
	}

	}

}
