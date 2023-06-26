package g_생성자;

public class J0130_1_dao {
	//총점
	int getTotal(int k, int e, int m){
		int total = k + e + m;
		return total;
	}
	
	//평균
	int getAve(int total, int count) {
		int ave = total / count;
		return ave;
	}

	public void getSetTotal(J0130_student dto) {
		int total = dto.getKor() +
					dto.getEng() +
					dto.getMat();
		dto.setTotal(total);
	}
	void getSetAve(J0130_student dto) {
		int ave = dto.getTotal() / 3;
		dto.setAve(ave);		
	}
	public int getTotal(J0130_student dto) {
		int total = dto.getKor() +
					dto.getEng() +
					dto.getMat();
		return total;
	}
	public int getAve(J0130_student dto) {
		int ave = dto.getTotal() / 3;
		return ave;
	}
}
