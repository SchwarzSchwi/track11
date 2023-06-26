package k_상속;

public class J0209_main {

	public static void main(String[] args) {
		J0209_a aa = new J0209_a();
		int total = aa.getTotal(10, 20);
		J0209_b bb = new J0209_b();
		String name = bb.getName();
		int to = bb.getTotal(20, 30);
		J0209_c cc = new J0209_c();
		int age = cc.getAge();
	}

}
