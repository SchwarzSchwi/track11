package p_database;

public class J0216_student_dto {
	private String id, name, result;
	private int kor, eng, mat, total;
	
	public J0216_student_dto(String id, String name, int kor, int eng, int mat, 
							 int total, String result ) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.total = total;
		this.result = result;
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
	public int getTotal() {
		return total;
	}
	
	
}
