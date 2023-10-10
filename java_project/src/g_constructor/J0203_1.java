package g_constructor;

import java.util.Scanner;

public class J0203_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0203_dao dao = new J0203_dao();
		System.out.println("how many?");
		int count = sc.nextInt();
		J0203_dto[] arr = new J0203_dto[count];
		
		for (int k = 0; k < arr.length; k++) {
			System.out.println("name?");
			String name = sc.next();
			System.out.println("gender : male=m, femail=f");
			String gender = sc.next();
			System.out.println("age?");
			int age = sc.nextInt();

			gender = dao.getGenderName(gender);
			int money = dao.getMoney(gender, age);
			J0203_dto dto = new J0203_dto(name, gender, age, money);
			arr[k] = dto;

		}
	
		System.out.println("---------------------");
		
		for(int k = 0; k < arr.length; k++) {
			System.out.print(arr[k].getName()+"\t");
			System.out.print(arr[k].getGender()+"\t");
			System.out.print(arr[k].getAge()+"\t");
			System.out.print(arr[k].getMoney()+"\n");
		}	
		
	}

}
