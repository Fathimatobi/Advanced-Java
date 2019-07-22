package com.dsrc.controller;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dsrc.bean.ChangePasswordBean;
import com.dsrc.bo.ProfileManagementBO;
import com.dsrc.exceptions.ProfileMgmtException;

/**
 * Servlet implementation class ChangePasswordController
 */
@WebServlet("/ChangePasswordController")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordController() {
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
		ChangePasswordBean cBean=new ChangePasswordBean();
		cBean.setId(Integer.parseInt(request.getParameter("id")));
		cBean.setPass(request.getParameter("pass"));
		cBean.setNewpass(request.getParameter("newpass"));
		cBean.setConfirmpass(request.getParameter("confirmpass"));
		ProfileManagementBO bo=new ProfileManagementBO();
		try
		{
			boolean res=bo.changePassword(cBean);
			if(res)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				
				rd.forward(request,response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
				request.setAttribute("errorReason","Password Failed");
				rd.forward(request,response);
			}
		}
		catch(CustomerException | ProfileMgmtException e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
			request.setAttribute("errorReason","Password Failed");
			rd.forward(request,response);
		}
	}
}
