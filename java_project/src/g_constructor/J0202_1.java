package g_constructor;

import java.util.Scanner;

public class J0202_1 {

	public static void main(String[] args) {
		
		String str = "가나다라마";
		int position = str.indexOf("나다");
		System.out.println("position : "+position);
		
		Scanner sc = new Scanner(System.in);
		J0202_dto[] arr = new J0202_dto[2];
		J0202_dao dao = new J0202_dao();
		
		for(int k=0; k<arr.length; k++) {
			System.out.println("number?");
			String number = sc.next();
			System.out.println("name?");
			String name = sc.next();
			System.out.println("depart? 총무 : c, 재무 : j, 영업? : y");
			String depart = sc.next();
			System.out.println("rank? 사원 : 10, 대리 : 20, 과장? : 30");
			String rank = sc.next();
			
			depart = dao.getDepartName(depart);
			rank = dao.getRankName(rank);
			int salary = dao.getSalary(depart, rank);
			
			J0202_dto dto = new J0202_dto(number, name, depart, rank, salary);
			arr[k] = dto;
		}
		
		dao.setPrint(arr);
		
		System.out.println("----------------------------------");
		System.out.print("search name?");
		String search = sc.next();
		dao.searchData(arr, search);
		
				
			
	}

}
