package g_constructor;

public class J0201_dto {
	
	String name, area, edu;
	int age;
	
	public J0201_dto(String name, String area, String edu, int age) {
		this.name = name;
		this.area = area;
		this.edu = edu;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}	