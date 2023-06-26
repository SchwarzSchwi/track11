package b_if;

import java.util.Scanner;

public class J0109_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("성별? 남:1, 여:2");
		String gender = sc.next();
		System.out.print("체력지수?");
		int health = sc.nextInt();
		if(gender.equals("1")) {
			if(health>=75) {
				System.out.println("남자 정상");
			}else {
				System.out.println("남자 비정상");
			}
		}else if(gender.equals("2")) {
			if(health>=65) {
				System.out.println("여자정상");
			}else {
				System.out.println("여자 비정상");
			}
		}else {
			System.out.println("성별입력오류!!!!");
		}
		
				
		
		
		
		//남자는 체력지수 75이상이면 정상
		//여자는 체력지수 65이상이면 정상
		
		//출력 : 정상/비정상
	}

}
