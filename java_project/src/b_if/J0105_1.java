package b_if;

public class J0105_1 {

	public static void main(String[] args) {
		int a=10, b=5;
		if(a == b){
			System.out.println("true 1~~");
		}
		if(a>b && a!=b){
			System.out.println("true 2~~");
		}
		if(a<b || a!=b){
			System.out.println("true 3~~");
		}
		
		if(a>b){
			if(a!=b){
				System.out.println("true 4~~");
			}
		}
		if(a>b && a!=b){
			System.out.println("true 5~~");
		}
		
		
		System.out.println("끝~~~~");
	}

}
