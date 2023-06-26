package e_배열;

import java.util.Scanner;

public class J0116_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String search = sc.next();
		// TODO Auto-generated method stub
		 String[] name = { "이상민", "박만수", "이찬우", "김성식", "김지우", 
                 "김인수", "안상수", "이미옥", "백현수", "이찬우", 
                 "허상수", "김이우", "김미순",   "허정우", "임민수", 
                 "윤석민", "안태정", "최순실", "송민수", "강유현", 
                 "강민기", "신강식", "허준용", "김형수", "안강현" };
		 int num = 0;
		 for(int k=0; k<name.length; k++) {
			 if(name[k].indexOf("김") != -1) num = num+1;
			 if(name[k].indexOf("김") == 1 ||name[k].indexOf("김") == 2) num = num - 1;
			 
		 }
		 System.out.println("숫자 : "+num);
		 
		 String a = "abcdefg";
			int in = a.indexOf("e");
			System.out.println(in);
			
		
	}

}
