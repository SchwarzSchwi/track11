package g_생성자;

public class J0131_2 {

	public static void main(String[] args) {
		J0131_1_dao dao = new J0131_1_dao();
		J0131_1_dto[] arr = new J0131_1_dto[3];
		J0131_1_dto dto_0 = new J0131_1_dto();
		J0131_1_dto dto_1 =
				new J0131_1_dto("이상화",20,30,40);
		J0131_1_dto dto_2 =
				new J0131_1_dto("홍길동",70,80,90);
		arr[0] = dto_0;
		arr[1] = dto_1;
		arr[2] = dto_2;
		
		arr[0].getName();
		arr[1].getName();
		arr[2].getName();
		
		for(int k=0; k<arr.length; k++) {
			dao.setTotal(arr[k]);
			dao.setAve(arr[k]);
			System.out.println("name : "+arr[k].getName());
			System.out.println("total : "+arr[k].getTotal());
			System.out.println("average : "+arr[k].getAve());
		}
	}

}
