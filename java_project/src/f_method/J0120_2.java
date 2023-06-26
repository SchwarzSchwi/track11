package f_method;

public class J0120_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J0120_2_sub sub = new J0120_2_sub();
		int total = sub.getTotal(10,20,30);//60
		System.out.println("total : "+total);
		total = sub.getTotal(10, 20, "30");
		total = sub.getTotal(10, "20", "30");
		total = sub.getTotal(10,"20");
		
	}

}
