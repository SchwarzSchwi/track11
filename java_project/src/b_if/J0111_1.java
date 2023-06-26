package b_if;

import java.util.Scanner;

public class J0111_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//12월 ~ 2월 겨울
		//3월~5월 봄
		//6~8여름
		//9~11가을
		System.out.print("몇 월 입니까");
		String month = sc.next();
		String season="";
		if(month.equals("12") || month.equals("1") || month.equals("2")) 
			season = "겨울";
		else if(month.equals("3") || month.equals("4") || month.equals("5"))
			season = "봄";
		else if(month.equals("6") || month.equals("7") || month.equals("8"))
			season = "여름";
		else if(month.equals("9") || month.equals("10") || month.equals("11"))
			season = "가을";
		else season = "입력오류";
		System.out.println("계절 : "+season);
	}

}
