package d_repeat;

import java.util.Scanner;

public class J0111_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int total = 0;
		for(int k=1 ; k<=5 ; k++) {
			System.out.println("숫자 몇");
			int num = sc.nextInt();
			if (num==0) break;
			total = total + num;
		}
		System.out.println("total : "+total);
	}

}
