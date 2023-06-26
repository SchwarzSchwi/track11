package b_if;

import java.util.Scanner;

public class J0106_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("남,여?");
		String gender = sc.next();
		
		System.out.print("나이?");
		int age = sc.nextInt();
		
//		 "남" 이고 나이 20살 이상이면
		if(gender.equals("남") && age >=20){
			System.out.println("100만원");
		}
 
//		"남" 이거나 나이 20살 이상이면 => 50만원
		if(gender.equals("남") || age >=20){
			System.out.println("50만원");
		}		
				
				
	}

}


