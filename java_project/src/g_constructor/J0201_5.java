package g_constructor;

import java.util.Scanner;

public class J0201_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[3];
		for(int k=0; k<num.length; k++) {
			System.out.print("number");
			int var = sc.nextInt();
			num[k] = var;
		}
		for(int k=0; k<num.length; k++) {
			System.out.print(num[k]);
		}
	}

}
