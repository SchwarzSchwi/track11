package g_생성자;

import java.util.Scanner;

public class J0201_3 {

	public static void main(String[] args) {
		
		J0201_dao dao = new J0201_dao();
		J0201_dto[] arr = new J0201_dto[2];
		Scanner sc = new Scanner(System.in);
		
		for(int k=0; k<arr.length; k++) {
			System.out.println("name?");
			String name = sc.next();
			System.out.println("area?");
			String area = sc.next();
			System.out.println("education?");
			String edu = sc.next();
			System.out.println("age?");
			int age = sc.nextInt();
		
			J0201_dto dto = new J0201_dto(name, area, edu, age);
			arr[k] = dto;
		}
		dao.dtoPrint(arr);
	}

}
