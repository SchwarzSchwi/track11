<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,common.*"%>
<%@ include file="../common_session.jsp"%>

<!DOCTYPE html>
<html>
<%
	request.setCharacterEncoding("utf-8");
	QnaDao dao = new QnaDao();

	
	if(sessionLevel.equals("")){
%>
	<script type="text/javascript">
		alert("로그인 정보가 만료되었습니다.");
		location.href="qa_list.jsp";
	</script>
<% 
	}else{
	String no = request.getParameter("t_no");
	String qna_date = CommonUtil.getTodayTime();
	String answer = request.getParameter("t_answer");
	
	
	QnaDto dto = new QnaDto(no,qna_date,answer);
	int result  = dao.qnaUpdateReply(dto);
	
	String msg ="등록되었습니다";
	if(result != 1)msg="등록실패";
		
	
%>	
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="qa_list.jsp"
</script>
</head>
<body>

</body>
</html>
<%  }  %>