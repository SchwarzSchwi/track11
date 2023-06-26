package f_method;

import java.util.Scanner;

public class J0119_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J0119_1_sub sub = new J0119_1_sub();
		Scanner sc = new Scanner (System.in);
		
		String pass = sub.getPass(100);
		System.out.println(pass);
		String re = sub.getNoodle(100);
		System.out.println(sub.getNoodle(100));
		String name = sub.getName();
		int point = sub.getPoint();
		String kor = sub.getKor();
		String eng = sub.getEng();
		boolean tf = sub.getTrue();
		System.out.println(name);
		System.out.println(point);
		
	}

}
