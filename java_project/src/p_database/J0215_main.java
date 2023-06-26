package p_database;

import java.util.ArrayList;

public class J0215_main {

	public static void main(String[] args) {
		J0214_dao dao = new J0214_dao();
//		J0214_dto dto = 
//				dao.getMemberInfo("A005");
//		if(dto == null) {
//			System.out.println("정보없음");
//		}else {
//			System.out.println("ID:"+dto.getId());
//			System.out.println("성명:"+dto.getName());
//			System.out.println("지역:"+dto.getArea());
//			System.out.println("나이:"+dto.getAge());
//		}
		ArrayList<J0214_dto> dtos = dao.getMemberList("김");
		
		if(dtos.size() == 0) {
			System.out.println("정보없음~");
		}else {
			System.out.println("총인원" + dtos.size());
			for(int k=0; k<dtos.size(); k++) {
				System.out.println(dtos.get(k).getId()+"\t");
				System.out.println(dtos.get(k).getName()+"\t");
				System.out.println(dtos.get(k).getArea()+"\t");
				System.out.println(dtos.get(k).getAge()+"\n");
			}	
		}
	}

}
