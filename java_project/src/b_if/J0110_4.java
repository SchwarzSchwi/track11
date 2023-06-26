package b_if;

import java.util.Scanner;

public class J0110_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//학년 1~6 String
		//변수명
		//평균 int
		//1~2학년 평균 60점 이상 합격
		//3~4학년 평균 70이상 합격
		//5~6학년 평균 80이상 합격
		//3학년 합격
		System.out.println("학년?1,2,3,4,5,6");
		int grade = sc.nextInt();
		if(grade>=1 && grade<=6) {
			System.out.println("평균점수?");
			int ave = sc.nextInt();
			String result = "불합격";
			if(grade>=1 && grade<=3) {
				if(ave>=70) result ="합격";
			}else {
				if(ave>=80) result ="합격";
			}
			System.out.println(grade+"학년 "+result);
		}else {
			System.out.println("학년 입력 오류!");
		}
		
		
		
		
		
		
		
		
		
		
/*		int level = Integer.parseInt(grade);
		if(level>=1 && level<=6) {
		System.out.println("평균?");
		int ave = sc.nextInt();
		String result = "불합격";
		if(grade.equals("1")||grade.equals("2")) {
			if(ave>=60) result = "합격";
		}else if(grade.equals("3")||grade.equals("4")) {
			if(ave>=70) result = "합격";
		}else if(grade.equals("5")||grade.equals("6")){
			if(ave>=80)	result = "합격";
		}
		System.out.println(grade+"학년 "+result);	
		}else {
			System.out.println("학년입력오류");
		
		}
*/	}	
	
}
