package d_repeat;

import java.util.Scanner;

public class J0112_dowhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int gubun = 0;
		do{
			System.out.print("선택 : 검색[1], 등록[2], 수정[3], 종료[0]");
			gubun =sc.nextInt();
			System.out.print("gubun"+gubun);
		}while(gubun != 0);
		System.out.println("종료~~~");
	}

}
