package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class Consulting_최선우_main {
	public static void main(String[] args) {
		Cstudent_최선우_dao stuDao = new Cstudent_최선우_dao();
		Cmentor_최선우_dao menDao = new Cmentor_최선우_dao();
		Consulting_최선우_dao conDao = new Consulting_최선우_dao();
		Scanner sc = new Scanner(System.in);
		
		String gubun="";
		do {
			System.out.print("[S]학생관리, [M]멘토관리, [C]상담관리, [Q]종료?");
			gubun = sc.next();
			
			//학생관리
			if(gubun.equalsIgnoreCase("S") || gubun.equals("ㄴ")){
				int act =0;
				do {
					System.out.print("[1]학생조회,[2]학생등록,[3]학생수정,[4]학생삭제,[0]이전?");
					act = sc.nextInt();
					//학생조회
					if(act == 1) {
						System.out.print("[1]전체, [2]학번, [3]성명?");
						int searchGubun = sc.nextInt();
						if (searchGubun  == 1) {
							ArrayList<Cstudent_최선우_dto> dtos = stuDao.getSearchList("id","");
							stuDao.print(dtos);
						} else if(searchGubun == 2) {
							System.out.println("학번검색?");
							String id = sc.next();
							ArrayList<Cstudent_최선우_dto> dtos = stuDao.getSearchList("id",id);
							stuDao.print(dtos);
						} else if(searchGubun == 3) {
							System.out.println("성명검색?");
							String name = sc.next();
							ArrayList<Cstudent_최선우_dto> dtos = stuDao.getSearchList("name",name);
							stuDao.print(dtos);
						}
					//학생등록	
					} else if(act == 2) {
						System.out.print("학생번호?");
						String id = sc.next();
						System.out.print("학생성명?");
						String name = sc.next();
						System.out.print("학생나이?");
						int age = sc.nextInt();
						Cstudent_최선우_dto dto = new Cstudent_최선우_dto(id, name, age);
						int result = stuDao.studentSave(dto);
						
						if(result == 1) System.out.println("학생등록 성공!");
						else System.out.println("학생등록 실패~");
					//학생수정	
					} else if(act == 3) {
						System.out.print("수정할 학번?");
						String id = sc.next();
						Cstudent_최선우_dto dto = stuDao.getStudentInfo(id);
						if(dto == null) {
							System.out.println("정보없음");
						}else {
							stuDao.printinfo(dto);
							System.out.println("수정하겠습니까? [y]예,[n]아니오");
							String tf = sc.next();
							if(tf.equalsIgnoreCase("y") || tf.equals("ㅛ")) {
								System.out.println("성명?");
								String name = sc.next();
								System.out.println("나이?");
								int age = sc.nextInt();
								Cstudent_최선우_dto updateDto = new Cstudent_최선우_dto(id, name, age);
								int result = stuDao.studentUpdate(updateDto);
								
								if(result == 1)System.out.println("수정성공!");
								else System.out.println("수정실패");
							}
						}
					//학생삭제	
					} else if(act == 4) {
						System.out.print("삭제할 학번?");
						String id = sc.next();
						Cstudent_최선우_dto dto = stuDao.getStudentInfo(id);
						if(dto == null) {
							System.out.println("정보없음");
						}else {
							stuDao.printinfo(dto);
							System.out.print("삭제하겠습니까?[y]예,[n]아니오");
							String tf = sc.next();
							if(tf.equalsIgnoreCase("y") || tf.equals("ㅛ")) {
								int result = stuDao.studentDelete(id);
								if(result == 1) System.out.println("삭제성공!");
								else System.out.println("삭제실패");
							}
						}
					}
					
				}while(act != 0);	
				
				
				
			//멘토관리	
			} else if(gubun.equalsIgnoreCase("M") || gubun.equals("ㅡ")){
				int act =0;
				do {
					System.out.print("[1]멘토조회,[2]멘토등록,[3]멘토수정,[4]멘토삭제,[0]이전?");
					act = sc.nextInt();
					//멘토 조회
					if(act == 1) {
						System.out.print("[1]전체, [2]멘토번호, [3]성명?");
						int searchGubun = sc.nextInt();
						if (searchGubun  == 1) {
							ArrayList<Cmentor_최선우_dto> dtos = menDao.getSearchList("id","");
							menDao.print(dtos);
						} else if(searchGubun == 2) {
							System.out.println("멘토번호검색?");
							String id = sc.next();
							ArrayList<Cmentor_최선우_dto> dtos = menDao.getSearchList("id",id);
							menDao.print(dtos);
						} else if(searchGubun == 3) {
							System.out.println("성명검색?");
							String name = sc.next();
							ArrayList<Cmentor_최선우_dto> dtos = menDao.getSearchList("name",name);
							menDao.print(dtos);
						}
					//멘토 등록
					} else if(act == 2) {
						System.out.print("학생번호?");
						String id = sc.next();
						System.out.print("학생성명?");
						String name = sc.next();
						
						Cmentor_최선우_dto dto = new Cmentor_최선우_dto(id, name);
						int result = menDao.studentSave(dto);
					
						if(result == 1) System.out.println("학생등록 성공!");
						else System.out.println("학생등록 실패~");
						
					//멘토 수정
					} else if(act == 3) {
						System.out.print("수정할 학번?");
						String id = sc.next();
						Cmentor_최선우_dto dto = menDao.getMentorInfo(id);
						if(dto == null) {
							System.out.println("정보없음");
						}else {
							menDao.printInfo(dto);
							System.out.println("수정하겠습니까? [y]예,[n]아니오");
							String tf = sc.next();
							if(tf.equalsIgnoreCase("y") || tf.equals("ㅛ")) {
								System.out.println("성명?");
								String name = sc.next();
								Cmentor_최선우_dto updateDto = new Cmentor_최선우_dto(id, name);
								int result = menDao.mentorUpdate(updateDto);
								
								if(result == 1)System.out.println("수정성공!");
								else System.out.println("수정실패");
							}
						}
					
					//멘토 삭제
					} else if(act == 4) {
						System.out.print("삭제할 멘토번호?");
						String id = sc.next();
						Cmentor_최선우_dto dto = menDao.getMentorInfo(id);
						if(dto == null) {
							System.out.println("정보없음");
						}else {
							menDao.printInfo(dto);
							System.out.print("삭제하겠습니까?[y]예,[n]아니오");
							String tf = sc.next();
							if(tf.equalsIgnoreCase("y") || tf.equals("ㅛ")) {
								int result = menDao.mentorDelete(id);
								
								if(result == 1) System.out.println("삭제성공!");
								else System.out.println("삭제실패");
							}
						}
					}
				}while(act != 0);	
				
			//상담관리				
			} else if(gubun.equalsIgnoreCase("C") || gubun.equals("ㅊ")){
				int act =0;
				do {
					System.out.print("[1]상담조회,[2]상담등록,[3]상담수정,[4]상담삭제,[0]이전?");
					act = sc.nextInt();
					//상담조회
					if(act == 1) {
						System.out.println("전체조회[A], 상담번호조회[C], 학생조회[S], 멘토조회");
						String searchGubun = sc.next();
						if(searchGubun.equalsIgnoreCase("A") || searchGubun.contentEquals("ㅁ")) {
							ArrayList<Consulting_최선우_dto>dtos = conDao.consultingList("no","");
							conDao.getPrint(dtos);
						}else if(searchGubun.equalsIgnoreCase("C") || searchGubun.contentEquals("ㅊ")) {
							System.out.println("상담번호?");
							
						}
					//상담등록	
					}else if(act == 2) {
					//상담수정	
					}else if(act == 3) {
					//상담삭제	
					}
				}while(act != 0);	
				
			}
			
			
			
		}while(!gubun.equalsIgnoreCase("Q") && !gubun.equals("ㅂ"));
		
		System.out.println("시스템 종료!");

	}

}





