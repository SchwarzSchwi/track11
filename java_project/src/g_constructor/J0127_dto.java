package g_constructor;

public class J0127_dto {
	String id, name, area;
	int age;
	J0127_dto(){}
	
	J0127_dto(String id){
		this.id = id;
	}
	J0127_dto(String id, String name, String area, int age){
		this.id = id;
		this.name = name;
		this.area = area;
		this.age = age;
	}
	J0127_dto(int age, String id, String name, String area){
		this.id = id;
		this.name = name;
		this.area = area;
		this.age = age;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
