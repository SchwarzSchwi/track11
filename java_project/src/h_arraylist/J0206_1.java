package h_arraylist;

import java.util.ArrayList;

public class J0206_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] arr = new String[2];
//		arr[0] = "홍길동";
		ArrayList<String> arr = new ArrayList<>();
		arr.add("정향재");
		arr.add("배정열");
		arr.add("신민철");
		arr.add(1, "안증환");
		arr.add("이성계");
		arr.set(0, "임종승");
		arr.remove(0);
		for(int k=0; k<arr.size(); k++) {
			System.out.println(arr.get(k));
		}
		
		ArrayList<Integer> in = new ArrayList<>();
		in.add(10);
		in.add(20);
		in.add(30);
		for(int k=0; k<in.size(); k++) {
			System.out.println(in.get(k));
		}
		
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println(arr.get(3));
		
	}

}
