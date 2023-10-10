package g_constructor;

import java.util.Scanner;

public class J0201_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0201_dao dao = new J0201_dao();
		
		System.out.println(dao.getAreaName("s"));
		
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
		System.out.println("name : "+dto.getName());
		System.out.println("area : "+dto.getArea());
		System.out.println("age : "+dto.getAge());
		System.out.println("edu : "+dto.getEdu());
	}

}
