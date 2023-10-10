package g_constructor;

public class J0127_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J0127_dto dto = new J0127_dto();
		String id = dto.getId();
		dto.setId("101");
		id = dto.getId();
		
		dto.setId("201");
		id = dto.getId();
		String name = dto.getName();
		
		J0127_dto dto2 = new J0127_dto("301");
		id = dto2.getId();
		dto2.setName("홍길동");
		name = dto2.getName();
		
		J0127_dto dto3 = new J0127_dto("301","이상화","대전",25);
		
		J0127_dto dto4 = new J0127_dto();
		dto4.setId("301");
		dto4.setName("이상화");
		dto4.setArea("대전");
		dto4.setAge(25);
		name = dto4.getName();
		
		J0127_dto dto5 = new J0127_dto(25,"301","이상화","대전");
		
	}

}
