package b_if;

import java.util.Scanner;

public class J0110_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("직업? 학생:1, 주부:2, 회사원:3");
		String job = sc.next();
		System.out.print("월납입액");
		int monthSave = sc.nextInt();
		System.out.print("몇 년?");
		int year= sc.nextInt();
		double money = monthSave * (year*12);
		if(job.equals("1")) {
			job= "학생";
			money = money+(money*0.2);	
			System.out.println("만기금액"+money+"원");
		}else if(job.equals("2")){
			job="주부";
			money = money+(money*0.1);
			System.out.println("만기금액"+money+"원");
		}else if(job.equals("3")) {
			job="회사원";
			money = money+(money*0.05);
			System.out.println("만기금액 : "+money+"원");
		}else System.out.print("입력오류입니다");
	}	
		
}
