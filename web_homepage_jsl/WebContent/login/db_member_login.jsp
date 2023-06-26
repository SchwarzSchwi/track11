<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%
/*
HttpServletRequest request = new HttpServletRequest();
PrintWrite 			out    = new PrintWrite();
HttpSession   session = new HttpSession();
*/

	MemberDao dao = new MemberDao();

	String id = request.getParameter("t_id");
	String password = request.getParameter("t_password");

	password = dao.encryptSHA256(password);
	String name = dao.checkLogin(id, password);
	String msg="";
	String url="";
	if(name.equals("")){
		msg ="ID나 비밀번호를 확인하세요!";
		url ="member_login.jsp";
	} else {
		msg = name+"님 환영합니다!";
		url ="../index.jsp";
		
		session.setAttribute("sessionId", id);
		session.setAttribute("sessionName", name);
		
		if(id.equals("manager")){
			session.setAttribute("sessionLevel", "top");
		}else{
			session.setAttribute("sessionLevel", "member");
		}
		
		
		session.setMaxInactiveInterval(60*60);
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
//	location.href="member_login.jsp";
//	location.href="../index.jsp";
</script>
</head>
<body>
</body>
</html>





