<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<html>
<head>
<title>
JSL11 최선우
</title>
<link href="css/sub_c.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/17da812ad5.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
    //<![CDATA[
    $(function(){
    	$(".main_menu > li > a").mouseover(function(){
			$(".main_menu li div").hide();
			$(this).next().slideDown(500);
    	});    
    	$(".main_menu").mouseleave(function(){
			$(".main_menu li div").stop().slideUp(500);
		}) 
    });     
    //]]>
</script> 
<script>
	function goWork(gubun){
		bike.t_gubun.value=gubun;
		bike.method="post";
		bike.action="Member";
		bike.submit();
	}
	function goAdmin(){
		bike.t_gubun.value="memberList";
		bike.method="post";
		bike.action="Admin";
		bike.submit();
	}
</script>
</head>
<body>
<form name="bike">
	<input type="hidden" name="t_gubun">
</form>
	<div id="container">

		<div id="b_top_menu">
			<ul class="top_menu">
				<c:if test="${sessionLevel eq 'admin'}">
				<li><a href="javascript:goAdmin()">Admin</a></li>
				</c:if>
				<li><a href="javascript:goWork('memberJoin')">Join</a></li>
				<c:if test="${empty sessionId}">
				<li><a href="javascript:goWork('memberLogin')">Login</a></li>
				</c:if>
				<c:if test="${not empty sessionId}">
				<li><a href="javascript:goWork('memberMyinfo')">MyInfo</a></li>
				<li><a href="javascript:goWork('memberLogout')">Logout</a></li>
				</c:if>
				<li><a href="Index"><i class="fa fa-home"></i>Home</a></li>
			</ul>
		</div>	

		<div id="b_top">
			<ul class="main_menu">
				<li><a href="">Accessories</a>
					<div>
						<ul>
							<li><a href="">Bells</a></li>
							<li><a href="">Camping</a></li>
							<li><a href="">Embrocation</a></li>
							<li><a href="">Fenders</a></li>
							<li><a href="">Kickstands</a></li>
							<li><a href="">Horns</a></li>
						</ul>
					</div>
				</li>
				<li><a href="">Bikes & Frames</a>
					<div>
						<ul>
							<li><a href="">BMX</a></li>
							<li><a href="">Cyclocross</a></li>
							<li><a href="">Forks</a></li>
							<li><a href="">Frames</a></li>
						</ul>
					</div>
				
				</li>
				<li><a href="">Clothing</a>
					<div class="div3">
						<ul>
							<li><a href="">3sub menu 1</a></li>
							<li><a href="">3sub menu 2</a></li>
							<li><a href="">3sub menu 3</a></li>
						</ul>
					</div>				
				</li>
				<li><a href="">Maintenance</a>
					<div class="div4">
						<ul>
							<li><a href="">4sub menu 1</a></li>
							<li><a href="">4sub menu 2</a></li>
							<li><a href="">4sub menu 3</a></li>
							<li><a href="">4sub menu 4</a></li>
							<li><a href="">4sub menu 5</a></li>
						</ul>
					</div>					
				</li>
				<li><a href="">Parts</a>
					<div class="div5">
						<ul>
							<li><a href="">5sub menu 1</a></li>
							<li><a href="">5sub menu 2</a></li>
							<li><a href="">5sub menu 3</a></li>
							<li><a href="">5sub menu 4</a></li>
							<li><a href="">5sub menu 5</a></li>
						</ul>
					</div>					
				</li>
				<li><a href="Product">Product</a>
					<div class="div6">
						<ul>
							<li><a href="">6sub menu 1</a></li>
							<li><a href="">6sub menu 2</a></li>
							<li><a href="">6sub menu 3</a></li>
							<li><a href="">6sub menu 4</a></li>
							<li><a href="">6sub menu 5</a></li>
						</ul>
					</div>					
				</li>
				<li><a href="Notice">Notice & News</a>
					<div class="div7">
						<ul>
							<li><a href="Notice">NOTICE</a></li>
							<li><a href="News">NEWS</a></li>
							<li><a href="Qna">Q AND A</a></li>
							<li><a href="Freeboard">FREE BOARD</a></li>
							<li><a href="Etc">ETC</a></li>
						</ul>
					</div>					
				</li>
			</ul>		
		</div>	