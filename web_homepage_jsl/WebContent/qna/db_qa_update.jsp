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
	String title = request.getParameter("t_title");
	String content = request.getParameter("t_content");
	String reg_id = sessionId;
	String reg_date = CommonUtil.getTodayTime();
	
	
	
	QnaDto dto = new QnaDto(no,title,content,reg_id,reg_date);
	int result  = dao.qnaUpdate(dto);
	
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