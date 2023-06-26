<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*"%>
<%
	MemberDao dao = new MemberDao();
	request.setCharacterEncoding("utf-8");
	
	String sessionId = (String)session.getAttribute("sessionId");
	
	if(sessionId == null){
%>	
		<script>
			alert("로그인 정보가 만료되었습니다!");
			location.href="../login/member_login.jsp";
		</script>	
<%	
	}else{
	
	MemberDto dto = dao.memberView(sessionId);
%>    
    
<!doctype html>
<html lang="ko">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="JSL">
  <meta name="Keywords" content="반응형홈페이지,  JAVA, JSP, PHP, 대전직업전문학교, 대전국비지원, 국비무료">
  <meta name="Description" content="응용SW개발자를 위한 반응형 홈페이지">
  <title>JSL인재개발원</title>
  <link href="../css/font-awesome.min.css" rel="stylesheet">
  <link href="../css/common.css" rel="stylesheet">
  <link href="../css/layout.css" rel='stylesheet'>
  <!--
  	jquery언어 사용법
	1. jquey.js을 기반으로 프로그램을 작성하기 때문에 jquery.js 파일을 다운 또는 CDN 방식으로 링크를 건다
	2. $(function() {
		실행문;
	});
  -->
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
  <script src="../js/jquery-3.3.1.min.js"></script>
  <script src="../js/common.js"></script>

 </head>
 <body>
 <!-- 
 웹문서 만들기 기본 공식
 1. 요소를 어떻게 묶을 것인가? 그룹만들기
 2. 그룹안에 적절한 태그 사용
 3. class 이름 붙이고 css 적용
 -->
	<div class="sr-only">
		<p><a href="#contents">본문 바로가기</a></p>
	</div>

	<div class="top_navigation">
	
		<header class="header">
			<nav class="top_left">
			  <ul>
			  	<li class="first"><a href="../index.jsp">HOME</a></li>
				<li><a href="">모집안내</a></li>
				<li><a href="">입학상담</a></li>
				<li><a href="">교육신청</a></li>
			  </ul>
			</nav>
			<nav class="top_right">
				<ul>
					<li class="first"><a href="">네이버블로그</a></li>
					<li><a href="">페이스북</a></li>
					<li><a href="">인스타그램</a></li>
					<li><a href="">동영상강좌</a></li>
				</ul>
			</nav>
			
			<div class="gnb_group">
				<h1 class="logo">JSL CO</h1>
				<nav class="gnb">
					<ul class="nav_1depth">
						<li><a href="gratings.html">기업소개</a>
							<ul class="nav_2depth">
								<li><a href="../about/gratings.html">인사말</a></li>
								<li><a href="../about/history.html">연혁 및 </a></li>
								<li><a href="../about/gratings.html">교직원소개</a></li>
								<li><a href="../gallery/photo.html">대우갤러리</a></li>
								<li><a href="../about/map.html">찾아오시는길</a></li>
							</ul>
						</li>
						<!-- <li><a href="allclass.html">학과및모집안내</a>
							<ul class="nav_2depth">
								<li><a href="#">전체모집과정</a></li>
								<li><a href="#">스마트웹콘텐츠개발과정</a></li>
							</ul>
						</li> -->
						<li><a href="../portfolio/portfolio.html">포트폴리오</a>
							<ul class="nav_2depth">
								<li><a href="../portfolio/portfolio.html">포트폴리오</a></li>
							</ul>
						</li>
						<!-- <li><a href="online.html">온라인접수</a>
							<ul class="nav_2depth">
								<li><a href="#">온라인접수</a></li>
								<li><a href="#">취업성공패키지</a></li>
							</ul>
						</li> -->
						<li><a href="../notice.html">커뮤니티</a>
							<ul class="nav_2depth">
								<li><a href="notice.html">공지사항</a></li>
								<li><a href="../qna/qa.html">질문과답변</a></li>
								<li><a href="../faq/faq.html">FAQ</a></li>
								<li><a href="../pds/pds.html">자료실</a></li>
								<li><a href="../adm/admin.html">관리자</a></li>
							</ul>
						</li>
					</ul>
				</nav>
			</div>
		</header>

		<div class="line">
		</div>

	</div>
	
	<script>
		//$(document).ready(function() {
		$(function() {
			$(".gnb>.nav_1depth>li").hover(function() {
				$(".gnb>.nav_1depth>li").removeClass();
				$(this).addClass("active");

				//$(this).children(".nav_2depth").show();
				//}, function() {
				//  $(".gnb>.nav_1depth>li").removeClass();
				//  $(this).children(".nav_2depth").hide();
				//	});

				$(this).children(".nav_2depth").stop().slideDown("fast");
				}, function() {
				  $(".gnb>.nav_1depth>li").removeClass();
				  $(this).children(".nav_2depth").stop().slideUp("fast");
					});

				/* $(this).children(".nav_2depth").fadeIn();
				}, function() {
				  $(".gnb>.nav_1depth>li").removeClass();
				  $(this).children(".nav_2depth").fadeOut();
					}); */

			});
	</script>
	<script>
	function memberUpdate(){
		
		if(checkValue(mem.t_name,"성명 입력!")) return;	
		var idLength = mem.t_id.value.length;		

		var tell_2_length = mem.t_tell_2.value.length; 
		var tell_3_length = mem.t_tell_3.value.length; 
		if(mem.t_tell_1.value !="" && tell_2_length ==0){
			alert("연락처 3자리!");
			mem.t_tell_2.focus();
			return;			
		}
		
		if(mem.t_tell_1.value !="" && tell_3_length ==0){
			alert("연락처 4자리!");
			mem.t_tell_3.focus();
			return;			
		}		


		if(tell_2_length != 3 && tell_2_length != 0){
			alert("연락처 3자리!");
			mem.t_tell_2.focus();
			return;
		}

		
		if(tell_3_length != 4 && tell_3_length != 0){
			alert("연락처 4자리!");
			mem.t_tell_3.focus();
			return;
		}		
		
		if(tell_2_length ==3 && tell_3_length ==0){
			alert("세번째 연락처 입력!");
			mem.t_tell_3.focus();
			return;
		}
		
		if(tell_3_length ==4 && tell_2_length ==0){
			alert("두번째 연락처 입력!");
			mem.t_tell_2.focus();
			return;
		}			
		
		if(checkValue(mem.t_mobile_2,"휴대전화 입력!")) return;
		if(checkValue(mem.t_mobile_3,"휴대전화 입력!")) return;
		
		if(mem.t_mobile_2.value.length != 4){
			alert("휴대전화 두번째 4자리!");
			mem.t_mobile_2.focus();
			return;
		}
		
		if(mem.t_mobile_3.value.length != 4){
			alert("휴대전화 세번째 4자리!");
			mem.t_mobile_3.focus();
			return;
		}	
	
		if(checkValue(mem.t_email,"e-mail 입력!")) return;

		if(checkValue(mem.t_password,"비밀번호 확인 입력!")) return;
		
		mem.method="post";
		mem.action="db_member_update.jsp";
		mem.submit();
		
/*		
		if(mem.t_name.value ==""){
			alert("성명 입력!");
			mem.t_name.focus();
			return;
		}
		if(mem.t_id.value ==""){
			alert("ID 입력!");
			mem.t_id.focus();
			return;
		}	
		if(mem.t_pw_1.value ==""){
			alert("비밀번호 입력!");
			mem.t_pw_1.focus();
			return;
		}	
*/		
	}
</script>
	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>회원정보수정</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="../index.jsp"><i class="fa fa-home btn_plus"></i></a>
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
						<a href="notice.html">공지사항</a>
						<a href="qa.html">질문과답변</a>
						<a href="faq.html">FAQ</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>


	<div class="container">
		<div class="con_title">
            <h1>내정보(개인회원)</h1>
         <p>HOME / 마이페이지 / 내정보(개인회원)</p>
        </div>
		<div class="join_write col_989">
                <div class="list_con">
                    <ul class="icon_type1">
                        <li>회원정보는 개인정보 취급방침에 따라 안전하게 보호되며 회원님의 명백한 동의 없이 공개 또는 제3자에게 제공되지 않습니다.</li>
                    </ul>
                </div>
            <form name="mem">
            <input type="hidden" name="t_id" value="<%=dto.getId()%>">   
            <table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
                <caption>회원가입을 위한 정보입력표</caption>
                <colgroup>
                    <col width="160px">
                    <col width="auto">
                </colgroup>
                <tbody id="joinDataBody">
                	 <tr>
                        <th><label for="id">아이디<span class="must"></span></label></th>
                        <td><%=dto.getId()%></td>
                    </tr>
                    <tr>
                        <th><label for="name">이름</label></th>
                        <td>
                            <input type="text" name="t_name" value="<%=dto.getName()%>" autofocus id="mbrName" class="w300">
                        </td>
                    </tr>
                    <tr>
                        <th>소속<span class="must"><b>입력</b></span></th>
                        <td>
                            <label for="mbrClCd" class="blind">소속1차 카테고리 선택</label>
							<select name="t_job" id="mbrClCd">
								<option value="기업"<% if(dto.getJob().equals("기업")) out.print("selected"); %>>기업</option>
								<option value="교수자"<% if(dto.getJob().equals("교수자")) out.print("selected"); %>>교수자</option>
								<option value="미취업자"<% if(dto.getJob().equals("미취업자")) out.print("selected"); %>>미취업자</option>
								<option value="기타"<% if(dto.getJob().equals("기타")) out.print("selected"); %>>기타</option>
							</select>
							<p class="guideTxt">학생 신분은 '미취업자-학생' 소속으로 선택해주십시오.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>유선전화</th>
                        <td>
                            <label for="phone_number1" class="blind">유선전화 앞번호 선택</label>
                            <select name="t_tell_1" id="telNo1" class="w95">
                            <%
                            	String tell_1= "";
                            	if(dto.getTell_1() != null)tell_1 = dto.getTell_1();
                            %>
                                <option value="" <%if(tell_1.equals(""))out.print("selected");%>>선택</option>
                                <option value="02"<%if(tell_1.equals("02"))out.print("selected");%>>02</option>
                                <option value="042"<%if(tell_1.equals("042"))out.print("selected");%>>042</option>
                                <option value="051"<%if(tell_1.equals("051"))out.print("selected");%>>051</option>
                                <option value="061"<%if(tell_1.equals("061"))out.print("selected");%>>061</option>
                            </select>
                            <input type="text" name="t_tell_2" id="telNo2" class="w95" value="<%if(dto.getTell_2() != null)out.print(dto.getTell_2());%>" maxlength="3"><label for="phone_number2" class="blind">중간번호</label>
                            <input type="text" name="t_tell_3" id="telNo3" class="w95" value="<%if(dto.getTell_3() != null)out.print(dto.getTell_3());%>" maxlength="4"><label for="phone_number3" class="blind">마직막번호</label>
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화<span class="must"></th>
                        <td>
                        <%
                        	String mobile_1 = dto.getMobile().substring(0,3);
                        	String mobile_2 = dto.getMobile().substring(3,7);
                          	String mobile_3 = dto.getMobile().substring(7);	
                        %>
                            <label for="mphonNo1" class="blind">휴대전화 앞번호 선택</label>
                            <select name="t_mobile_1" id="mphonNo1" class="w95">
                                    <option value="010" <%if(mobile_1.equals("010"))out.print("selected");%>>010</option>
                                    <option value="011" <%if(mobile_2.equals("011"))out.print("selected");%>>011</option>
                            </select>
                            <input type="text" name="t_mobile_2" value="<%=mobile_2%>" id="mphonNo2" class="w95" maxlength="4"><label for="mphonNo2" class="blind">중간번호</label>
                            <input type="text" name="t_mobile_3" value="<%=mobile_3%>" id="mphonNo3" class="w95" maxlength="4"><label for="mphonNo3" class="blind">마직막번호</label>
                        </td>
                    </tr> 
                    <tr>
                        <th><label for="email">이메일</label></th>
                        <td>
                            <input type="email" value="<%=dto.getEmail()%>" name="t_email" id="email" class="w300" >
                        </td>
                    </tr>
                    <tr>
                    <th><label for="pw">비밀번호확인<!-- <span class="must"><b>필수입력</b></span> --></label></th>
                    <td>
                        <input type="password" name="t_password" id="scrtNo" class="w300">
                        <p class="guideTxt"><span class="tc_point"></p>
                    </td>
                    </tr>
				</tbody>
            </table>
            </input>
            </form>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
        <a href="javascript:history.go(-1);" class="btn_round btn_large btn_BlueGray w180"><b>취소</b></a>
        <a href="javascript:memberUpdate()" class="btn_round btn_large btn_pointColor w180"><b>확인</b></a>
    </div>
	
	
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
	

<%@ include file="../common_footer.jsp" %>

 </body>
</html>
<% } %>









    