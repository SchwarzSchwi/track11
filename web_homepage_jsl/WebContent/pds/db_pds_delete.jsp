<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,java.io.*,common.*" %>
<%@ include file="../common_session.jsp" %>
<%
	if(!sessionLevel.equals("top")){
%>
		<script type ="text/javascript">
			alert("관리자화면입니다.");
			location.href="../index.jsp";
		</script>
<% 		
	}else{
	request.setCharacterEncoding("utf-8");
	NoticeDao dao = new NoticeDao();
	String no = request.getParameter("t_no");
	String attach = request.getParameter("t_attach");
	
	int result = dao.noticeDelete(no);
	
	if(result == 1){
		if(!attach.equals("")){
			File file = new File(CommonUtil.getFile_dir_notice(),attach);
			boolean tf = file.delete();
			if(!tf) System.out.print("공지사항 게시글 삭제 첨부파일 삭제 오류!");
		}
	}
	
	String msg ="삭제되었습니다.";
	if(result != 1) msg ="삭제 실패!";
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
<% } %>