package f_method;

public class J0120_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J0120_1_sub sub = new J0120_1_sub();
		int kor = 50, eng = 60, mat = 70;
		int total_1 = sub.getTotal_1(kor,eng); //110
		System.out.println(total_1);
		int total_2 = sub.getTotal_2(kor, eng, mat); //180
		System.out.println(total_2);
		String total_3 = sub.getTotal_3(eng,mat); //130
		System.out.println(total_3);
		int ave_1 = sub.getAve_1(total_2, 3); //60
		System.out.println(ave_1);
		int ave_2 = sub.getAve_2(total_3, 2); //65
		System.out.println(ave_2);
		String ave_3 = sub.getAve_3(total_2, "3");//60
		System.out.println(ave_3);
		String ave_4 = sub.getAve_4(total_3,"2");//"65"
		System.out.println(ave_4);
		int total_4 = sub.getTotal_4(10,"20",30,"40");//100
		System.out.println(total_4);
		double ave_5 = sub.getAve_5(total_2, "3"); // 60.0
		System.out.println(ave_5);
	}

}
