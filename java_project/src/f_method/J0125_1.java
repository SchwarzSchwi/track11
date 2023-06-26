package f_method;

public class J0125_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J0125_1_sub sub = new J0125_1_sub();
		int total = sub.getTotal("10",20);
		System.out.println("total : "+total);
		total = sub.getTotal(30, "40");
		System.out.println("total : "+total);
		
		int[] arr = {10,20,30};
		total =sub.getTotal(arr);
		System.out.println("total : "+total);
		
		int[] point = sub.getTotal(100,200);
		//point[0] : 300
		//point[1] : 150
		
		
		
		String[] result = sub.getTotal(10,20,30);
		// result[0] : "60"
		// result[1] : "20"
		
		total = sub.getTotal(point,result);
		//total 530
	}

}
