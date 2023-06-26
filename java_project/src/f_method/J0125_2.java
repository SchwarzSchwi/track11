package f_method;

import java.util.Scanner;

public class J0125_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		J0125_2_sub sub = new J0125_2_sub();
		System.out.print("korean?");
		int kor = sc.nextInt();
		System.out.print("english?");
		int eng = sc.nextInt();
		System.out.print("math?");
		int mat = sc.nextInt();
		
		int    total 	= sub.getTotal(kor, eng, mat);
		double ave 		= sub.getAve(total, 3);
		String result 	= sub.getResult(ave);	
	}

}
