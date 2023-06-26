package dto;

public class FaqDto {

	String no, title, content, attach, reg_id, reg_name, reg_date; 
	int hit;
	
	
	
	public String getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getAttach() {
		return attach;
	}
	public String getReg_id() {
		return reg_id;
	}
	public String getReg_name() {
		return reg_name;
	}
	public String getReg_date() {
		return reg_date;
	}
	public int getHit() {
		return hit;
	}
	//저장,상세조회
	public FaqDto(String no, String title, String content, String reg_id, String reg_date) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
	}

	//목록조회
	public FaqDto(String no, String title,  String reg_name, String reg_date) {
		this.no = no;
		this.title = title;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
	}
	//이전글 다음글
	public FaqDto(String no, String title) {
		super();
		this.no = no;
		this.title = title;
	}
		
}
