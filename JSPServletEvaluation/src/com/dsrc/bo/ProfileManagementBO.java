package com.dsrc.bo;

import com.dsrc.bean.ChangePasswordBean;
import com.dsrc.bean.LoginBean;
import com.dsrc.bean.RegisterBean;
import com.dsrc.controller.CustomerException;
import com.dsrc.dao.ProfileManagementDAO;
import com.dsrc.exceptions.ProfileMgmtException;

public class ProfileManagementBO 
{
	public RegisterBean validateLogin(LoginBean logBean) throws ProfileMgmtException, CustomerException
	{
		if(logBean.getName()==null && logBean.getPass()==null){
			throw new ProfileMgmtException("Invalid Login");	
		}
	return new ProfileManagementDAO().validateLogin(logBean);
     }
	
	
	public boolean registerUser(RegisterBean regBean) throws CustomerException,ProfileMgmtException
	{
		if(regBean.getAge()<18)
			throw new ProfileMgmtException("Invalid Age");
			return new ProfileManagementDAO().registerUser(regBean);
	}
	
	
	public RegisterBean viewProfile(LoginBean logBean) throws CustomerException,ProfileMgmtException
	{
		
		return  null;
		}
	
	
	public boolean editUser(RegisterBean regBean) throws ProfileMgmtException, CustomerException
	{

			return new ProfileManagementDAO().editUser(regBean);
	}
	
	
	public boolean changePassword(ChangePasswordBean cBean) throws CustomerException,ProfileMgmtException
	{
		return new ProfileManagementDAO().changePassword(cBean);
	}
}
