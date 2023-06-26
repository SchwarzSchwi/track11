package g_생성자;

public class J0131_1_dao {
	void setTotal(J0131_1_dto dto) {
		int total = dto.getKor()+
					dto.getEng()+
					dto.getMat();
		dto.setTotal(total);
	}
	void setAve(J0131_1_dto dto) {
		int ave = dto.getTotal() / 3;
		dto.setAve(ave);	
	}
	J0131_1_dto getDto(String name,
						int kor, int eng, int mat){
		J0131_1_dto dto = new J0131_1_dto(name, kor, eng, mat);		
			
//		dto.setName(name);
//		dto.setKor(kor);
//		dto.setEng(eng);
//		dto.setMat(mat);
		int total = kor+eng+mat;
		dto.setTotal(total);
		int ave = total / 3;
		dto.setAve(ave);
		return dto;
	}
	void dtoPrint(J0131_1_dto dto) {
		System.out.println("name : "+dto.getName());
		System.out.println("total : "+dto.getTotal());
		System.out.println("ave : "+dto.getAve());
	}
	void dtoArrPrint(J0131_1_dto[] arr) {
		for(int k=0; k<arr.length; k++) {
			System.out.println("name : "+arr[k].getName());
			System.out.println("total : "+arr[k].getTotal());
			System.out.println("average : "+arr[k].getAve());
		}	
	}	
}
