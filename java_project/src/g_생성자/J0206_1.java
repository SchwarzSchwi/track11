package g_생성자;

import java.util.Scanner;

public class J0206_1 {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0206_member_dao dao = new J0206_member_dao();
		System.out.print("몇 명?");
		int count = sc.nextInt();
		J0206_member_dto[] arr = new J0206_member_dto[count];
		for(int k=0; k<arr.length; k++) {
			System.out.println("id?");
			String id = sc.next();
			System.out.println("name");
			String name = sc.next();
			System.out.println("height");
			double height = sc.nextDouble();
			System.out.print("weight");
			double weight = sc.nextDouble();
			
			String result = dao.getResult(weight, height);
			
			J0206_member_dto dto 
			= new J0206_member_dto(id, name, height, weight, result);
			
			arr[k] = dto;
		
		}
		System.out.println("================================");
		System.out.println("id\tname\theight\tweight\tresult");
		System.out.println("--------------------------------");
		for(int k=0; k<arr.length; k++) {
			System.out.print("id"+arr[k].getId()+"\t");
			System.out.print("name"+arr[k].getName()+"\t");
			System.out.print("height"+arr[k].getHeight()+"\t");
			System.out.print("weight"+arr[k].getWeight()+"\t");
			System.out.print("result"+arr[k].getResult()+"\t");
		}
	}

}
