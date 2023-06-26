<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,common.*" %>
<%@ include file="../common_session.jsp" %>    
<%
	request.setCharacterEncoding("utf-8");
	PdsDao dao = new PdsDao();
	
	if(!sessionLevel.equals("top")){
%>
<!DOCTYPE html>
<html>
<head>		
	<script type="text/javascript">
		alert("로그인 정보가 만료 되었거나 관리자가 아닙니다.");
		location.href="pds_list.jsp";
	</script>	
<%		
	} else {
	
//	String pdsDir ="D:/track11_csw/work_project/web_homepage_jsl/WebContent/attach/pds";
	String pdsDir = CommonUtil.getFile_dir_pds();
	int maxSize = 1024 * 1024 * 10;//10메가
	
	MultipartRequest mpr = new MultipartRequest(request,pdsDir,maxSize,"utf-8",new DefaultFileRenamePolicy());
	
	String no      = dao.getMaxNo();// N001 N002 N003
	String title   = mpr.getParameter("t_title");
	String content = mpr.getParameter("t_content");
	String attach  = mpr.getFilesystemName("t_attach");
	if(attach == null) attach="";
	String reg_id  = sessionId;
//	String reg_date = CommonUtil.getToday();
	String reg_date = CommonUtil.getTodayTime();
   
	PdsDto dto = new PdsDto(no,title,content,attach,reg_id,reg_date);
	
	int result = dao.pdsSave(dto);
	String msg ="등록 되었습니다.";
	if(result != 1) msg ="등록 실패!";
%>    

<meta charset="UTF-8">
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="pds_list.jsp";
</script>
</head>
<body>
</body>
</html>
<% } %>


