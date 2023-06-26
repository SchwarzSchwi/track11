<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "dto.*,dao.*,java.util.*"%>
<% 
	request.setCharacterEncoding("utf-8");
	StudentDao dao = new StudentDao();
	
	String syear = request.getParameter("t_syear");
	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");
	if(syear == null){
		syear = "all";
		select = "sno";
		search = "";
	}
	ArrayList<StudentDto> dtos = dao.getStudentList(syear,select,search);
%>
<!DOCTYPE html>
<html> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	******************************************** 
		title : 풀스텍 홍길동
	******************************************** 
 -->	
	<title>TRACK11 최선우</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script>
		function goSearch(){
			stu.method="post";
			stu.action="student_list.jsp";
			stu.submit();
		}
		function goView(syear,sclass,sno){
			view.t_syear.value =syear;
			view.t_sclass.value =sclass;
			view.t_sno.value =sno;
			view.method="post";
			view.action="student_view.jsp";
			view.submit();
		}
	</script>
</head>
<body>
<form name="view">
	<input type="hidden" name="t_syear">
	<input type="hidden" name="t_sclass">
	<input type="hidden" name="t_sno">
</form>
	<div class="container">

		<div class="leftmargin">
			<img src="../images/jsl_logo.png"><h1>TRACK11 최선우</h1>
		</div>		
		<div class="search_wrap">
			<div class="record_group">
				<p>총 : <span><%=dtos.size()%></span>&nbsp;명</p>
			</div>
			<form name="stu">
			<div class="search_group">
				<input type="radio" name="t_syear" onchange="goSearch()" value="all"<%if(syear.equals("all")) out.print("checked"); %>>전체&nbsp;&nbsp;
				<input type="radio"	name="t_syear" onchange="goSearch()" value="1"<%if(syear.equals("1")) out.print("checked");%>>1학년&nbsp;&nbsp;
				<input type="radio" name="t_syear" onchange="goSearch()" value="2"<%if(syear.equals("2")) out.print("checked");%>>2학년&nbsp;&nbsp;
				<input type="radio" name="t_syear" onchange="goSearch()" value="3"<%if(syear.equals("3")) out.print("checked");%>>3학년&nbsp;&nbsp;&nbsp;&nbsp;
				<select name="t_select" class="select">
					<option value="sno"<%if(select.equals("sno")) out.print("selected");%>>번호</option>
					<option value="name"<%if(select.equals("name")) out.print("selected");%>>성명</option>
				</select>
				<input type="text" name="t_search" value="<%=search%>" class="search_word">
				<button onclick="goSearch()" class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</div>
			</form>
		</div>
	</div>
	<div class="board_list">
		<table class="board_table">
			<colgroup>
				<col width="25%">
				<col width="25%">
				<col width="25%">
				<col width="25%">
			</colgroup>
			<thead>
				<tr>
					<th>학년</th>
					<th>반</th>
					<th>번호</th>
					<th>이름</th>
				</tr>
			</thead>
			<tbody>
			<%for(int k=0; k<dtos.size(); k++){ %>	
				<tr>
					<td><%=dtos.get(k).getSyear()%>학년</td>
					<td><%=dtos.get(k).getSclass()%>반</td>
					<td><%=dtos.get(k).getSno() %>번</td>
					<td><a href="javascript:goView('<%=dtos.get(k).getSyear()%>','<%=dtos.get(k).getSclass()%>','<%=dtos.get(k).getSno() %>')"><%=dtos.get(k).getName()%></a></td>
				</tr>	
			<%} %>
			</tbody>
		</table>
		<div class="paging">
			<a href="student_write.jsp" class="write">성적 등록</a>
		</div>
	</div>
 </body>
</html>







