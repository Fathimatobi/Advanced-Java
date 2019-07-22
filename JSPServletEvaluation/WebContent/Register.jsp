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
	 var y=document.forms["MyForm"]["name"].value;
	 var z=document.forms["MyForm"]["age"].value;
	 var a=document.forms["MyForm"]["pass"].value;
	 if(x=="")
		 {
		 alert("ID must be Filled");
		 return false;
		 }
	 if(y=="")
		 {
		 alert("Name must be filled");
		 return false;
		 }
	 if(z=="")
	 {
		 alert("Age must be filled");
		 return false;
		 }
	 if(IsNaN(z) || z<1 || z<100)
	 {
		 alert("Age should be between 1 and 100");
		 return false;
	 }
	 if(a=="")
	 {
	 alert("Name must be filled");
	 return false;
	 }
 }
</script>
</head>
<body>
<form action="RegistrationController" method="post" name="MyForm" onsubmit="return validateForm()">
<center>
<b><font size="5">Registration Form</font></b>
<table>
<tr><td>Enter ID</td><td><input type="text" name="id"></td></tr>
<tr><td>Enter Name</td><td><input type="text" name="name"></td></tr>
<tr><td>Enter Password</td><td><input type="password" name="pass"></td></tr>
<tr><td>Age</td><td><input type="text" name="age"></td><br> 
<tr><td>Select City</td><td><select name="city">
<option value=""></option>
<option value="chennai">Chennai</option>
<option value="cochin">Cochin</option>
<option value="bangalore">Bangalore</option>
<option value="delhi">Delhi</option>
</select>
</td><br>
<tr><td></td><td align="right"><input type="submit" value="Register"></td></tr>
</table>
</form>
<% if(request.getAttribute("errorReason")!=null)
{
	%>
	<center><font color="red"><%=request.getAttribute("errorReason")%></font></center>
	<%
	}%>
</center> 
</body>
</html>
