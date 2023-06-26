package n_exception;

public class J0213_4_sub {
	
	public int getTotal(String kor, String eng) {
		int total = 0;
		try {
			total = Integer.parseInt(kor)+
					Integer.parseInt(eng);
		}catch(Exception e) {
			System.out.println("오류~~~");
		}
		return total;
	}
	public int getAve(int total, String count) throws Exception{
		int ave = 0;
		try {
			ave = total / Integer.parseInt(count);
		}catch(Exception e) {
			System.out.println("평균오류~~~");
		}
		return ave;
	}
		
	
}
//어떤 메소드는 위와같이 씀 throw Exception