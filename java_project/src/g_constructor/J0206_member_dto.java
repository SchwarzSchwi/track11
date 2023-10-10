package g_constructor;

public class J0206_member_dto {
	String id, name, result;
	Double height, weight;
	
	public J0206_member_dto(String id, String name, Double height, Double weight, String result) {
		
		this.id = id;
		this.name = name;
		this.result = result;
		this.height = height;
		this.weight = weight;
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

	public Double getHeight() {
		return height;
	}

	public Double getWeight() {
		return weight;
	}
	
	
}
