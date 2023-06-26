package h_arraylist;

import java.util.ArrayList;

public class J0207_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J0207_1_dto[] arr = new J0207_1_dto[2];
		ArrayList<J0207_1_dto> dtos =
				new ArrayList<>();
		
		J0207_1_dto dto1 =
				new J0207_1_dto("101","홍길동","대전",25);
		J0207_1_dto dto2 =
				new J0207_1_dto("201","이상화","서울",25);
		dtos.add(dto1);
		dtos.add(dto2);
		dtos.add(new J0207_1_dto("301","김민식","부산",35));
		
		for(int k=0; k<dtos.size(); k++) {
			System.out.print(dtos.get(k).getId());
			System.out.print(dtos.get(k).getName());
			System.out.print(dtos.get(k).getArea());
			System.out.println(dtos.get(k).getAge());
		}
		
	}

}
