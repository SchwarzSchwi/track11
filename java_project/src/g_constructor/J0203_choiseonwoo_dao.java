package g_constructor;

public class J0203_choiseonwoo_dao {
	int getAverage(int kor, int eng, int mat) {
		int average = (kor + eng + mat) / 3;
		return average;
	}
	
	String getResult(int average) {
		String result = "";
		if(average >=0 && average<80) result = "불합격";
			else if(average <= 100 && average >= 80) result = "합격";		
			return result;
		
		
	}
}
