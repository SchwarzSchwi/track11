package e_array;

import java.util.Scanner;

public class J0117_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 과목?");
		int subject = sc.nextInt();
		int[] number = new int[subject+2];
		int total = 0;
		for(int k=0; k<subject; k++) {
			System.out.println("점수 몇?");
			number[k] = sc.nextInt();
			total = total + number[k];
		}
		number[subject]= total;
		int ave = total / subject;
		number[subject+1] = ave;
		for(int k=0; k<=subject+1; k++) {
			System.out.println(number[k]);
		}
	}

}
