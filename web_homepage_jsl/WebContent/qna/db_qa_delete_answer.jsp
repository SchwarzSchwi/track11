<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*" %>
<%@ include file="../common_session.jsp" %>
<%
	QnaDao dao = new QnaDao();
	if(!sessionLevel.equals("top")){
%>
		<script type ="text/javascript">
			alert("관리자화면입니다.");
			location.href="../index.jsp";
		</script>
<% 		
	}else{

	
	
	String no = request.getParameter("t_no");
	
	QnaDto dto = new QnaDto(no);

	
	int result = dao.qnaDeleteAnswer(dto);
	
	String msg ="삭제되었습니다.";
	if(result != 1) msg ="삭제 실패!";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="qa_list.jsp";
</script>
</head>
<body>

</body>
</html>
<% } %>