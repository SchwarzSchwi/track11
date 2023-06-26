<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %> 
<%
	StudentDao dao = new StudentDao();
	String syear = request.getParameter("t_syear");
	String sclass = request.getParameter("t_sclass");
	String sno = request.getParameter("t_sno");
	
	int result = dao.studentDelete(syear,sclass,sno);
	String msg = result == 1 ? "삭제성공!":"삭제실패";
%>	   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	alert("<%=msg%>");
<% if(result == 1) {%>	
	location.href="student_list.jsp";
<% } else {%>
	window.history.back();
<% } %>	
</script>	
</head>
<body>

</body>
</html>