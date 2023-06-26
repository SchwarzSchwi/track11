package e_배열;

import java.util.Scanner;

public class J0113_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = {12,45,14,75,86,49,12,56,45,85,23,62,45,78,95,45,26,78,64,68,54,55,85};
		int num = 0;
		int total = 0;
		for(int k=0; k<arr.length; k++) {
			if(arr[k]<=50 && arr[k]>=0) {
				num++;
				total = total + arr[k];
//				num += 1
//				num = num +1		
			}
		}
		System.out.println(num);
		System.out.println(total);
	}

}
