package h_arraylist;

import java.util.Scanner;
import java.util.ArrayList;

public class J0207_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		J0207_4_dao dao = new J0207_4_dao();
		ArrayList<J0207_4_dto> arr = new ArrayList<>();
		
		System.out.println("count?");
		int count = sc.nextInt();
		
		for (int k = 0; k < count; k++) {
			System.out.print("id");
			String id = sc.next();
			System.out.print("name");
			String name = sc.next();
			System.out.print("age");
			int age = sc.nextInt();
			System.out.print("depart [총무:10, 재무:20, 영업:30]");
			String depart = sc.next();
			System.out.print("rank[사원 : s, 대리 : d, 과장 : g]");
			String rank = sc.next();

			J0207_4_dto dto1 = new J0207_4_dto(id, name, age, depart, rank);

			arr.add(dto1);
		
		}
		for(int k=0; k<arr.size(); k++) {
			System.out.print(arr.get(k).getId());
			System.out.print(arr.get(k).getName());
			System.out.print(arr.get(k).getAge());
			System.out.print(dao.getDepart());
			System.out.println(dao.getRank());
		}
	}

}
