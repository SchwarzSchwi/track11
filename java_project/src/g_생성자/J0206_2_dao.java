package g_생성자;

public class J0206_2_dao {
	double getAverage(int kor, int eng, int mat) {
	double average = (kor+eng+mat) / 3;
	return average;
	}

	String getResult(int kor, int eng, int mat, double average) {
		String result = "";
		if (kor < 60 || eng < 60 || mat < 60 || average < 80) {
			result = "불합격";
		} else if (kor >= 60 && eng >= 60 && mat >= 60 && average >= 80) {
			result = "합격";
		} else if (kor > 100 || eng > 100 || mat > 100 || average > 100) {
			result = "입력오류";
		}
		return result;
	}
	
}
