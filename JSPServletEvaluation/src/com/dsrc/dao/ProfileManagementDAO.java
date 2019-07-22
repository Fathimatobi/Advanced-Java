package com.dsrc.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.dsrc.bean.ChangePasswordBean;
import com.dsrc.bean.LoginBean;
import com.dsrc.bean.RegisterBean;
import com.dsrc.controller.CustomerException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ProfileManagementDAO {
	
	public RegisterBean validateLogin(LoginBean logBean) throws CustomerException
	{
		RegisterBean rb=new RegisterBean();
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection com=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tobi","root","dsrc");
		PreparedStatement ps=(PreparedStatement) com.prepareStatement("select * from Customer where name=? and pass=?");
		ps.setString(1,logBean.getName());
		ps.setString(2,logBean.getPass());
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			rb.setId(rs.getInt(1));
			rb.setName(rs.getString(2));
			rb.setPass(rs.getString(3));
			rb.setAge(rs.getInt(4));
			rb.setCity(rs.getString(5));
		}
		}
	catch(Exception ex)
	{
		throw new CustomerException("Invalid Login");
	}
	return rb;
	}
		
		
	public boolean registerUser(RegisterBean regBean) throws CustomerException
	{
		Boolean result=false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection com=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tobi","root","dsrc");
			PreparedStatement ps=(PreparedStatement) com.prepareStatement("insert into Customer values(?,?,?,?,?)");
				ps.setInt(1,regBean.getId());
				ps.setString(2,regBean.getName());
				ps.setString(3,regBean.getPass());
				ps.setInt(4,regBean.getAge());
				ps.setString(5,regBean.getCity());
				int res=ps.executeUpdate();
				if(res>0)
				{
					result=true;
				}}
		catch(Exception ex)
		{
			throw new CustomerException("Customer ID Existing");
		}
		return result;
		}
	
	
	public RegisterBean viewProfile(LoginBean logBean) throws CustomerException
	{
		return null;
	}

	
	public boolean editUser(RegisterBean regBean) throws CustomerException
	{
		Boolean result=false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection com=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tobi","root","dsrc");
			PreparedStatement ps=(PreparedStatement) com.prepareStatement("update Customer set name=?,pass=?,age=?,city=? where id=?");
				ps.setString(1,regBean.getName());
				ps.setString(2,regBean.getPass());
				ps.setInt(3,regBean.getAge());
				ps.setString(4,regBean.getCity());
				ps.setInt(5,regBean.getId());
				int res=ps.executeUpdate();
				if(res>0)
				{
					result=true;
				}}
		catch(Exception ex)
		{
			throw new CustomerException("Customer ID Existing");
		}
		return result;
		}
	
	
	public boolean changePassword(ChangePasswordBean cBean) throws CustomerException
	{
		
		Boolean result=false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection com=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tobi","root","dsrc");
			PreparedStatement ps=(PreparedStatement) com.prepareStatement("update Customer set pass=? where id=? and pass=?");
			ps.setString(1,cBean.getconfirmpass());
			ps.setInt(2,cBean.getId());
			ps.setString(3,cBean.getPass());
			int res=ps.executeUpdate();
			if(res>0)
			{
				result=true;
			}
		}
		catch(Exception ex)
		{
			throw new CustomerException("Incorrect Password");
		}
		return result;
		}	
	}
	

