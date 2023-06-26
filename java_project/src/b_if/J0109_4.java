package b_if;

import java.util.Scanner;

public class J0109_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수?");
		int first = sc.nextInt();
		System.out.print("연산자?");
		String sign = sc.next();
		System.out.print("두번째 수?");
		int second = sc.nextInt();
		int result = 0;
		if(sign.equals("+")) {
			result=first+second;		
		}else if(sign.equals("-")){
			result=first-second;
		}else if(sign.equals("*")){ 	
			result=first*second;
		}else if(sign.equals("/")){
			result=first/second;
		}else {
			System.out.println("연산자 입력오류");
		}
		System.out.println("결과: "+result);
		
		
	}

}
