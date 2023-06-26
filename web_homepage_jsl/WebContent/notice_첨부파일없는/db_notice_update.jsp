<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>
<%
	request.setCharacterEncoding("utf-8");
	NoticeDao dao     = new NoticeDao();
	String no         = request.getParameter("t_no");
	String title      = request.getParameter("t_title");
	String content	  =	request.getParameter("t_content");
	
	NoticeDto dto = new NoticeDto(no,title,content);
	int result = dao.noticeUpdate(dto);
	String msg = "수정되었습니다.";
	if(result != 1) msg = "수정실패!";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="notice_list.jsp";
</script>
</head>
<body>

</body>
</html>