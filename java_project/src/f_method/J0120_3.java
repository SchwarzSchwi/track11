package f_method;

public class J0120_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J0120_3_sub sub = new J0120_3_sub();
		int[] score = {10,20,30};
		int total = sub.getTotal(score);//60
		System.out.println("total"+total);
		
		int ave = sub.getAve(score,3);
		System.out.println(ave);
		
		int ave_2 = sub.getAve(score);

	}

}
