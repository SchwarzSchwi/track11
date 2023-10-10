package g_constructor;

import java.util.Scanner;

public class J0131_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("name?");
		String name = sc.next();
		System.out.print("korean?");
		int kor = sc.nextInt();
		System.out.print("english?");
		int eng = sc.nextInt();
		System.out.print("math?");
		int mat = sc.nextInt();
		
		J0131_1_dao dao = new J0131_1_dao();
//		String name = "choiseonwoo";
//		int kor=50, eng=60, mat=70;
		
		J0131_1_dto dto = 
				dao.getDto(name,kor,eng,mat);
		if(true) {
			int kkk= 60;
			mat = 60;
		}
		dao.setTotal(dto);
		dao.setAve(dto);
		dao.dtoPrint(dto);
//		System.out.println(" name : "+dto.getName());
//		System.out.println(" total : "+dto.getTotal()); 
//		System.out.println(" average : "+dto.getAve());
	}

}
