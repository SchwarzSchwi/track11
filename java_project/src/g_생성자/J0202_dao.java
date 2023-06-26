package g_생성자;

public class J0202_dao {
	//급여
	int getSalary(String depart, String rank) {
		int salary = 0;
		if(depart.equals("총무")) salary = 1000000;
		else if (depart.equals("재무")) salary = 900000;
		else if (depart.equals("영업")) salary = 1200000;
		
		if(rank.equals("사원")) salary = salary + 200000;
		else if (rank.equals("대리")) salary = salary + 300000;
		else if (rank.equals("과장")) salary = salary + 400000;
		
		if(depart.equals("부서없음") || rank.equals("직위없음")) {
			salary=0;
		}
		
		return salary;
	}
	String getRankName(String code) {
		String rankName = "norank";
		if(code.equals("10")){
			rankName = "사원";
		}
		if(code.equals("20")) {
			rankName = "대리";
		}
		if(code.equals("30")) {
			rankName = "과장";
		}
		return rankName;
	}
	
	String getDepartName(String code){
		String departName = "nodepart";
		if(code.equals("c")) {
			departName = "총무";
		}
		if(code.equals("j")) {
			departName = "재무";
		}
		if(code.equals("y")) {
			departName = "영업";
		}
		return departName;
	}
	
	void setPrint(J0202_dto[] arr){
		for(int k=0; k<arr.length; k++) {
			System.out.println("number : "+arr[k].getNumber());
			System.out.println("name : "+arr[k].getName());
			System.out.println("depart : "+arr[k].getDepart());
			System.out.println("rank : "+arr[k].getRank());
			System.out.println("salary : "+arr[k].getSalary()+"\n");
		}
	}
	void searchData(J0202_dto[] arr, String search) {
		for(int k=0; k<arr.length; k++) {
			
			if(arr[k].getName().indexOf(search) != -1) {
			
				System.out.println("number : "+arr[k].getNumber());
				System.out.println("name : "+arr[k].getName());
				System.out.println("depart : "+arr[k].getDepart());
				System.out.println("rank : "+arr[k].getRank());
				System.out.println("salary : "+arr[k].getSalary()+"\n");
			}
		}
		
	}
}
