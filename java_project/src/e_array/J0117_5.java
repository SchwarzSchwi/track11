package e_array;

public class J0117_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] str = {"홍길동", "대전", "25"};
		String[] st	= new String [3];
		st[0] = "홍길동";
		String[][] str = new String[2][3];
		str[0][0] = "홍길동";
		str[0][1] = "대전";
		str[0][2] = "25";
		str[1][0] = "이상화";
		str[1][1] = "서울";
		str[1][2] = "30";
		int len = str.length;
		System.out.println("2차원 길이 :"+len);
		int col = str[0].length;
		System.out.println("1차원 길이:"+col);
		
		for(int k=0; k<str.length; k++) {
			for(int j=0; j < str[k].length; j++) {
				System.out.print(str[k][j]+"\t");
			}
			System.out.print("\n");
//			System.out.println(str[k][0]);
//			System.out.println(str[k][1]);
//			System.out.println(str[k][2]);
		}
		
//		System.out.println(str[0][0]);
//		System.out.println(str[0][1]);
//		System.out.println(str[0][2]);
//		System.out.println(str[1][0]);
//		System.out.println(str[1][1]);
//		System.out.println(str[1][2]);
		String[][][] stri = new String[2][3][4];
		
	}

}
