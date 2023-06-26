package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0216_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0216_student_dao dao = new J0216_student_dao();
		ArrayList<J0216_student_dto> dtos =
				dao.getStudentList();
//		새로시작
		dao.resultPrint(dtos);

		int gubun = 0;
		do {
			System.out.print("검색 전체[1] ID[2], 성명:[3], 등록[4], 수정[5], 삭제[6], 종료[0]?");
			gubun = sc.nextInt();
			
			if (gubun == 1) {
				ArrayList<J0216_student_dto> arr = 
						dao.getSearchList("id", "");
				dao.resultPrint(arr);
			}
			else if (gubun == 2) {
				System.out.println("검색ID?");
				String id = sc.next();
				ArrayList<J0216_student_dto> arr = 
						dao.getSearchList("id", id);
				dao.resultPrint(arr);
			}else if (gubun == 3) {
				System.out.print("검색 성명?");
				String name = sc.next();
				ArrayList<J0216_student_dto> arr = 
						dao.getSearchList("name", name);
				dao.resultPrint(arr);

			}else if (gubun == 4) {
				System.out.print("ID?");
				String id = sc.next();
				
				if (id.length() != 3) {
					System.out.println("ID 입력오류");
					continue;
				}
				System.out.print("성명");
				String name = sc.next();
				if (name.length() > 6) {
					System.out.println("성명입력오류");
					continue;
				}
				int kor = 0, eng = 0, mat = 0;
				System.out.print("kor score?");
				try {
					kor = sc.nextInt();
				} catch (Exception e) {
					kor = -1;
				}
				if (kor > 100 || kor < 0) {
					System.out.println("점수입력 오류. 0~100사이");
					continue;
				}

				System.out.print("eng score?");
				try {
					eng = sc.nextInt();
				} catch (Exception e) {
					eng = -1;
				}
				if (eng > 100 || eng < 0) {
					System.out.println("점수입력 오류. 0~100사이");
					continue;
				}
				
				System.out.print("mat score?");
				try {
					mat = sc.nextInt();
				} catch (Exception e) {
					mat = -1;
				}
				if (mat > 100 || mat < 0) {
					System.out.println("점수입력 오류. 0~100사이");
					continue;
				}
				
				int total = dao.getTotal(kor, eng, mat);
				String result = dao.getResult(total);
				
				J0216_student_dto dto =
						new J0216_student_dto(id, name, kor, eng, mat, total, result);
				
				int yn = dao.saveStudent(dto);
				
				if(yn ==1) System.out.println("등록되었습니다.");
				else System.out.println("등록실패~");

			} else if (gubun == 5) {
				System.out.println("수정 ID?");
				String id = sc.next();
				if (id.length() != 3) {
					System.out.println("ID 3자리 입력");
				} else {
					J0216_student_dto dto = 
							dao.getStudentInfo(id);
					if (dto == null) {
						System.out.println("ID정보없음!");
					} else {
						ArrayList<J0216_student_dto> arr = new ArrayList<>();
						arr.add(dto);
						dao.resultPrint(arr);
						System.out.print("수정하겠습니까? 예[y], 아니오[n]");
						String yn = sc.next();
						if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
							System.out.print("성명?");
							String name = sc.next();
							System.out.print("국어점수?");
							int kor = sc.nextInt();
							System.out.print("영어점수?");
							int eng = sc.nextInt();
							System.out.print("수학점수?");
							int mat = sc.nextInt();
							int total = dao.getTotal(kor, eng, mat);
							String result = dao.getResult(total);
							
							J0216_student_dto dto2 = 
									new J0216_student_dto(id, name, kor, eng, mat, total, result);
							int updateResult = dao.updateStudent(dto2);
							if(updateResult == 1) {
								System.out.println("수정성공!");
							}else {
								System.out.println("수정실패!");
							}
							
						}
					}
				}
				
			}else if(gubun == 6) {
				System.out.print("삭제 ID");
				String id = sc.next();
				J0216_student_dto dto =
							dao.getStudentInfo(id);
				if(dto == null) {
					System.out.println("정보없음!");
				}else {
					ArrayList<J0216_student_dto> arr
									= new ArrayList<>();
					arr.add(dto);
					dao.resultPrint(arr);
					System.out.println("삭제? 예[y], 아니오[n]");
					String yn = sc.next();
					if(yn.equals("y") || yn.equals("Y") || yn.contentEquals("ㅛ")) {
						int result = dao.deleteStudent(id);
						if(result == 1) {
							System.out.println("삭제성공!");
						}else {
							System.out.println("삭제실패!");
						}
					}
				}
			}	
		} while (gubun != 0);

		System.out.println("종료~~~");
//		for(int k=0; k< dtos.size(); k++) {
//			System.out.print(dtos.get(k).getId()+"\t");
//			System.out.print(dtos.get(k).getName()+"\t");
//			System.out.print(dtos.get(k).getKor()+"\t");
//			System.out.print(dtos.get(k).getEng()+"\t");
//			System.out.print(dtos.get(k).getMat()+"\t");
//			System.out.print(dtos.get(k).getTotal()+"\t");
//			System.out.print(dtos.get(k).getResult()+"\n");
//		}
		
	}

}





