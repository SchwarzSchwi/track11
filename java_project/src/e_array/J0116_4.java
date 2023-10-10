package e_array;

import java.util.Scanner;

public class J0116_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("how many?");
		int subject = sc.nextInt();
		
		int[] score = new int[subject];
		for(int k=0; k < subject ; k++) {
			System.out.print((k+1)+"번째 점수?");
			score[k] = sc.nextInt();	
		}
		System.out.println("-----------------");
		for(int k=0; k<subject; k++) {
			System.out.print(score[k]+"\t");
		}
	}

}
