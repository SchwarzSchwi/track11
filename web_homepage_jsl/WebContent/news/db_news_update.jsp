<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,common.*"%>
<%
	request.setCharacterEncoding("utf-8");
	NewsDao dao     = new NewsDao();
	String no       = request.getParameter("t_no");
	String title    = request.getParameter("t_title");
	String content  = request.getParameter("t_content");
	String update_date = CommonUtil.getTodayTime();
	
	NewsDto dto = new NewsDto(no,title,content,update_date);
	int result  = dao.newsUpdate(dto);
	String msg  = "수정되었습니다.";
	if(result != 1) msg = "수정실패!";
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