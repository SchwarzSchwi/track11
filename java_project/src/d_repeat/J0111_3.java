package d_repeat;

import java.util.Scanner;

public class J0111_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 부터");
		int start = sc.nextInt();
		System.out.println("몇 까지?");
		int end = sc.nextInt();
		//짝수만 출력
		int jjack = 0;
		for(int k = start ; k<= end ; k++) {
			
			if(k%2==0){ 
				System.out.println(k);
				jjack = jjack + 1;
				//jjack += 1
				//jjack++
			}
			//System.out.println(" jjack : "+jjack);
		}
		System.out.println("짝수 : "+jjack);
	}

}
