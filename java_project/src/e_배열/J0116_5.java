package e_배열;

import java.util.Scanner;

public class J0116_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Subject");
		int subject = sc.nextInt();
		int[] score = new int[subject];
		int total=0;
		for(int k=0; k<subject; k++) {
			System.out.print((k+1)+"번째 점수");
			score[k] = sc.nextInt();
			total = total + score[k];
		}
		for(int k=0; k<score.length; k++)
			System.out.print(score[k]+"\t");
			System.out.print(total+"\t");
	}

}
