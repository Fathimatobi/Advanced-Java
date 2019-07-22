<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<FORM ACTION="index.jsp" METHOD="POST">
            Enter Name
            <INPUT TYPE="TEXT" NAME="name">
            
            <INPUT TYPE="SUBMIT" value="Show">
</FORM> 
<%

if(request.getParameter("name")!=null)
	out.println(" Welcome User " + request.getParameter("name"));

%>
</body>
</html>