<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<c:if test="${sessionLevel ne 'member'}">
	<script>
		alert("회원 화면 입니다!");
		location.href="Qna";
	</script>
</c:if>
<script type="text/javascript">
	function goUpdate(no){
		if(checkValue(qa.q_title,"제목 입력!")) return;
		if(checkValue(qa.q_content,"내용 입력!")) return;
		qa.t_no.value=no
		qa.method="post";
		qa.submit();
		
				
	}
</script>
<script type="text/javascript">
	$(function(){					
		function readImage(input) {
		    // 인풋 태그에 파일이 있는 경우
		    if(input.files && input.files[0]) {
		        // 이미지 파일인지 검사 (생략)
		        // FileReader 인스턴스 생성
		        const reader = new FileReader();
		        // 이미지가 로드가 된 경우
		        reader.onload = e => {
		            const previewImage = document.getElementById("preview-image");
		            previewImage.src = e.target.result;
		        }
		        // reader가 이미지 읽도록 하기
		        reader.readAsDataURL(input.files[0]);
		    } else {
		    	// 이미지 안올렸으면
				$("#preview-image").attr('src','');
				$("#preview-image").css("display","none");
		    }
		}
		// input file에 change 이벤트 부여
		const inputImage = document.getElementById("input-image");
		inputImage.addEventListener("change", e => {
			$("#preview-image").css("display","block");
		    readImage(e.target)
		})	
	});	
</script>	
<style>
	#preview-image{
		border:1px solid gray;
		width:500px;
		height:300px;
		margin-left:50px;
		margin-bottom:10px;	
		display:none;	
	}
</style>
		<div id="b_left">
			<%@ include file="../common_menu.jsp" %>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				QNA
			</p>
			<form name="qa" enctype="multipart/form-data">
			<input type="hidden" name="t_no" value="${t_dto.getNo()}">
			<input type="hidden" name="t_gubun" value="update">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3"><input type="text" name="q_title" value="${t_dto.getQ_title()}" class="input600"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea cols="80" rows="20" name="q_content">${t_dto.getQ_content()}</textarea></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td colspan="3">${sessionName}</td>
					</tr>	
					<tr>
						<td colspan="4">
						*이미지 첨부 선택 500px * 300px 권장<br><br>
							<img id="preview-image">
							<input type="file" name="t_photos" id="input-image" class="input600">
						</td>
					</tr>	
				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goUpdate('${t_dto.getNo()}')" class="butt">Save</a>
				<a href="Qna" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@ include file="../common_footer.jsp" %>	
</body>
</html>






    