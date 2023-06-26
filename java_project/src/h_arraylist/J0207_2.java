package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;
public class J0207_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<J0207_1_dto> dtos = new ArrayList<>();
		System.out.print("count?");
		int count = sc.nextInt();
		for(int k = 0; k<count; k++) {
			System.out.print("id?");
			String id = sc.next();
			System.out.print("name?");
			String name = sc.next();
			System.out.print("area?");
			String area = sc.next();
			System.out.print("age?");
			int age = sc.nextInt();
			
			J0207_1_dto dto=
					new J0207_1_dto(id, name, area, age);
			dtos.add(dto);
		}
		for(int k=0; k<dtos.size(); k++) {
			System.out.print(dtos.get(k).getId());
			System.out.print(dtos.get(k).getName());
			System.out.print(dtos.get(k).getArea());
			System.out.print(dtos.get(k).getAge());
		}
	}

}
