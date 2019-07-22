package com.dsrc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsrc.bean.RegisterBean;
import com.dsrc.bo.ProfileManagementBO;
import com.dsrc.exceptions.ProfileMgmtException;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
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
		RegisterBean regBean=new RegisterBean();
		regBean.setId(Integer.parseInt(request.getParameter("id")));
		regBean.setName(request.getParameter("name"));
		regBean.setPass(request.getParameter("pass"));
		regBean.setAge(Integer.parseInt(request.getParameter("age")));
		regBean.setCity(request.getParameter("city"));
		
		ProfileManagementBO bo=new ProfileManagementBO();
		try
		{
			boolean res=bo.editUser(regBean);	
			if(res)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
				request.setAttribute("name",regBean.getName());
				rd.forward(request,response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("EditProfile.jsp");
				request.setAttribute("errorReason","Registration Failed");
				rd.forward(request,response);
			}
		}
		catch(CustomerException | ProfileMgmtException e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("EditProfile.jsp");
			request.setAttribute("errorReason",e.getMessage());
			rd.forward(request,response);
		}
	}
}

