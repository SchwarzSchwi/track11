package f_method;

import java.util.Scanner;

public class J0125_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		J0125_3_sub sub = new J0125_3_sub();
		
		System.out.print("기본 급여?");
		int basic = sc.nextInt();
		System.out.print("남여? 남 : 1 여 : 2");
		String gender = sc.next();
		
		int pay = sub.getPay(basic, gender);
	}

}
