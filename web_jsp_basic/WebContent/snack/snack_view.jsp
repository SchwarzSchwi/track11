<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>
<%
	String p_code = request.getParameter("t_p_code");
	request.setCharacterEncoding("utf-8");
	SnackDao dao = new SnackDao();
	SnackDto dto = dao.getSnackView(p_code);
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 최선우</title>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script type="text/javascript">
		function goUpdateForm(){
			snack.method="post";
			snack.action="snack_update.jsp";
			snack.submit();
		}
		function goDelete(){
			var tf = confirm("정말 삭제?");
			if(tf){
				snack.method="post"
				snack.action="db_snack_delete.jsp";
				snack.submit();
			}
		}
	</script>
</head>
<body>
<form name="snack">
	<input type="hidden" name="t_p_code" value="<%=p_code%>">
</form>
	<div class="container">
	
		<div class="leftmargin">
			<img src="../images/jsl_logo.png"><h1>TRACK11 최선우 SNACK</h1>
		</div>		
		<div class="write_wrap">
		
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>제품번호</th>
							<td class="th_left">
								<%=p_code%>
							</td>
						</tr>
						<tr>
							<th>제품명</th>
							<td class="th_left">
								<%=dto.getP_name()%>
							</td>
						</tr>
						<tr>
							<th>가격</th>
							<td class="th_left">
								<%=dto.getStrPrice()%>
							</td>
						</tr>
						<tr>
							<th>제조사</th>
							<td class="th_left">
								<%=dto.getM_name()%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='snack_list.jsp'" value="목록" class="btn_list">
				<input type="button" onClick="goUpdateForm()" value="수정" class="btn_list">
				<input type="button" onClick="goDelete()" value="삭제" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>



















