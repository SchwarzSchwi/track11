package e_array;

import java.util.Scanner;

public class J0118_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] score = new int[2][3];
		for(int k=0; k<score.length; k++){
			for(int j=0; j<score[k].length; j++) {
				System.out.print("number?");
				score[k][j] = sc.nextInt();
			}		
		}
		for(int k=0; k<score.length; k++) {
			for(int j=0; j<score[k].length; j++) {
				System.out.print(score[k][j]);
			}
			System.out.print("\n");
		}
	}

}
