package g_constructor;

import java.util.Scanner;

public class J0131_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0131_1_dao dao = new J0131_1_dao();
		System.out.println("count");
		int count = sc.nextInt();
		
		J0131_1_dto[] arr = new J0131_1_dto[count];
		
		for(int k=0; k<arr.length; k++) {
			System.out.print("name?");
			String name = sc.next();
			System.out.print("korean?");
			int kor = sc.nextInt();
			System.out.print("english?");
			int eng = sc.nextInt();
			System.out.print("math?");
			int mat = sc.nextInt();
			J0131_1_dto dto = new J0131_1_dto(name,kor,eng,mat);
			dao.setTotal(dto);
			dao.setAve(dto);
			arr[k] = dto;
		}
		//출력
		dao.dtoArrPrint(arr);
		
//		for(int k=0; k<arr.length; k++) {
//			System.out.println("name : "+arr[k].getName());
//			System.out.println("total : "+arr[k].getTotal());
//			System.out.println("average : "+arr[k].getAve());
//		}
	}

}
