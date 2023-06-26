package f_method;

public class J0119_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J0119_2_1_sub sub = new J0119_2_1_sub();
		String result = sub.getGubun("200");
		System.out.println(result);
		
		int kor=80, eng=90;
		String plus = sub.getPlus(kor, "90");
		System.out.println(plus);
	}

}
