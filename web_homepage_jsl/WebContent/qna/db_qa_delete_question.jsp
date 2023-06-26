<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ include file="../common_session.jsp" %>
<%
	if(!sessionLevel.equals("member")){
%>
		<script type ="text/javascript">
			alert("작성자만 지울 수 있습니다.");
			location.href="../index.jsp";
		</script>
<% 		
	}else{

	QnaDao dao = new QnaDao();
	String no = request.getParameter("t_no");
	
	int result = dao.qnaDelete(no);
	
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