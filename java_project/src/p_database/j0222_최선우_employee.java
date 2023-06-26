package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class j0222_최선우_employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		J0222_최선우_employee_dao dao = new J0222_최선우_employee_dao();
		int gubun = 0;
		do {
			System.out.print("조회[1], 등록[2], 수정[3], 삭제[4], 종료[0]?");
			gubun = sc.nextInt();
			if(gubun == 1) {
				System.out.print("전체[A], 사번[I], 성명[N], 부서[D], 직위[R]?");
				String searchGubun =sc.next();
				if (searchGubun.equals("A") || searchGubun.equals("a") || searchGubun.equals("ㅁ")){
					ArrayList<J0222_최선우_employee_dto> dtos = dao.getSearchList();
					dao.resultPrint(dtos);
				}else if (searchGubun.equals("I") || searchGubun.equals("i") || searchGubun.equals("ㅑ")) {	
					System.out.print("사번?"); //2
					String id = sc.next();
					
					ArrayList<J0222_최선우_employee_dto> dtos = dao.getSearchList("id",id);
					dao.resultPrint(dtos);
					
				}else if (searchGubun.equals("N") || searchGubun.equals("n") || searchGubun.equals("ㅜ")) {
					System.out.print("성명?"); 
					String name = sc.next();
					
					ArrayList<J0222_최선우_employee_dto> dtos = dao.getSearchList("name",name);
					dao.resultPrint(dtos);
					
				}else if (searchGubun.equals("D") || searchGubun.equals("d") || searchGubun.equals("ㅇ")) {		
					System.out.print("부서명?");
					String depart = sc.next();
					
					ArrayList<J0222_최선우_employee_dto> dtos = dao.getSearchList("depart",depart);
					dao.resultPrint(dtos);
				}else if (searchGubun.equals("R") || searchGubun.equals("r") || searchGubun.equals("ㄱ")) {		
					System.out.print("직위?");
					String rank = sc.next();
					
					ArrayList<J0222_최선우_employee_dto> dtos = dao.getSearchList("rank", rank);
					dao.resultPrint(dtos);
				}
			}else if(gubun == 2) {
				System.out.print("사번?");
				String id = sc.next();
				
				int count = dao.checkId(id);
				if(count ==1) {
					System.out.println("중복된id");
				}else {
				
				System.out.print("성명");
				String name = sc.next();
				System.out.print("부서");
				String depart = sc.next();
				System.out.print("직위");
				String rank = sc.next();
				System.out.print("나이");
				int age = sc.nextInt();
				J0222_최선우_employee_dto dto =
						new J0222_최선우_employee_dto(id, name, depart, rank, age);
//				int result = dao.employeeSave(dto);
				int result = dao.employeeSave(id,name,depart,rank,age);
				if(result == 1)System.out.println("등록성공");
				else System.out.println("등록실패");
				}
				
			}else if(gubun == 3) {
//				수정
				System.out.print("수정id");
				String id = sc.next();
				
				J0222_최선우_employee_dto dto = dao.getEmployeeInfo(id);
				if(dto == null) {
					System.out.println("정보없음!");
				}else {
					dao.resultPrintDto(dto);
					System.out.println("수정하겠습니까? 예[y], 아니오[n]");
					String yn = sc.next();
					if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
						System.out.print("성명");
						String name = sc.next();
						System.out.print("부서");
						String depart = sc.next();
						System.out.print("직위");
						String rank = sc.next();
						System.out.print("나이");
						int age = sc.nextInt();
						
						J0222_최선우_employee_dto updateDto = new J0222_최선우_employee_dto(id, name, depart, rank, age);
						int result = dao.employeeUpdate(updateDto);
						
						if(result ==1)System.out.println("수정성공");
						else System.out.println("수정실패");
					}
				}
				
			}else if(gubun == 4) {
				System.out.println("삭제 ID?");
				String id = sc.next();
				J0222_최선우_employee_dto dto = dao.getEmployeeInfo(id);
				if(dto == null) {
					System.out.println("정보없음");
				}else {
					dao.resultPrintDto(dto);
					System.out.println("삭제? 예[y], 아니오[n]");
					String yn = sc.next();
					if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
						int result = dao.employeeDelete(id);
						
						if(result == 1)System.out.println("삭제성공");
						else System.out.println("삭제 실패");
						
					}
				}
			}
		}while(gubun != 0);
		System.out.println("시스템 종료");
	}

}
