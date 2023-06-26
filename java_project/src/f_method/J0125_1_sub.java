package f_method;

public class J0125_1_sub {

	int getTotal(String str, int i) { 
		int total = Integer.parseInt(str) + i;
		return total;
	}	
	int getTotal(int a, String b) {
		int total = a = Integer.parseInt(b);
		return total;
	}
	int getTotal(int[] arr) {
		int total = 0;
		for(int k=0; k<arr.length; k++) {
			total = total + arr[k];
		}
		return total;
	}
	int[] getTotal(int a, int b) {
		int[] result = new int[2];
		int total = a + b;
		int ave = total / 2;
		result[0] = total;
		result[1] = ave;
		return result;
	}
	String[] getTotal(int a, int b, int c) {
		String[] result = new String[2];
		int total = a + b + c;
		int ave = total / 3;
		result[0] = Integer.toString(total);
		result[1] = Integer.toString(ave);
		return result;
	}
	int getTotal(int[] point, String[] result) {
		int total = point[0] + point[1];
		int total2 = Integer.parseInt(result[0])+ Integer.parseInt(result[1]);
		return total + total2;
	}
}
