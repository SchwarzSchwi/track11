package g_constructor;

public class J0202_dto {
	String number, name, depart, rank;
	int salary;
	
	public J0202_dto(String number, String name, String depart, String rank, int salary) {
		this.number = number;
		this.name = name;
		this.depart = depart;
		this.rank = rank;
		this.salary = salary;
	}
		

	public String getNumber() {
		return number;
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


	public int getSalary() {
		return salary;
	}
	
}
