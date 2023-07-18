<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<c:if test="${sessionLevel eq null}">
	<script>
		alert("회원 화면 입니다!");
		location.href="Freeboard";
	</script>
</c:if>
<script type="text/javascript">
	function goUpdate(no){
		if(checkValue(fb.t_title,"제목 입력!")) return;
		if(checkValue(fb.t_content,"내용 입력!")) return;
		/***  첨부파일 검사 ***/
		// 1.확장자 검사
		var fileName = fb.t_attach.value;
		if(fileName != ""){ //  C:\fakepath\img_1.png
			var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
			var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
			//파일명.확장자
			if(extension != "jpg" && extension != "gif" && extension != "png"){
				alert(extension +" 형식 파일은 업로드 안됩니다. jpg, gif, png 파일만 가능!");
				return;
			}		
		}
//	
		// 2.첨부 용량 체크	
		var file = fb.t_attach;
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
		
		fb.t_no.value=no
		fb.method="post";
		fb.action="Freeboard?t_gubun=update";
		fb.submit();
		
				
	}
</script>
		<div id="b_left">
			<%@ include file="../common_menu.jsp" %>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				FREEBOARD
			</p>
			<form name="fb" enctype="multipart/form-data">
			<input type="hidden" name="t_no" value="${t_dto.getNo()}">
			<input type="hidden" name="t_ori_attach" value="${t_dto.getAttach()}">
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
						<td colspan="3"><input type="text" name="t_title" value="${t_dto.getTitle()}" class="input600"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea cols="80" rows="20" name="t_content">${t_dto.getContent()}</textarea></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td colspan="3">${sessionName}</td>
					</tr>	
<style>
	.viewImg{
		width:500px;
		height:300px;
	}
	.imgDiv{
		width:500px;
		height:300px;	
		padding: 10px;
		margin: 10px 30px;			
		border:1px solid gray;
	}
</style>							
					<tr>
						<td colspan="4">
						*이미지 첨부 선택 500px * 300px 권장<br><br>
							<img id="preview-image">
							<input type="file" name="t_attach" id="input-image" class="input600">
						</td>
					</tr>
<script type="text/javascript">
	$(function(){					
		function readImage(input) {
		    // 인풋 태그에 파일이 있는 경우
		    if(input.files && input.files[0]) {
		        // 이미지 파일인지 검사 (생략)
		        // FileReader 인스턴스 생성
		        const reader = new FileReader()
		        // 이미지가 로드가 된 경우
		        reader.onload = e => {
		            const previewImage = document.getElementById("preview-image")
		            previewImage.src = e.target.result;
		        }
		        // reader가 이미지 읽도록 하기
		        reader.readAsDataURL(input.files[0])
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
				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goUpdate('${t_dto.getNo()}')" class="butt">Save</a>
				<a href="Freeboard" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@ include file="../common_footer.jsp" %>	
</body>
</html>






    