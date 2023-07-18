package dto;

public class FreeboardDto {
	String no, title, content, reg_id, reg_date, update_date, attach, name;
	int download, hit;
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
	public String getReg_date() {
		return reg_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public String getAttach() {
		return attach;
	}
	public String getName() {
		return name;
	}
	public int getDownload() {
		return download;
	}
	public int getHit() {
		return hit;
	}
	//등록
		public FreeboardDto(String no, String title, String content, String reg_id, String attach, int hit) {
			this.no = no;
			this.title = title;
			this.content = content;
			this.reg_id = reg_id;
			this.attach = attach;
			this.hit = hit;
		}
	
	//상세보기
	public FreeboardDto(String no, String title, String content, String reg_id, String reg_date, String attach,
			String name, int hit) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.attach = attach;
		this.name = name;
		this.hit = hit;
	}
	//목록조회
	public FreeboardDto(String no, String title, String content, String reg_id, String reg_date, String update_date,
			String attach, String name, int download, int hit) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.attach = attach;
		this.name = name;
		this.download = download;
		this.hit = hit;
	}
	//등록
	public FreeboardDto(String no, String title, String content, String reg_id, String reg_date, String attach, int hit) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.attach = attach;
		this.hit = hit;
	}
	
	
}
