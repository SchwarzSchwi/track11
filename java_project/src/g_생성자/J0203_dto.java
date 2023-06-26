package g_생성자;

public class J0203_dto {
	String name, gender; 
	int age, money;
	
	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public int getMoney() {
		return money;
	}

	
	
	public J0203_dto(String name, String gender, int age, int money) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.money = money;
	}
	
}
