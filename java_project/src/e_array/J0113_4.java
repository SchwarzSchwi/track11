package e_array;

public class J0113_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 112, 435, 124, 755, 866, 439, 112, 536, 445, 857, 263, 622, 425, 378, 495, 745, 926, 378, 464,
				568, 594, 555, 855, 454, 874, 512, 125, 545, 118, 564 };
		int num = 0;
		int total = 0;
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] % 2 == 0) {
				num = num + 1;
				if (arr[k] == 0) {
					num = num - 1;
				}
			}
			if (arr[k] % 2 == 1) {
				total = total + arr[k];
			}
		}
		System.out.println(num);
		System.out.println(total);
	}
}
