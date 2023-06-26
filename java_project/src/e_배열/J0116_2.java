package e_배열;

import java.util.Scanner;

public class J0116_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("How many?");
		int count = sc.nextInt();
		int[] a = new int[3];
		
		String[] name = new String[count];
		for(int k=0; k<count;k++) {
			System.out.print((k+1)+"번째성 명?");
			name[k] = sc.next();
		}
		for(int k=0; k<count; k++) {
			System.out.println("성명 : "+name[k]);
		}
	}

}
