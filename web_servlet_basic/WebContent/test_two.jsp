<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.*,java.util.*"%>
<% 
	String name = (String)request.getAttribute("t_name");
	int age		= (int)request.getAttribute("t_age");
	Tdto dto = (Tdto)request.getAttribute("t_dto");
	ArrayList<Tdto> dtos = (ArrayList<Tdto>)request.getAttribute("t_dtos");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
성명 : <%=name%> <br>
나이 : <%=age%> <br>
성명 : <%=dto.getName()%> 
지역 :<%=dto.getArea()%>
나이:<%=dto.getAge()%><br><br>

<% for(Tdto dt:dtos){ %>
		성명:<%=dt.getName()%>
		지역:<%=dto.getArea()%>
		나이:<%=dto.getAge()%>
<% }%>
</body>
</html>