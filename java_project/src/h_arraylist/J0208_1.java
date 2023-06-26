package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0208_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<J0208_1_dto> arr = new ArrayList<>(); 
		J0208_1_dao dao = new J0208_1_dao();
		System.out.println("count");
		int count = sc.nextInt();
		for (int k = 0; k < count; k++) {
			System.out.println("grade");
			String grade = sc.next();
			System.out.println("cla");
			String cla = sc.next();
			System.out.println("number");
			String num = sc.next();
			System.out.println("name");
			String name = sc.next();
			System.out.println("korean?");
			int kor = sc.nextInt();
			System.out.println("english");
			int eng = sc.nextInt();
			System.out.println("math?");
			int mat = sc.nextInt();
			
			J0208_1_dto dto = new J0208_1_dto(grade, cla, num, name, kor, eng, mat);
			arr.add(dto);
		}
		for(int k=0; k<arr.size(); k++) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("층"+count+"명"+"\t"+"\t"+"\t"+"\t"+
							dao.getKorTotal(arr)+"점"+"\t"+
							dao.getEngTotal(arr)+"점"+"\t"+
							dao.getMatTotal(arr)+"점");
		}
	}

}
