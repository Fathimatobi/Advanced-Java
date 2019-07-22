package com.dsrc.controller;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsrc.bean.LoginBean;
import com.dsrc.bean.RegisterBean;
import com.dsrc.bo.ProfileManagementBO;
import com.dsrc.exceptions.ProfileMgmtException;

/**
 * Servlet implementation class ViewProfileController
 */
@WebServlet("/ViewProfileController")
public class ViewProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterBean rb=new RegisterBean();
		PrintWriter out=response.getWriter();
		int id=rb.getId();
		String name=rb.getName();
		String pass=rb.getPass();
		int age=rb.getAge();
		String city=rb.getCity();
		LoginBean logBean=new LoginBean();
		logBean.setName("name");
		logBean.setPass("pass");
		ProfileManagementBO bo=new ProfileManagementBO();
		out.println("<html><body><form><table>");
		out.println("<tr><td>Name</td><td>"+id+"</td></tr>");
		out.println("<tr><td>Age</td><td>"+name+"</td></tr>");
		out.println("<tr><td>Gender</td><td>"+pass+"</td></tr>");
		out.println("<tr><td>PhoneNumber</td><td>"+age+"</td></tr>");
		out.println("<tr><td>Email</td><td>"+city+"</td></tr>");
		out.println("</table></form></body></html>");
	}
}