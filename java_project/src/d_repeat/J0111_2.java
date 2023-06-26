package d_repeat;

import java.util.Scanner;

public class J0111_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);	
		System.out.println("몇 단 부터?");
		int start = sc.nextInt();
		System.out.println("몇 단 까지??");
		int end = sc.nextInt();
		for(int k=start ; k<=end ; k++) {
			for(int j=1 ; j<=9 ; j++){
				System.out.println(k+"*"+j+"="+k*j);
			}
		System.out.println("둠칫");
		}
		
		
		
	}

}
