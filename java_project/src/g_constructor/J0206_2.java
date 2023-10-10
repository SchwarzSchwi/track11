package g_constructor;

import java.util.Scanner;

public class J0206_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0206_2_dao dao = new J0206_2_dao();
		System.out.print("count?");
		int count = sc.nextInt();
		
		J0206_2_dto[] arr = new J0206_2_dto[count];
		for(int k=0; k<arr.length; k++) {
			System.out.println("id?");
			String id = sc.next();
			System.out.println("name?");
			String name = sc.next();
			System.out.print("kor?");
			int kor = sc.nextInt();
			System.out.print("eng?");
			int eng = sc.nextInt();
			System.out.print("math?");
			int mat = sc.nextInt();
			
			double ave = dao.getAverage(kor, eng, mat);
			String res = dao.getResult(kor, eng, mat, ave);
			J0206_2_dto dto 
			= new J0206_2_dto(id, name, kor, eng, mat, ave, res);
			
			arr[k] = dto;
		}	
		System.out.println("===================================");
		for(int k=0; k<arr.length; k++) {
			System.out.println("id"+arr[k].getId());
			System.out.println("name"+arr[k].getName());
			System.out.println("kor"+arr[k].getKor());
			System.out.println("eng"+arr[k].getEng());
			System.out.println("mat"+arr[k].getMat());
			System.out.println("ave"+arr[k].getAverage());
			System.out.println("res"+arr[k].getResult());
		}
					
	}

}
