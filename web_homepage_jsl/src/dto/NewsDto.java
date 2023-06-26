package dto;

public class NewsDto {
	private String no,title,content,reg_id,reg_name,reg_date,update_date;
	int hit;
	private String preNo;
	
	public String getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
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
	public String getUpdate_date() {
		return update_date;
	}
	public int getHit() {
		return hit;
	}
	//등록
	public NewsDto(String no, String title, String content, String reg_id, String reg_date) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
	}
	//목록조회
	public NewsDto(String no, String title, String reg_name, String reg_date, int hit) {
		this.no = no;
		this.title = title;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.hit = hit;
	}
	//상세조회
	public NewsDto(String no, String title, String content, String reg_name, String reg_date, int hit) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.hit = hit;
	}
	//수정저장
	public NewsDto(String no, String title, String content, String update_date) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.update_date = update_date;
	}
	//수정조회
	public NewsDto(String no, String title, String content, String reg_name, String reg_date, String update_date,
			int hit) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.hit = hit;
	}
	//이전글 다음글
	public NewsDto(String no, String title) {
		// TODO Auto-generated constructor stub
		this.no = no;
		this.title=title;
	}
	
	

	
}
