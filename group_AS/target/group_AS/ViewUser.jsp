<%@page import="model.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<table align="center" border=1>
<tr><th>Employee ID</th> <th>First Name</th> <th>Last Name </th> <th>Date of Joining </th> <th>Department</th> </tr>
<%
List<Users> plist =(List<Users>) request.getAttribute("plist");
for( Users p:plist) 
{
	String url="UserRemove?eid="+p.getEid();
%>
<tr>
  <td><%=p.getEid()%> </td><br>
  <td><%=p.getFname() %></td>
  <td><%=p.getLname() %></td>
  <td><%=p.getDoj() %></td>
  <td><%=p.getDept() %>  </td>
  <td><a href="<%=url%>">Remove</a> </td>
</tr>
<%
}
%>



</table>
</body>
</html>