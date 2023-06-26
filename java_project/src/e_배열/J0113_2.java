package e_배열;

public class J0113_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] aa = new int[4];
		aa[0] = 10;
		aa[1] = 20;
		aa[2] = 30;
		aa[3] = 40;

		int[] bb = { 10, 20, 30, 40 };
		String[] cc = { "10", "20", "30", "40" };
		System.out.println(cc[0]);

		int total = 0;
		for (int k = 0; k < aa.length; k++) {
			total = total + aa[k];
			System.out.println(total);
		}
		System.out.println("total : " + total);
		System.out.println("-----------------");
		
		for(int k=0 ; k<aa.length ; k++) {
			aa[k] = aa[k] + 100;
			System.out.println(aa[k]);
		}
	}

}
