package a_basic;

public class J0105_4_형변환{

	public static void main(String[] args) {
		// int -> double : ��菩�俯･ｼ �共��俯｡� 
		int total = 185;
		int count = 3;
		double ave = total / (double)count;
		System.out.println("ave :"+ave);
		
		// double -> int : �共��俯･ｼ ��菩�俯｡�
		double d = 85.8555555;
		int dd = (int)d;
		System.out.println("dd :"+dd);
		
		// String ->int :�ｬｸ�梵�龍 ��菩�俯･ｼ  ��菩�俯｡�
		String s = "100"; // "100"->100
		int ss = Integer.parseInt(s);// 100
		System.out.println("ss :"+ss);
		
		// int ->String  : ��菩�俯･ｼ �ｬｸ�梵�龍 ��菩�俯｡�
		int i = 85;
		String ii = Integer.toString(i);// 85->"85"
		System.out.println("ii :"+ii);

		
		
	}

}
