package n_exception;

public class J0213_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = new String[2];
		str[0] = "100";
		str[1] = "200";
		int kor=0, eng=0;		
		try {
			kor = Integer.parseInt(str[0]);
			eng = Integer.parseInt(str[2]);
		}catch(NumberFormatException e) {
			System.out.println("catch 11~~");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("catch 22~~");
		}
		System.out.println("kor : "+kor);
		System.out.println("eng : "+eng);
		System.out.println("종료~~~");
		
	}

}
