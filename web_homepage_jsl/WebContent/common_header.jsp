<%@ page pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="JSL">
  <meta name="Keywords" content="반응형홈페이지,  JAVA, JSP, PHP, 대전직업전문학교, 대전국비지원, 국비무료">
  <meta name="Description" content="응용SW개발자를 위한 반응형 홈페이지">
  <title>JSL인재개발원_최선우</title>
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
			  	<li class="first"><a href="/web_homepage_jsl/index.jsp">HOME</a></li>
				<li><a href="">모집안내</a></li>
				<li><a href="">입학상담</a></li>
				<li><a href="">교육신청</a></li>
			  </ul>
			</nav>
			<nav class="top_right">
				<ul>
					<%	
						String commonSessionName =
							(String)session.getAttribute("sessionName");
						if(commonSessionName == null){ %>
						<li class="first">
							<a href="/web_homepage_jsl/login/member_login.jsp">로그인</a>
						</li>	
					<%	} else { %>
						<li class="first">
							<a href="/web_homepage_jsl/login/member_logout.jsp">로그아웃</a>
						</li>
						<li>	
							<a href="/web_homepage_jsl/member/member_myinfo.jsp">내정보</a>
						</li>	
					<%	} %>
					<li><a href="/web_homepage_jsl/member/member_join.jsp">회원가입</a></li>
					<!--<li class="first"><a href="">로그아웃</a></li>
					<li><a href="">마이페이지</a></li> -->
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
						<li><a href="/web_homepage_jsl/notice/notice_list.jsp">커뮤니티</a>
							<ul class="nav_2depth">
								<li><a href="/web_homepage_jsl/notice/notice_list.jsp">공지사항</a></li>
								<li><a href="/web_homepage_jsl/news/news_list.jsp">뉴스</a></li>
								<li><a href="../qna/qa_list.jsp">질문과답변</a></li>
								<li><a href="../faq/faq_list.jsp">FAQ</a></li>
								<li><a href="../pds/pds_list.jsp">자료실</a></li>
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
	