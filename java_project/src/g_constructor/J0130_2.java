package g_constructor;

import java.util.Scanner;

public class J0130_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J0130_1_dao dao = new J0130_1_dao();
		J0130_student dto = new J0130_student();
		Scanner sc = new Scanner(System.in);
		System.out.println("name?");
		String name = sc.next();
		System.out.println("korean?");
		int kor = sc.nextInt();
		System.out.println("english?");
		int eng = sc.nextInt();
		System.out.println("math?");
		int mat = sc.nextInt();
		
//		int total = dao.getTotal(kor, eng, mat);
//		int ave = dao.getAve(total, 3);
		
		
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		
//		dao.getSetTotal(dto);
//		dao.getSetAve(dto);
		
		int total = dao.getTotal(dto);
		dto.setTotal(total);
		int ave = dao.getAve(dto);
		dto.setAve(ave);
		
		System.out.println("name : "+dto.getName());
		System.out.println("kor : "+dto.getKor());
		System.out.println("eng :"+dto.getEng());
		System.out.println("mat : "+dto.getMat());
		System.out.println("total : "+dto.getTotal());
		System.out.println("ave : "+dto.getAve());
	}

}
