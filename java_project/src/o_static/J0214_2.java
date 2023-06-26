package o_static;

public class J0214_2 {
	String name;
	J0214_1_sub sub;
	
	J0214_1_sub getSub() {
		sub = new J0214_1_sub();
		return sub;
	}
	
	int getTotal(int a, int b) {
		name = "홍길동";
		sub = new J0214_1_sub();
		System.out.println("sub : "+sub);
		return a + b;
	}
}
