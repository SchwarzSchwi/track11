package h_arraylist;

public class J0208_1_dto {
	String grade, cla, number, name;
	int kor, eng, mat;
	public J0208_1_dto(String grade, String cla, String number, String name, int kor, int eng, int mat) {
		this.grade = grade;
		this.cla = cla;
		this.number = number;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public String getGrade() {
		return grade;
	}
	public String getCla() {
		return cla;
	}
	public String getNumber() {
		return number;
	}
	public String getName() {
		return name;
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
}	
