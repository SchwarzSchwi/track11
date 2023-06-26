package b_if;

import java.util.Scanner;

public class j0111_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("성명?");
		String name = sc.next();
		System.out.println("학년?");
		int grade = sc.nextInt();
		if(grade <= 6 && grade > 0) {
			System.out.println("국어?");
			int kor = sc.nextInt();
			if(kor <= 100 && kor >= 0) {
				System.out.println("영어?");
				int eng = sc.nextInt();
				if(eng <= 100 && eng >= 0) {
					System.out.println("수학?");
					int mat = sc.nextInt();
					if(mat <= 100 && mat >= 0) {
						double ave = ( kor + eng + mat ) / 3;
						String result = "";
						if(grade >= 1 && grade <= 3) {
							if(ave >= 70 && ave <= 100) result = "합격";
							else if (ave < 70 && ave >= 0) result = "불합격";
						}else if(grade >=4 && grade <= 6) {
							if(ave >= 80 && ave <= 100) result = "합격";
							else if (ave < 80 && ave >= 0) result = "불합격";
						}else System.out.println("입력오류입니다"); 
						System.out.println("성명 : "+name);
						System.out.println("학년 : "+grade);
						System.out.println("평균 : "+ave);
						System.out.println("결과 : "+result);
					}else System.out.println("점수를 잘못 입력하셨습니다");
				}else System.out.println("점수를 잘못 입력하셨습니다"); 	
			}else System.out.println("점수를 잘못 입력하셨습니다");	
		}else System.out.println("학년을 잘못 입력하셨습니다");	
		
	}

}
