<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,common.*"%>
<%@ include file="../common_session.jsp"%>
<%
	request.setCharacterEncoding("utf-8");
	NewsDao dao = new NewsDao();
	
	if(!sessionLevel.equals("top")){
%>
	<script type="text/javascript">
		alert("로그인 정보가 만료되었거나 관리자가 아닙니다.");
		location.href="news_list.jsp";
	</script>	
<%
	}else{
	String no    	= dao.getMaxNo();
	String title 	= request.getParameter("t_title");
	String content  = request.getParameter("t_content");
	String reg_id   = sessionId;
	String reg_date = CommonUtil.getTodayTime();

	NewsDto dto = new NewsDto(no,title,content,reg_id,reg_date);

	int result = dao.newsSave(dto);
	
	String msg ="등록 되었습니다.";
	if(result != 1) msg ="등록실패!";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="news_list.jsp";
</script>
</head>
<body>
</body>
</html>
<% }%>