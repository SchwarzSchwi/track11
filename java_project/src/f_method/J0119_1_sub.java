package f_method;

public class J0119_1_sub {
	String getPass(int score) {
		String result = "";
		if(score>=0 && score<=49) result = "불합격";
		else if(score>=50 && score<=100) result = "합격";
		else result = "입력오류";
		return result;
	}
	
	String getNoodle(int gram) {
		String result ="";
		if(gram == 100)result = "소";
		else if(gram == 200)result = "중";
		else if(gram == 300)result = "대";
		return result;
	}
	String getName(){
		String name = "홍길동";
		return name;
	}
	int getPoint(){
		int point = 100;
		return point;		
	}
	String getKor() {
		String kor = "90";
		return kor;
	}
	String getEng() {
		String eng = "80";
		return eng;
	}
	boolean getTrue() {
		boolean tf = true;
		return true;
	}

}
