package d_repeat;

import java.util.Scanner;

public class J0111_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 단?");
		int dan = sc.nextInt(); 
		for(int k=1 ; k<=9 ; k++) {
			System.out.println(dan+"*"+k+"="+(dan*k));
		}
	}

}
