package g_constructor;

public class J0206_2_dto {
	String id, name, result;
	int kor, eng, mat;
	double average;
	public J0206_2_dto(String id, String name, int kor, int eng, int mat, double average, String result) {
		this.id = id;
		this.name = name;
		this.result = result;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.average = average;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getResult() {
		return result;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMat() {
		return mat;
	}
	public double getAverage() {
		return average;
	}
	
	
	
}
