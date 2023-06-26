<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="dao.*"%> 
<%
	SnackDao dao = new SnackDao();
	String p_code = request.getParameter("t_p_code");
	int result = dao.snackDelete(p_code);
	
// String msg = "삭제성공!";
// if(result != 1) msg ="삭제실패";
	String msg = result == 1 ? "삭제성공!" : "삭제실패";
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="snack_list.jsp";
</script>
</head>
<body>

</body>
</html>