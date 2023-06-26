<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*"%>
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
	
	NoticeDao dao = new NoticeDao();
	String no = request.getParameter("t_no");
	
	NoticeDto dto = dao.getNoticeView(no);
%>
<%@ include file="../common_header.jsp"%>
<script>
	function goUpdate(){
		if(checkValue(notice.t_title,"제목입력!")) return;
		if(checkValue(notice.t_content,"내용입력!")) return;
		
		
		/***  첨부파일 검사 ***/
		// 1.확장자 검사
		var fileName = notice.t_attach.value;
		if(fileName != ""){ //  C:\fakepath\img_1.png
			var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
			var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
			//파일명.확장자
//			if(extension != "jpg" && extension != "gif" && extension != "png"){
			if(extension != "pdf" && extension != "hwp" && extension != "png"){
				alert(extension +" 형식 파일은 업로드 안됩니다. 한글, PDF 파일만 가능!");
				return;
			}		
		}
		
		// 2.첨부 용량 체크	
		var file = notice.t_attach;
		var fileMaxSize  = 5; // 첨부 최대 용량 설정
		if(file.value !=""){
			// 사이즈체크
			var maxSize  = 1024 * 1024 * fileMaxSize;  
			var fileSize = 0;
			// 브라우저 확인
			var browser=navigator.appName;
			// 익스플로러일 경우
			if (browser=="Microsoft Internet Explorer"){
				var oas = new ActiveXObject("Scripting.FileSystemObject");
				fileSize = oas.getFile(file.value).size;
			}else {
			// 익스플로러가 아닐경우
				fileSize = file.files[0].size;
			}

			if(fileSize > maxSize){
				alert(" 첨부파일 사이즈는 "+fileMaxSize+"MB 이내로 등록 가능합니다. ");
				return;
			}	
		}
		
		
		notice.method="post";
		notice.action="db_notice_update.jsp";
		notice.submit();
	}
</script>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>공지사항</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="index.jsp"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.html">공지사항</a>
						<a href="allclass.html">학과및모집안내</a>
						<a href="portfolio.html">포트폴리오</a>
						<a href="online.html">온라인접수</a>
						<a href="notice.html">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">공지사항<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.html">공지사항</a>
						<a href="gratings.html">DW인터뷰</a>
						<a href="gratings.html">취업실적</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">공지사항 글쓰기</h2>
	  <form name="notice" enctype="multipart/form-data">
	  		<input type="hidden" name="t_no" value="<%=no%>">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
						<table class="bord_table">
				<caption class="sr-only">공지사항 입력 표</caption>
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="15%">
					<col width="35%">
				</colgroup>
				<tbody>

					<tr class="first"> 
						<th>제목</th>
						<td colspan="3"><input type="text" name="t_title" value=<%=dto.getTitle()%>></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea name="t_content"><%=dto.getContent()%></textarea></td>
					</tr>
					<tr>
						<th>첨부</th>
<style>
.attach{
	height:15px;
	width:15px;
}
</style>
						<td colspan="3">
							<%if(dto.getAttach()!=null){ %>
								<%=dto.getAttach() %>&nbsp;&nbsp;
								삭제<input type="checkbox" name="t_deleteFile" value="<%=dto.getAttach()%>" class="attach">
								<input type="hidden" name="t_ori_attach" value="<%=dto.getAttach()%>">
							<% } %>	
						<input type="file" name="t_attach"></td>
					</tr>
					<tr>
						<th>등록자</th>
						<td><%=dto.getReg_name()%></td>
						<th>등록일자</th>
						<td><%=dto.getReg_date()%></td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="button" value="수정저장" onclick="goUpdate()" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onclick="location.href='notice_list';">
			</div>
		</form>
	  </div>
	</div>
	<!-- end contents -->
	
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
	
<%@ include file="../common_footer.jsp"%>	

 </body>
</html>    
<% } %>