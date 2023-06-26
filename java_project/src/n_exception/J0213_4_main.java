package n_exception;

import java.util.Scanner;

public class J0213_4_main {

	public static void main(String[] args) {
		J0213_4_sub sub = new J0213_4_sub();
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("kor?");
//		String kor = sc.next();
//		System.out.print("eng?");
//		String eng = sc.next();
//		
		String kor = "90";
		String eng = "80";
		
		int total = sub.getTotal(kor, eng);
		System.out.println("total : "+total);
		
		int ave=0;
		try {
			ave = sub.getAve(total, "2kkk");
		} catch (Exception e) {
//			e.printStackTrace();
		}
		System.out.println("ave : "+ave);
		
		System.out.println("종료~~~");
	}

}
