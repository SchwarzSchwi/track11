package dto;

public class MemberDto {
	private String id, name, reg_date;
	private int age;
	
	public MemberDto(String id, String name, int age, String reg_date) {
		this.id = id;
		this.name = name;
		this.reg_date = reg_date;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getReg_date() {
		return reg_date;
	}

	public int getAge() {
		return age;
	}

}
