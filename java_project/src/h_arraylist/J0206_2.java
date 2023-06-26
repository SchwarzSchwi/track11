package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0206_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<>();
		System.out.println("count");
		int count = sc.nextInt();
		for(int k=0; k<count; k++) {
			System.out.print("name?");
			String name = sc.next();
			arr.add(name);
		}
		for(int k=0; k<arr.size(); k++) {
			System.out.println(arr.get(k));
		}
		
		
	}
}
