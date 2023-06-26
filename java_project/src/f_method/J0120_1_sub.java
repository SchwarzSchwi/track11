package f_method;

public class J0120_1_sub {
	String get(int a, String b){
		
		return "100";	
	}
	int getTotal_1(int a, int b) {
		int total1 = a + b;
		return total1;
	}
	int getTotal_2(int a, int b, int c) {
		int total2 = a+b+c;
		return total2;		
	}
	String getTotal_3(int a, int b) {
		String total3 = Integer.toString(a+b);
		return total3;
	}
	int getAve_1(int a, int b) {
		int ave_1 = a / b;
		return ave_1;
	}
	int getAve_2(String total, int count) {
		int ave_2 = Integer.parseInt(total) / count;
		return ave_2;
	}
	String getAve_3(int total_2, String count_2) {
		int ave_3 = total_2 / Integer.parseInt(count_2); 
		return Integer.toString(ave_3);
	}	
	String getAve_4(String total_4, String count_4) {
		int ave_4 = Integer.parseInt(total_4) / Integer.parseInt(count_4);
		return Integer.toString(ave_4);
	}
	int getTotal_4(int a, String b, int c, String d) {
		int total_4 = a + Integer.parseInt(b) + c + Integer.parseInt(d);
		return total_4;
	}
	
	double getAve_5(int total_5, String count_5) {
		double ave_5 = (double)total_5 / (double)Integer.parseInt(count_5);
		return ave_5;
	}
}
