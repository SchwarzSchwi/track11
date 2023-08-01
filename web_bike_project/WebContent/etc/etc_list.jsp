<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<script>
/*
	$(function() {
		$(".accordion").on("click",function() {
			$(".panel").not($(this).next().slideToggle()).slideUp();
			$(".accordion").not($(this)).removeClass("active");
			$(this).toggleClass("active");
		});

	});
	*/
</script>
<script>
	$(document).ready(function(){
	    EtcList();
	});
	function EtcList(search,nowPage){
		$.ajax({
			type : 'POST',
			url : 'EtcList',
			dataType : 'text',
			data : 't_nowPage='+nowPage+'&t_search='+search,
			async:false,
			error : function(){
				alert('통신 실패');
			},
			success : function(data){
				data = JSON.parse(data);
				console.log(data);
				
				$('.t_count').html(data.t_total_count);
				$('.paging').html(data.t_paging);		
				etc.t_search.value=data.t_search;
				
				var tb = "<div class='faq-group'>";
				tb+="<script>$(function() {$('.accordion').on('click',function() {$('.panel').not($(this).next().slideToggle()).slideUp();";
				tb+="$('.accordion').not($(this)).removeClass('active');$(this).toggleClass('active');});});<\/script>";
				for (var i=0; i<data.t_arr.length; i++){
					var jsob = JSON.parse(JSON.stringify(data.t_arr[i]));
					var content = jsob.content;
					var depth = jsob.depth;
					var no = jsob.no;
					var reg_date = jsob.reg_date;
					var reg_id = jsob.reg_id;
					var reg_name = jsob.reg_name;
					var reply = jsob.reply;   
					var content_view = jsob.content_view;
					var arrow = jsob.arrow;
					var deleteT = jsob.deleteT;
					var showtext = jsob.showtext;
					tb+="<div class='accordion' style='padding:0px;padding-bottom:18px;'><table class='boardList'><colgroup><col width='*'><col width='10%'>";
					tb+="<col width='14%'></colgroup><tbody><tr><td class='t_left' style='border:none;'>";
					tb+=depth+arrow+"&nbsp;"+content_view;
					tb+="</td><td style='border:none;'>"+reg_name+"</td><td style='border:none;'>"+reg_date+"</td>";
					tb+="</tr></tbody></table></div><div class='panel btn_3wrap buttonGroup'>";
					tb+="<fieldset style='margin-bottom:10px;'><legend style='margin:0 auto;'>Comments</legend>";
					tb+="<div class='longlong' style='width:600px;margin-left:5px;'>"+content+"</div></fieldset>"+showtext;
					tb+="<c:if test='${sLevel>=0 }'><a href='javascript:goReply(&#39;"+no+"&#39;)' class='butt'>답변</a></c:if>"+deleteT+"</div>";
				}tb+="</div>";
				$(".faq-group").html(tb);
			}
		});
	}
</script>
<style>
	.longlong {word-break:break-all;white-space:pre-wrap;}
	.faq-group .accordion {padding:18px; width:100%; text-align:left;border:0 none; background:transparent; border-bottom:1px solid #ddd; font-size:16px; font-weight:bold; cursor:pointer;}
	.faq-group .accordion:after {content:"\f0fe";font-family:FontAwesome; float:right;}
	.faq-group .panel {padding:20px 18px; border-bottom:1px solid #ddd; line-height:1.8; display:none;}
	.faq-group .panel textarea{width:100%; height:100px;}
	.faq-group .active:after {content:"\f068";font-family:FontAwesome; float:right;}
	td {border:none;}
</style>
<script>
	function WriteComments(){
		if(window.event.keyCode==13) goComments();
	}function goComments(){
		if(etc.t_id.value==""){
			alert("로그인후 작성하세요");
			return;
		}
		$.ajax({
			type : 'POST',
			url : 'EtcWrite',
			dataType : 'text',
			data : 't_content='+write.t_comments.value,
			error : function(){
				alert('통신 실패');
			},
			success : function(){
				EtcList();
				write.t_comments.value="";
			}
		});
	}function WriteReply(no){
		if(window.event.keyCode==13) goReply(no);
	}function goReply(no){
		var id = "#"+no;
		var content = $(id).val();
		if(content==""){
			alert("내용을 작성해주세요");
			return;
		}
		if(etc.t_id.value==""){
			alert("로그인후 작성하세요");
			return;
		}
		console.log(content);
		
		$.ajax({
			type : 'POST',
			url : 'EtcReply',
			dataType : 'text',
			data : 't_content='+content+'&t_no='+no,
			error : function(){
				alert('통신 실패');
			},
			success : function(){
				EtcList();
			}
		});
	}function goDelete(no){
		if(confirm("정말로 삭제하시겠습니까?")){
			$.ajax({
				type : 'POST',
				url : 'EtcDelete',
				dataType : 'text',
				data : 't_no='+no,
				error : function(){
					alert('통신 실패');
				},
				success : function(){
					EtcList();
				}
			});
		}
	}function goPage(page){
		var nowPage = page;
		var search = $('.sel_text').val();
		EtcList(search,nowPage);
	}function goSearch(){
		var search = $('.sel_text').val();
		EtcList(search);
	}
	
</script>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				Etc
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span class="t_count"> </span>건</p>
			</div>			
			<form name="etc">
			<input type="hidden" name="t_id" value="${sessionId }">
			<p class="select_box select_box_right">
				<input type="text" name="t_search" value="${t_search }" class="sel_text">
				<button type="button" onClick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>			
			</form>
			<table class="boardList">
				<colgroup>
					<col width="*">
					<col width="10%">
					<col width="14%">
				</colgroup>
				<thead>
					<tr>
						<th>Content</th>
						<th>Reg Name</th>
						<th>Reg Date</th>
					</tr>
				</thead>
			</table>
			<div class="faq-group">
			</div>
			<form name="write">
				<table style="width:100%;">
					<colgroup>
						<col width = "*">
						<col width = "14%">
					</colgroup>
					<tr>
						<th style="text-align:left;">글 작성하기</th>
					</tr>
					<tr>
						<td>
							<textarea style="width:600px;height:100px;" id="t_comments" onKeyPress="WriteComments()"></textarea>
						</td>
						<td class="buttonGroup">
							<a href="javascript:void()" onClick="goComments()" class="butt" style="margin:0;">작성</a>
						</td>
					</tr>
				</table>
			</form>
			<div class="paging">
			</div>
		</div>	
	</div>
<%@ include file="/common_footer.jsp" %>