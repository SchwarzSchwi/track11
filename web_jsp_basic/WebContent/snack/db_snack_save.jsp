<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>    
<%
	request.setCharacterEncoding("utf-8");
	SnackDao dao = new SnackDao();
	
	String p_code = request.getParameter("t_p_code");
	String p_name = request.getParameter("t_p_name");
	String price = request.getParameter("t_price");
	String m_code = request.getParameter("t_m_code");
	
	int result = 0;
	String msg = "등록성공!";  
	int checkCount = dao.checkPcode(p_code);
	
	if(checkCount == 0){
		SnackDto dto = new SnackDto(p_code,p_name,Integer.parseInt(price),m_code);
		
		result = dao.snackSave(dto);
		if(result != 1) msg ="등록실패~";
	}else{
		msg="중복된 제품코드!";
	}
	

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	alert("<%=msg%>");
	
	<% if(result==1){%>
		location.href="snack_list.jsp";
	<% } else {%>
//		location.href="snack_write.jsp";
		window.history.back();
	<% }%>
</script>
</head>
<body>

</body>
</html>