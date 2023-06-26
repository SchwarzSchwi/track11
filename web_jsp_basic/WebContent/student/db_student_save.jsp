<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>
<%
	request.setCharacterEncoding("utf-8");
	StudentDao dao = new StudentDao();
	
	String syear  = request.getParameter("t_syear");
	String sclass = request.getParameter("t_sclass");
	String sno 	  = request.getParameter("t_sno");
	String name   = request.getParameter("t_name");
	String kor    = request.getParameter("t_kor");
	String eng    = request.getParameter("t_eng");
	String mat    = request.getParameter("t_mat");
	
	int total  = dao.getTotal(kor, eng, mat);
	double ave = dao.getAve(total,3);
	
	int count = dao.getCheck(syear,sclass,sno);
	int result = 0;
	String msg = "등록성공!";
	
	if(count ==0){
		StudentDto dto = new StudentDto(syear,sclass,sno,name,Integer.parseInt(kor),Integer.parseInt(eng),Integer.parseInt(mat),total,ave);
		result = dao.studentSave(dto);
		
		if(result != 1) msg = "등록실패!";
	}else{
		msg = "학년, 반, 번호가 이미 존재합니다";
	}	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
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