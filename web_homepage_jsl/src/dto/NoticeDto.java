package dto;

public class NoticeDto {
	private String no,title,content,attach,
	        reg_id,reg_name,reg_date;
	int hit;
	
	//수정저장
	public NoticeDto(String no, String title, String content, String attach) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.attach = attach;
	}
	//수정저장2
	public NoticeDto(String no, String title, String content) {
		this.no = no;
		this.title = title;
		this.content = content;
	}
	//이전글, 다음글
	public NoticeDto(String no, String title) {
		this.no = no;
		this.title = title;
	}
	


	//상세조회
	public NoticeDto(String no, String title, String content, String attach, String reg_name, String reg_date,
			int hit) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.hit = hit;
	}

	//목록조회
	public NoticeDto(String no, String title, String attach, String reg_name, String reg_date, int hit) {
		this.no = no;
		this.title = title;
		this.attach = attach;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.hit = hit;
	}

	// 저장
	public NoticeDto(String no, String title, 
					String content, String attach, 
					String reg_id, String reg_date) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
	}
	
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
	
	
}
