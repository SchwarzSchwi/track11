function comma(num){
		var len, point, str;  
		  
		num = num + "";  
		point = num.length % 3 ;
		len = num.length;  
	  
		str = num.substring(0, point);  
		while (point < len) {  
		    if (str != "") str += ",";  
		    str += num.substring(point, point + 3);  
		    point += 3;  
		}  
		
		return str;
	
	}
function checkAttach(dir, maxSize){
		var fileName = dir.value;
		var extensions = ['jpg','svg','png','gif'];
		if(fileName != ""){ //  C:\fakepath\img_1.png
			var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
			var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
			var counts=0;
				
			for(var k = 0; k<extension.length; k++){
				if(extension==extensions[k]){
					counts++;
				}
			}
			if(counts!=1){
				alert("해당 파일 형식은 사용할 수 없습니다.");
				return true;
			}
		}
		var file = dir;
		var fileMaxSize  = maxSize; // 첨부 최대 용량 설정
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
				return true;
			}	
		}
		return false;
	}
	
function test_alert(){
	alert("imported");
}

function checking(input,len,obj){
	if(input.value==""){
		alert(obj+" 확인해주세요");
		input.focus();
		return true;
	}else if(Number(input.value.length)>Number(len)){
		alert(obj+" 길이는 "+len+"자리 이하로 해주세요");
		input.focus();
		return true;
	}else return false;
}

function checkingMobile(input,len,obj){
	if(input.value==""){
		alert(obj+" 확인해주세요");
		input.focus();
		return true;
	}else if(Number(input.value.length)!=Number(len)){
		alert(obj+" 길이는 "+len+"자리로 해주세요");
		input.focus();
		return true;
	}else return false;
}

function checkLength(input,len,obj){
	if(Number(input.value.length)>Number(len)){
		alert(obj+" 길이는 "+len+"자리 이하로 해주세요");
		input.focus();
		return true;
	}else return false;
}
/*
function checkId(){
		$.ajax({
		//$(jQuery)의 ajax 라는 기능을 실행한다.
			type : "POST",
			//새창에서 연다
			url : "member_checkid.jsp",
			//해당 url로 이동한다
			data: "t_id="+mem.t_id.value,
			//매개변수를 입력한다.
			dataType : "text",
			//결과를 글자로 받겠다.
			error : function(){
			//에러가 생기면 function을 실행한다.
				alert('통신실패!!!!!');
			},
			success : function(data){
			//성공하면 data를 매개변수로 하는 function을 실행시킨다.
				alert(data);
			}
		});				
	}
*/