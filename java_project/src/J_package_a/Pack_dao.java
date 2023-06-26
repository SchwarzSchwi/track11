package J_package_a;

public class Pack_dao {
	int getTotal(int kor, int eng, int mat) {
		int total = kor + eng + mat;
		return total;
	}
	int getAve(int kor, int eng, int mat) {
		int total = getTotal(kor, eng, mat);
		int ave = total / 3;
		return ave;
	}

}
