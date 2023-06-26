package g_생성자;

public class J0130_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		J0130_student dto = new J0130_student();
		J0130_1_dao dao = new J0130_1_dao();
		
		String name = "honggildong";
		int kor = 50, eng = 60, mat = 70;
		int total = dao.getTotal(kor, eng, mat);
		System.out.println("total : "+total);
		int ave = dao.getAve(total, 3);
//		dto.setName(name);
//		dto.setKor(kor);
//		dto.setEng(eng);
//		dto.setMat(mat);
//		dto.setTotal(total);
//		dto.setAve(ave);
//		J0130_student dto = new J0130_student(name,kor,eng,mat,total,ave);
		
		J0130_student dto = new J0130_student(name,kor,eng,mat);
		
		System.out.println("name : "+dto.getName());
		System.out.println("kor : "+dto.getKor());
		System.out.println("eng : "+dto.getEng());
		System.out.println("mat : "+dto.getMat());
		System.out.println("total : "+dto.getTotal());
		System.out.println("average : "+dto.getAve());
	}

}
