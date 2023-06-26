package p_database;

public class J0222_최선우_employee_dto {
	private String id,name,depart,rank;
	private int age;
	public J0222_최선우_employee_dto(String id, String name, String depart, String rank, int age) {
		this.id = id;
		this.name = name;
		this.depart = depart;
		this.rank = rank;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDepart() {
		return depart;
	}
	public String getRank() {
		return rank;
	}
	public int getAge() {
		return age;
	}
	
	
}
