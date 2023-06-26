package f_method;

public class J0120_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J0120_4_sub sub = new J0120_4_sub();
		String[] names = sub.getNames("홍길동","김정은", "이상화");
		for(int k=0; k < names.length; k++) {
			System.out.println(names[k]);
		}
	}

}
