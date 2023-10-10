package e_array;

import java.util.Scanner;

public class E_practice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {12,45,14,75,86,49,12,56,45,85,23,62,45,78,95,45,26,78,64,68,54,55,85};
		int total = 0;
		int count = 0;
		for(int k=0; k < arr.length; k++) {
			total = total + arr[k];
			if (arr[k]/arr[k] == 1) {
				count += 1;
			}
			
		}
		System.out.println(total);
		System.out.println(count);
	}
}