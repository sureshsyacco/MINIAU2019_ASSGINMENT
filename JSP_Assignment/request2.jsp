<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!static int pagec=0; %>
<H1> Login Details</H1>
<% 
String name=request.getParameter("name");
String pass=request.getParameter("password");
session.setAttribute("name", "suresh");
session.setAttribute("password","suresh123");

if(name.equals(session.getAttribute("name")))
{
	if(pass.equals(session.getAttribute("password")))
	{
		pagec++;
	%>name:<% 	out.print(request.getParameter("name"));
		%><br>password:<% out.print(request.getParameter("password"));
		out.print("Logged in times:"+pagec);
	}
}
	
%>


</body>
</html>