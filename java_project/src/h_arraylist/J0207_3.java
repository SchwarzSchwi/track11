package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0207_3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0207_3_dao dao = new J0207_3_dao();
		System.out.println("count");
		int count = sc.nextInt();
		ArrayList<J0207_3_dto> arr = new ArrayList<>();
		for(int k=0; k<count; k++) {
			System.out.println("kind? d or c");
			String kind = sc.next();
			System.out.println("name?");
			String name = sc.next();
			System.out.println("height?");
			int height = sc.nextInt();
			System.out.println("weight?");
			int weight = sc.nextInt();
			
			J0207_3_dto dto = new J0207_3_dto();
			dto.setKind(dao.getName(kind));
			dto.setName(name);
			dto.setHeight(height);
			dto.setWeight(weight);
			
			arr.add(dto);
			
		}
	}
}
