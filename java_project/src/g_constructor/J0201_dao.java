package g_constructor;

public class J0201_dao {
	void dtoPrint(J0201_dto[] arr){
		for(int k = 0; k<arr.length; k++) {
			System.out.print("name : "+arr[k].getName());
			System.out.print("area : "+arr[k].getArea());
			System.out.print("age : "+arr[k].getAge());
			System.out.print("education : "+arr[k].getEdu()+"/n");
		}	
	}
	String getAreaName(String gubun){
		String areaName ="no area";
		if(gubun.equals("s")){
			areaName = "Seoul";
		}else if (gubun.equals("d")|| gubun.equals("D")) {
			areaName = "Daejeon";
		}else if (gubun.equals("c")|| gubun.equals("C")) {
			areaName = "Chungju";
		}else if (gubun.equals("b")|| gubun.equals("B")) {
			areaName = "Busan";
		}
		return areaName;
	}
	String getEduName(String gubun) {
		String eduName = "no education";
		if(gubun.equals("M") || gubun.equals("m")) {
			eduName = "Middle school";	
		}else if(gubun.equals("H")|| gubun.equals("h")) {
			eduName = "High school";
		}else if(gubun.equals("U")|| gubun.equals("u")) {
			eduName = "University";
		}
		return eduName;
	}
}
