package com.dsrc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsrc.bean.LoginBean;
import com.dsrc.bean.RegisterBean;
import com.dsrc.bo.ProfileManagementBO;
import com.dsrc.dao.ProfileManagementDAO;
import com.dsrc.exceptions.ProfileMgmtException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		String username=request.getParameter("name");
		String password=request.getParameter("pass");
		LoginBean logBean=new LoginBean();
		logBean.setName(username);
		logBean.setPass(password);

		
		ProfileManagementDAO dao=new ProfileManagementDAO(); 

		RegisterBean res = dao.validateLogin(logBean);
;			if(res.getAge()>0)
			{
				HttpSession sess=request.getSession();
				RequestDispatcher rd=request.getRequestDispatcher("ViewProfile.jsp");
				sess.setAttribute("details",res);
				rd.forward(request,response);
			}
				
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				request.setAttribute("errorReason","Login Failed");
				rd.forward(request,response);
			}
		}
		catch(CustomerException e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			request.setAttribute("errorReason",e.getMessage());
			rd.forward(request,response);
		}	
}
}
