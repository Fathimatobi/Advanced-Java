<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.dsrc.bean.RegisterBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<body>
</head>
<body>
<%! RegisterBean rb; %>
<%
	rb=(RegisterBean)session.getAttribute("details");
%>

<form action="ViewProfileController" method="post">
<center>
<b><font size="5">View Profile</font></b>
<table>
<tr><td>ID</td><td><%= rb.getId() %></td></tr>
<tr><td>Name</td><td><%=rb.getName() %></td></tr>
<tr><td>Pass</td><td><%=rb.getPass() %></td></tr>
<tr><td>Age</td><td><%=rb.getAge() %></td></tr>
<tr><td>City</td><td><%=rb.getCity() %></td></tr>

</table></center></form>
<a href="EditProfile.jsp">Edit your Profile</a>

<% if(request.getAttribute("errorReason")!=null)
{
	%>
	<center><font color="red"><%=request.getAttribute("errorReason")%></font></center>
	<%
	}%>
</body>
</html>