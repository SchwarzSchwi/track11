package d_repeat;

import java.util.Scanner;

public class J0111_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 부터");
		int start = sc.nextInt();
		System.out.print("몇 까지");
		int end = sc.nextInt();
		int total = 0;
		for(int k=start ; k<=end ; k++) {
			total += k;
		}
		System.out.println("total:"+total);
	}

}
