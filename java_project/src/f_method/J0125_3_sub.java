package f_method;

public class J0125_3_sub {
	int getPay(int basic, String gender) {
		if(gender.equals("1")) basic += 100000;
		else if(gender.equals("2")) basic += 200000;
		
		return basic;
	}
	
}
