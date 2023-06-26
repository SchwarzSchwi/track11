package b_if;

import java.util.Scanner;

public class J0111_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 월입니까");
		int month = sc.nextInt();
		
		String season = "";
		if(month ==12 || month == 1 || month ==2) {
			season="겨울";
		}else if(month >=3 && month<=5) {
			season="봄";
		}else if(month >=6 && month<=8) {
			season="여름";
		}else if(month >=9 && month<=11) {
			season="가을";
		}else season="입력오류";
			
		System.out.println("계절 : "+season);	
	}

}
