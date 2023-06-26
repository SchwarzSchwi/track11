package n_exception;

public class J0213_1 {

	public static void main(String[] args) {
		System.out.println("시스템 시작");
		String kor = "백";
		int korNum = 0;
		try {
			System.out.println("try 000");
			korNum = Integer.parseInt(kor);
			System.out.println("try111");
		}catch(Exception e) {
			System.out.println("오류~~");
		}finally{
			System.out.println("finally~~~");
		}
		System.out.println(" korNum : "+korNum);
		
		System.out.println("시스템 종료");
	}

}
