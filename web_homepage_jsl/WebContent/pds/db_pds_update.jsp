<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,common.*,java.io.*" %>
<%
	request.setCharacterEncoding("utf-8");
	NoticeDao dao     = new NoticeDao();
	
	String noticeDir = CommonUtil.getFile_dir_notice();
	int maxSize = 1024 * 1024 * 10;
	
	MultipartRequest mpr = new MultipartRequest(request, noticeDir, maxSize,"utf-8", new DefaultFileRenamePolicy());
	
	String no         = mpr.getParameter("t_no");
	String title      = mpr.getParameter("t_title");
	String content	  =	mpr.getParameter("t_content");
	String attach     = mpr.getFilesystemName("t_attach");
	if(attach == null) attach = "";
//체크박스 체크했을 때 값 deleteAttachs	
	String deleteAttach = mpr.getParameter("t_deleteFile");
	String oriAttach = mpr.getParameter("t_ori_attach");
	String saveAttachName = "";
	if(deleteAttach != null){
//폴더경로, 파일명		
		File file = new File(noticeDir,deleteAttach);
		boolean tf = file.delete();
		if(!tf){
			System.out.print("공지사항 첨부파일 삭제 실패:"+tf);
		}
	}else{
		saveAttachName = oriAttach;
	}
//새로운 첨부파일 등록하면
	if(!attach.equals("")){
		if(oriAttach != null){
			File file = new File(noticeDir,oriAttach);
			boolean tf = file.delete();
		}
		saveAttachName = attach;
	}

	NoticeDto dto = new NoticeDto(no,title,content,saveAttachName);
	int result = dao.noticeUpdate(dto);
//	int result = 0;
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