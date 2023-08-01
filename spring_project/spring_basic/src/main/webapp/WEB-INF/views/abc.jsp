<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String name =(String)request.getAttribute("t_name");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>abc</h1>
<h1><%=name%></h1>
<h1>${t_name}</h1>
<h1>${t_area}</h1>
</body>
</html>