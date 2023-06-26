package c_switch;

import java.util.Scanner;

public class J0111_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 월 입니까?");
		String month = sc.next();
		
		int mon = Integer.parseInt(month);
		
		String sea="";
		switch(mon) {
			case 12: case 1: case 2:
				sea = "겨울";
				break;
			case 3: case 4: case 5:
				sea = "봄";
				break;
			case 6: case 7: case 8:
				sea = "여름";
				break;
			case 9: case 10: case 11:
				sea = "가을";
				break;
			default:
				sea = "입력오류";
		}
		
		
		
		String season ="";
		switch(month) {
			case "1": case "2": case "12":
				season="겨울";
				break;
			case "3": case "4": case "5":
				season="봄";
				break;
			case "6": case "7": case "8":
				season="여름";
				break;
			case "9": case "10": case "11":
				season="가을";
				break;
			default:
				season="입력오류";
		}
		System.out.println("계절: "+season);
		
		
	}

}
