<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>  
<script type="text/javascript">
	function goSave(){
		if(checkValue(product.t_serial_no,"제품번호 입력!")) return;
		if(checkValue(product.t_name,"제품명 입력!")) return;
		if(checkValue(product.t_content,"상세설명 입력!")) return;
		if(checkValue(product.t_priority,"우선순위 선택!!")) return;
		if(checkValue(product.t_huge,"사이즈 선택!")) return;
		if(checkValue(product.t_price,"가격 입력!")) return;
		if(checkValue(product.t_photos,"첨부 이미지 선택!")) return;
		/***  첨부파일 검사 ***/
		// 1.확장자 검사
		var fileName = product.t_photos.value;
		if(fileName != ""){ //  C:\fakepath\img_1.png
			var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
			var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
			//파일명.확장자
			if(extension != "jpg" && extension != "gif" && extension != "png"){
				alert(extension +" 형식 파일은 업로드 안됩니다. jpg, gif, png 파일만 가능!");
				return;
			}		
		}
	
		// 2.첨부 용량 체크	
		var file = product.t_photos;
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
		product.method="post";
		product.action="Product?t_gubun=save";
		product.submit();
	}
</script>  
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
			<%@ include file="../common_menu_admin.jsp" %>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				PRODUCT
			</p>
			<form name="product" enctype="multipart/form-data">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>제품 번호</th>
						<td colspan="2"><input type="text" name="t_serial_no" class="input600"></td>
					</tr>	
					<tr>
						<th>제품명</th>
						<td colspan="2"><input type="text" name="t_name" class="input600"></td>
					</tr>	
					<tr>
						<th>상세설명</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250"></textarea></td>
					</tr>
					<tr>
						<th>우선순위</th>
						<td>
							<input type="radio" value="1" name="t_priority" class="middleCheck" /> 1&nbsp;&nbsp;  
							<input type="radio" value="2" name="t_priority" class="middleCheck" /> 2&nbsp;&nbsp;  
							<input type="radio" value="3" name="t_priority" class="middleCheck" /> 3
						</td>
					</tr>	
					<tr>
						<th>사이즈</th>
						<td>
							<select name="t_huge">
								<option value="L">성인</option>
								<option value="M">학생</option>
								<option value="S">유아</option>
							</select>	
						</td>
					</tr>	
					<tr>
						<th>가격</th>
						<td colspan="2"><input type="text" name="t_price" class="input600"></td>
					</tr>	
					<tr>
						<th>등록일</th>
						<td>${t_today}</td>
					</tr>
					<tr>
						<th>등록자</th>
						<td>${sessionName}</td>
					</tr>
					<tr>
						<td colspan="3">
						*이미지 첨부 필수 500px * 300px 권장<br><br>
							<img id="preview-image">
							<input type="file" name="t_photos" id="input-image" class="input600">
						</td>
					</tr>	
				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="Product" class="butt">List</a>
			</div>	
		</div>	
<%@ include file="../common_footer.jsp" %>	
</body>
</html>








