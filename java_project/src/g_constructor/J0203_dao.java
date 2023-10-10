package g_constructor;

public class J0203_dao {
	String getGenderName(String gene) {
		String gender = "female";
		if(gene.equals("m")) gender = "male";
		return gender;
	}
	int getMoney(String gender, int age) {
		int money = 0;
		if(gender.equals("male")) money = 100000;
		else if(gender.equals("female")) money=120000;
		
		if(age < 20) money += 30000;
		else if(age <= 25) money += 50000;
		else money += 100000;
		
		return money;
	}
}
