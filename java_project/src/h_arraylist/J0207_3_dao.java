package h_arraylist;

public class J0207_3_dao {
	
	String getName(String gubun) {
	      String name="입력오류";
	      if(gubun.equals("c")||gubun.equals("C")) name="괭이";
	      else if(gubun.equals("d")||gubun.equals("D")) name="강아지";
	      return name;
	   }
	   
	
}
