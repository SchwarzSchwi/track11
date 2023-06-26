package b_if;

import java.util.Scanner;

public class J0109_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int kor = sc.nextInt();
		System.out.print(kor);
		int eng = sc.nextInt();
		System.out.print(eng);
		int mat = sc.nextInt();
		System.out.print(mat);
		
		int total = kor+eng+mat;
		int ave = total / 3;
		String point = "";
		if (ave>=0 && ave<=100) {
			if (ave>=90)
				 point = "A";
			else if(ave>=80)
				 point = "B";
			else if(ave>=70)
				 point = "C";
			else
				 point = "F";
		}else {System.out.print("입력오류입니다");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		System.out.print("국어점수");
		String kor = sc.next();
		System.out.print("영어점수");
		String eng = sc.next();
		System.out.print("수학점수");
		String mat = sc.next();
		
		String total = Integer.toString(
				    Integer.parseInt(kor)+
				    Integer.parseInt(eng)+
				    Integer.parseInt(mat));
		int ave = Integer.parseInt(total) / 3;
		String result = "";
		if(ave <=100 && ave>=0) {
			if (ave>=90) {
			result = "A";
			}else if (ave>=80) {
			result = "B";
			}else if (ave>=70) {
			result = "C";
			}else result = "F";
		}else
			System.out.print("입력오류입니다");
		System.out.print("총점 :"+total);
		System.out.print("평균 :"+ave);
		System.out.print("결과 :"+result);
*/	
	}

	}}
