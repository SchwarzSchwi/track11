package f_method;

public class J0125_2_sub {
	int getTotal(int a, int b, int c) {
		int total = a + b + c;
		return total;
	}
	double getAve(int total, int count) {
		int ave = total / count;
		return ave;
	}
	String getResult(double ave) {
		String result="";
		if(ave>100 && ave < 0) result=("입력오류입니다");
		else if (ave<100 && ave >= 90) result=("수");
		else if (ave<90 && ave >= 80) result=("우");
		else if (ave<80 && ave >= 70) result=("미");
		else if (ave<70 && ave >= 60) result=("양");
		else System.out.print("가");
		return result;
	}
}
