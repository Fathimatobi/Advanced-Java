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
	  var x=document.forms["MyForm"]["id"].value;
	 var y=document.forms["MyForm"]["pass"].value;
	 if(x=="")
	 {
	 alert("ID must be Filled");
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
<form action="ChangePasswordController" method="post" name="MyForm" onsubmit="return validateForm()">
<center>
<form><b><font size="5">Change Password</font></b></form>
<table>
<tr><td>Enter ID</td><td><input type="text" name="id"></td><br>
<tr><td>Enter old Password</td><td><input type="password" name="pass"></td><br>
<tr><td>Enter New Password</td><td><input type="password" name="newpass"></td><br>
<tr><td>Enter confirm Password</td><td><input type="password" name="confirmpass"></td><br>
<tr><td></td><td align="right"><input type="submit" name="login" value="Login"></td></tr>
</table>
<% if(request.getAttribute("errorReason")!=null)
{
	%>
	<center><font color="red"><%=request.getAttribute("errorReason")%></font></center>
	<%
	}%>
	</form>
</center>
</body>
</html>