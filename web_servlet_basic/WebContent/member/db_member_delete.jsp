<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*"  %>    
<%
	request.setCharacterEncoding("utf-8");
	MemberDao dao = new MemberDao();
	String id = request.getParameter("t_id");
	int result = dao.memberDelete(id);
	String msg="삭제성공!";
	if(result != 1) msg = "삭제실패~";
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="member_list.jsp"
</script>
</head>
<body>

</body>
</html>