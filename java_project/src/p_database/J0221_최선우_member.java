package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0221_최선우_member {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0221_최선우_dao dao = new J0221_최선우_dao();
		int gubun = 0;
		do {
			System.out.print("검색: 전체[1], ID[2], 성명[3], 등록[4], 수정[5], 삭제[6], 종료[0]");
			gubun = sc.nextInt();
			//전체조회
			if(gubun == 1) {
				ArrayList<J0221_최선우_dto> dtos =
						dao.getSearchList("id", "");
				dao.resultPrint(dtos);	
				//성명검색	
			}else if(gubun == 2) {
				System.out.println("검색ID?");
				String id = sc.next();
				ArrayList<J0221_최선우_dto> dtos =
						dao.getSearchList("id", id);
				dao.resultPrint(dtos);
				//지역검색
			}else if (gubun == 3) {
				System.out.println("검색 성명?");
				String name = sc.next();
				ArrayList<J0221_최선우_dto> dtos =
						dao.getSearchList("name", name);
				dao.resultPrint(dtos);
				//등록
			}else if (gubun == 4) {
				System.out.print("ID?");
				String id = sc.next();
				
				if(id.length() != 3) {
					System.out.println("ID 입력오류");
					continue;
				}
				System.out.print("성명");
				String name = sc.next();
				if(name.length() > 6) {
					System.out.println("성명입력오류");
					continue;
				}
				System.out.print("지역");
				String area = sc.next();
				if(area.length() > 6) {
					System.out.println("지역입력오류");
					continue;
				}
				int age = 0;
				System.out.print("나이");
				try {
					age = sc.nextInt();
				}catch(Exception e) {
					age = -1;
				}
					
				J0221_최선우_dto dto =
						new J0221_최선우_dto(id, name, area, age);
				
				int yn = dao.saveMember(dto);
				
				if(yn == 1)System.out.println("등록되었습니다.");
				else System.out.println("등록실패");
				
				
				//수정
			}else if (gubun == 5) {
				System.out.print("수정 ID");
				String id = sc.next();
				if(id.length() != 3) {
					System.out.println("ID 입력오류. 3자리 입력!");
				}else {
					J0221_최선우_dto dto = dao.getMemberInfo(id);
					if(dto == null) {
						System.out.println("ID정보없음!");
					}else {
						ArrayList<J0221_최선우_dto>dtos = new ArrayList<>();
						dtos.add(dto);
						dao.resultPrint(dtos);
						System.out.print("수정하시겠습니까? 예[y], 아니오[n]:");
						String yn = sc.next();
						if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ"));
							System.out.print("성명?");
							String name = sc.next();
							System.out.print("지역?");
							String area = sc.next();
							System.out.print("나이");
							int age = sc.nextInt();
							J0221_최선우_dto dto2 = new J0221_최선우_dto(id, name, area, age);
							int updateResult = dao.updateResult(dto2);
							if(updateResult == 1) {
								System.out.println("수정성공");
							}else {
								System.out.println("수정실패");
							}
					}
				}
				//삭제
			}else if (gubun == 6) {
				System.out.print("삭제 ID");
				String id = sc.next();
				J0221_최선우_dto dto = dao.getMemberInfo(id);
				if(dto == null) {
					System.out.println("정보없음!");
				}else {
					ArrayList<J0221_최선우_dto> dtos = new ArrayList<>();
					dtos.add(dto);
					dao.resultPrint(dtos);
					System.out.print("삭제? 예[y], 아니오[n]");
					String yn = sc.next();
					if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
						int result = dao.deleteMember(id);
						if(result == 1) {
							System.out.println("삭제 성공!");
						}else {
							System.out.println("삭제 실패!");
						}
					}
				}
			}
		}while(gubun != 0);
		System.out.println("시스템 종료!");
	}
}
