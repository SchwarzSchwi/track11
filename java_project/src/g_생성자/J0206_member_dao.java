package g_생성자;

public class J0206_member_dao {
	String getResult(double height, double weight) {
		
		String result = "비만";
		if(weight <= (height-100)*0.9) result = "정상";
				
		return result;
	}
}
