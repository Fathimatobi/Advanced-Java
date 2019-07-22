package com.dsrc.controller;
import com.dsrc.bean.RegisterBean;
import com.dsrc.bo.ProfileManagementBO;
import com.dsrc.exceptions.ProfileMgmtException;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RegisterBean regBean=new RegisterBean();
		regBean.setId(Integer.parseInt(request.getParameter("id")));
		regBean.setName(request.getParameter("name"));
		regBean.setPass(request.getParameter("pass"));
		regBean.setAge(Integer.parseInt(request.getParameter("age")));
		regBean.setCity(request.getParameter("city"));
		
		ProfileManagementBO bo=new ProfileManagementBO();
		try
		{
			boolean res=bo.registerUser(regBean);
			if(res)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
				request.setAttribute("name",regBean.getName());
				rd.forward(request,response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
				request.setAttribute("errorReason","Registration Failed");
				rd.forward(request,response);
			}
		}
		catch(CustomerException | ProfileMgmtException e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
			request.setAttribute("errorReason",e.getMessage());
			rd.forward(request,response);
		}
		
		
}
}
