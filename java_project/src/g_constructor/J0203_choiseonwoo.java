package g_constructor;

import java.util.Scanner;

public class J0203_choiseonwoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		J0203_choiseonwoo_dao dao = new J0203_choiseonwoo_dao();
		System.out.println("count?");
		int count = sc.nextInt();
		J0203_choiseonwoo_dto[] arr = new J0203_choiseonwoo_dto[count];
		for(int k=0; k<arr.length; k++) {
			System.out.println("name?");
			String name = sc.next();
			System.out.println("korean?");
			int kor = sc.nextInt();
			System.out.println("english?");
			int eng = sc.nextInt();
			System.out.println("math");
			int mat = sc.nextInt();
			
			int ave = dao.getAverage(kor, eng, mat);
			String res = dao.getResult(ave);
			
			J0203_choiseonwoo_dto dto = 
					new J0203_choiseonwoo_dto(name, res, kor, eng, mat, ave);
			
			arr[k]= dto;
		}
		
		System.out.println("=========================================");
		
		for(int k=0; k<arr.length; k++) {
			System.out.print("성명:"+arr[k].getName()+"\t");
			System.out.print("국어:"+arr[k].getKor()+"\t");
			System.out.print("영어:"+arr[k].getEng()+"\t");
			System.out.print("수학:"+arr[k].getMat()+"\t");
			System.out.print("평균:"+arr[k].getAve()+"\t");
			System.out.print("결과:"+arr[k].getResult()+"\n");
		}
		
	}

}
