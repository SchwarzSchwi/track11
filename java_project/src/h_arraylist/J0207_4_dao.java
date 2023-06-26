package h_arraylist;

public class J0207_4_dao {
	String getDepart() {
		String depart = "";
		if(depart.equals(10)) {
			depart = "총무";
		}
		else if(depart.equals(20)) {
			depart = "재무";
		}
		else if(depart.equals(30)) {
			depart = "영업";
		}
			return depart;
	}
	String getRank() {
		String rank = "";
		if(rank.equals("s")) {
			rank = "사원";
		}
		if(rank.equals("d")) {
			rank = "대리";
		}
		if(rank.equals("g")) {
			rank = "과장";
		}
			return rank;
	}
}
