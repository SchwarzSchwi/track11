package g_생성자;

import java.util.Scanner;

public class J0201_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0201_dao dao = new J0201_dao();
		System.out.println("count?");
		int count = sc.nextInt();
		
		J0201_dto[] arr = new J0201_dto[count];
		
		for(int k = 0; k<arr.length; k++) {
			System.out.println("name?");
			String name = sc.next();
			System.out.println("age?");
			int age = sc.nextInt();
			System.out.println("area? seoul : s, Daejeon : d, Chungju : c, busan : b");
			String area = sc.next();
			System.out.println("education? middle school : M, high school : H, University : U");
			String edu = sc.next();
			
			area = dao.getAreaName(area);
			edu = dao.getEduName(edu);
			J0201_dto dto = new J0201_dto(name, area, edu, age);
			arr[k] = dto;
		}
		for(int k = 0; k<arr.length; k++) {
			System.out.print("name : "+arr[k].getName());
			System.out.print("area : "+arr[k].getArea());
			System.out.print("age : "+arr[k].getAge());
			System.out.print("education : "+arr[k].getEdu()+"/n");
		}
	}

}
