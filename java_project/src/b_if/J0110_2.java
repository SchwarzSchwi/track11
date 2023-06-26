package b_if;

import java.util.Scanner;

public class J0110_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("기본 생활비?");
		int basic = sc.nextInt();
		
		System.out.print("직업? 학생:1, 주부:2, 회사원:3");
		String job = sc.next();
		if (job.equals("1")) {
			basic = basic + 100000;
			job = "학생";
			System.out.println(job+":"+basic);	
		}if(job.equals("2")) {
			basic = basic + 300000;
			job = "주부";
			System.out.println(job+":"+basic);	
		}if(job.equals("3")) {
			basic = basic + 400000;
			job = "회사원";
			System.out.println(job+":"+basic);	
		}else System.out.println("입력오류입니다");
		
	}

}
