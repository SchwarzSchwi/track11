package b_if;

import java.util.Scanner;

public class J0110_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("직업?학생:1, 주부:2, 회사원:3");
		String job = sc.next();
		int money = 500000;
		if(job.equals("1")) {
			money = money + 100000;
			job = "학생";
		}if(job.equals("2")) {
			money = money + 300000;
			job= "주부";
		}if(job.equals("3")) {
			money = money + 400000;
			job= "회사원";
		}System.out.println(job+":"+money);
		//기본 생활비 500000
		//학생 = 기본 + 100000
		//주부= 기본 + 300000
		//회사원= 기본+400000
		//출력 학생 : 600000
		
	}

}
