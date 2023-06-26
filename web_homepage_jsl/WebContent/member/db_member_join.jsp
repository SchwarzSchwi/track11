<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,common.CommonUtil" %>
<%
	request.setCharacterEncoding("utf-8");
	MemberDao dao = new MemberDao();
	String id        = request.getParameter("t_id");
	String name      = request.getParameter("t_name");
	String password  = request.getParameter("t_pw_1");	
	password 		 = dao.encryptSHA256(password); // 암호화
	String job       = request.getParameter("t_job");
	String tell_1    = request.getParameter("t_tell_1");
	String tell_2    = request.getParameter("t_tell_2");
	String tell_3    = request.getParameter("t_tell_3");
	String mobile_1  = request.getParameter("t_mobile_1");
	String mobile_2  = request.getParameter("t_mobile_2");
	String mobile_3  = request.getParameter("t_mobile_3");
	String mobile    = mobile_1+mobile_2+mobile_3;
	String email     = request.getParameter("t_email");
	String reg_date = CommonUtil.getToday();
	
	MemberDto dto = new MemberDto(id,name,password,job,
			                      tell_1,tell_2,tell_3,
			                      mobile,email,reg_date); 
	int result = dao.memberJoin(dto);
	
	String msg = name +"님 환영합니다.";
	if(result != 1) msg ="회원가입 실패! 관리자에게 문의 바랍니다.";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="../index.jsp";
</script>

</head>
<body>
</body>
</html>


