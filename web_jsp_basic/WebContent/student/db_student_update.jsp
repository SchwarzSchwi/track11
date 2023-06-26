<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>
<%
	request.setCharacterEncoding("utf-8");
	StudentDao dao = new StudentDao();
	
	String syear  = request.getParameter("t_syear");
	String sclass = request.getParameter("t_sclass");
	String sno    = request.getParameter("t_sno");
	String name   = request.getParameter("t_name");
/*	String kor    = request.getParameter("t_kor");
	String eng    = request.getParameter("t_eng");
	String mat    = request.getParameter("t_mat");
	String total  = request.getParameter("t_total");
	String ave    = request.getParameter("t_ave");
*/	
	int kor    = Integer.parseInt(request.getParameter("t_kor"));
	int eng    = Integer.parseInt(request.getParameter("t_eng"));
	int mat    = Integer.parseInt(request.getParameter("t_mat"));
	int total  = Integer.parseInt(request.getParameter("t_total"));
	double ave = Double.parseDouble(request.getParameter("t_ave"));
	
	StudentDto dto = new StudentDto(syear,sclass,sno,name,kor,eng,mat,total,ave);
	int result = dao.studentUpdate(dto);
	
	String msg = result == 1 ?"수정성공!":"수정실패~";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<form name="stu">
	<input type="hidden" name="t_syear" value="<%=syear%>">
	<input type="hidden" name="t_sclass" value="<%=sclass%>">
	<input type="hidden" name="t_sno" value="<%=sno%>">	
</form>
<script type="text/javascript">
	alert("<%=msg%>");
	stu.method="post";
	stu.action="student_view.jsp";
	stu.submit()
	
//	location.href="student_list.jsp"
</script>
</body>
</html>