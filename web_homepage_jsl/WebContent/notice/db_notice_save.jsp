<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,common.*" %>
<%@ include file="../common_session.jsp" %>    
<%
	request.setCharacterEncoding("utf-8");
	NoticeDao dao = new NoticeDao();
	
	if(!sessionLevel.equals("top")){
%>		
	<script type="text/javascript">
		alert("로그인 정보가 만료 되었거나 관리자가 아닙니다.");
		location.href="notice_list.jsp";
	</script>	
<%		
	} else {
	
//	String noticeDir ="D:/track11_csw/work_project/web_homepage_jsl/WebContent/attach/notice";
	String noticeDir = CommonUtil.getFile_dir_notice();
	int maxSize = 1024 * 1024 * 10;//10메가
	
	MultipartRequest mpr = new MultipartRequest(request,noticeDir,maxSize,"utf-8",new DefaultFileRenamePolicy());
	
	String no      = dao.getMaxNo();// N001 N002 N003
	String title   = mpr.getParameter("t_title");
	String content = mpr.getParameter("t_content");
	String attach  = mpr.getFilesystemName("t_attach");
	if(attach == null) attach="";
	String reg_id  = sessionId;
//	String reg_date = CommonUtil.getToday();
	String reg_date = CommonUtil.getTodayTime();
   
	NoticeDto dto = new NoticeDto(no,title,content,attach,reg_id,reg_date);
	
	int result = dao.noticeSave(dto);
	String msg ="등록 되었습니다.";
	if(result != 1) msg ="등록 실패!";
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


