package f_method;

public class J0119_2_1_sub {

	String getGubun(String a) {
		int	result = 100-Integer.parseInt(a);
		String re = Integer.toString(result);
		return re;
	}	
	String getPlus(int kor, String eng) {
		int result = kor+Integer.parseInt(eng);
		return Integer.toString(result);
	}
}
