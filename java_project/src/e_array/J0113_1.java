package e_array;

public class J0113_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] aa = new int[4];
		aa[0] = 10;
		aa[1] = 20;
		aa[2] = 30;
		aa[3] = 40;
		
		String[] bb = new String[4];
		bb[0] = "gagaga";
		bb[1] =	"nanana";
		bb[2] = "dadada";
		bb[3] = "";
		
		System.out.println(bb[0]);
		System.out.println(bb[1]);
		System.out.println(bb[2]);
		
		for(int k=0; k<bb.length; k++) {
			System.out.println(bb[k]);
		}	
	}

}
