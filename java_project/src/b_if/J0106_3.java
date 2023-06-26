package b_if;

import java.util.Scanner;

public class J0106_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner	sc = new Scanner(System.in);
		System.out.println("몇 학년?");
		int grade = sc.nextInt();
		if(grade >= 7 || grade<1) {
			 System.out.println("입력오류");
		 }else {
		System.out.println("몇 점?");}
		int score = sc.nextInt();
	 if(grade >= 7 || score>100 || score<0) {
		 System.out.println("입력오류");
	 }	 else {
	 
		if(grade<=3){
			if(score>=70) {
				System.out.println(grade+"학년 "+score+"점 "+"합격");
			}
		}
		if(grade>=4) {
			if(score>=80) {
				System.out.println(grade+"학년 "+score+"점 "+"합격");
			}
		}
		if(grade<=3) {
			if(score<70) {
				System.out.println(grade+"학년 "+score+"점 "+"불합격");
			}
		}
		if(grade>=4) {
			if(score<80) {
				System.out.println(grade+"학년 "+score+"점 "+"불합격");
			}
		}
		if(grade<1 || grade>6 || score<0 || score>100) {
			System.out.println("입력오류");
		}
		
	 }
	
	}

}
