<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
 function validateForm()
 {
	  var x=document.forms["MyForm"]["name"].value;
	 var y=document.forms["MyForm"]["pass"].value;
	 if(x=="")
	 {
	 alert("Name must be Filled");
	 return false;
	 }
 if(y=="")
	 { 
	 alert("Password must be filled");
	 return false;
	 }
 }
 </script>
</head>
<body>
<form action="LoginController" method="post" name="MyForm" onsubmit="return validateForm()">
<center>
<b><font size="5">Login Details</font></b>
<table>
<tr><td>Enter Name</td><td><input type="text" name="name"></td></tr>
<tr><td>Enter Password</td><td><input type="Password" name="pass"></td></tr>
<tr><td></td><td><input type="submit" value="Login"></td></tr>
</tr>
</table>
</form>
<a href="ChangePassword.jsp">ChangePassword</a>
<% if(request.getAttribute("errorReason")!=null)
{
	%>
	<center><font color="red"><%=request.getAttribute("errorReason")%></font></center>
	<%
	}%>
</center>

</body>
</html>