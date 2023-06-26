<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,common.*" %>
<%@ include file="../common_session.jsp" %>    
<%
	request.setCharacterEncoding("utf-8");
	FaqDao dao = new FaqDao();
	
	if(!sessionLevel.equals("top")){
%>		
	<script type="text/javascript">
		alert("로그인 정보가 만료 되었거나 관리자가 아닙니다.");
		location.href="notice_list.jsp";
	</script>
<%
	}else{
		String no      = dao.getMaxNo();// N001 N002 N003
		String title   = request.getParameter("t_title");
		String content = request.getParameter("t_content");
		String reg_id  = sessionId;
//		String reg_date = CommonUtil.getToday();
		String reg_date = CommonUtil.getTodayTime();
	
	FaqDto dto = new FaqDto(no,title,content,reg_id,reg_date);
	
	int result = dao.FaqSave(dto);
	String msg ="등록 되었습니다.";
	if(result != 1) msg ="등록 실패!";
%>		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="faq_list.jsp";
</script>
</head>
<body>

</body>
</html>
<% } %>