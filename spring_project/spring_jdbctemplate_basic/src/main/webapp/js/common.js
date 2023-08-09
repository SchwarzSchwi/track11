function checkValue(obj, msg){
		var val = obj.value;
		var result = false;
		if(val ==""){
			alert(msg);
			obj.focus();
			result = true;
		} 
		return result;
}