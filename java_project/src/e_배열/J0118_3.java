package e_배열;

import java.util.Scanner;

public class J0118_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 명?");
		int count = sc.nextInt();
		System.out.print("몇 과목?");
		int array = sc.nextInt();
		
		String[][] str = new String[count][array];
		for(int k=0; k<str.length; k++) {
			for(int j=0; j<str[k].length; j++) {
				if(j==0) System.out.print("성명?");
				else if(j==1) System.out.print("점수");
				else if(j==2) System.out.print("나이?");
					str[k][j] = sc.next();
			}
		}
		for(int k=0; k<str.length; k++) {
			for(int j=0; j<str[k].length; j++) {
				System.out.print(str[k][j]+"\t");
			}
			System.out.print("\n");
		}
	}

}
