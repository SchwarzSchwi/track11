package dto;

public class QnaDto {
	private String no, q_title, q_content, q_date, q_id, name, a_title, a_content, a_date, a_id, photos;
	int views;

	public String getNo() {
		return no;
	}

	public String getQ_title() {
		return q_title;
	}

	public String getQ_content() {
		return q_content;
	}

	public String getQ_date() {
		return q_date;
	}

	public String getQ_id() {
		return q_id;
	}
	public String getName() {
		return name;
	}

	public String getA_title() {
		return a_title;
	}

	public String getA_content() {
		return a_content;
	}

	public String getA_date() {
		return a_date;
	}

	public String getA_id() {
		return a_id;
	}
	public String getPhotos() {
		return photos;
	}

	public int getViews() {
		return views;
	}
	//답변수정
	public QnaDto(String no, String a_content, String a_date, String a_id, String name, int views) {
		this.no = no;
		this.a_content = a_content;
		this.a_date = a_date;
		this.a_id = a_id;
		this.name = name;
		this.views = views;
		}
	//답변등록
	public QnaDto(String no, String a_title, String a_content, String a_date, String a_id) {
		this.no = no;
		this.a_title = a_title;
		this.a_content = a_content;
		this.a_date = a_date;
		this.a_id = a_id;
	}
	//질문등록
	public QnaDto(String no, String q_title, String q_content, String q_date, String q_id, String name, String photos, int views) { 
		this.no = no;
		this.q_title = q_title;
		this.q_content = q_content;
		this.q_date = q_date;
		this.q_id = q_id;
		this.name = name;
		this.photos = photos;
		this.views = views;
	}
	


	//목록조회 / 상세조회
	public QnaDto(String no, String q_title, String q_content, String q_date, String q_id, String name, String photos, String a_title,
			String a_content, String a_date, String a_id, int views) {
		this.no = no;
		this.q_title = q_title;
		this.q_content = q_content;
		this.q_date = q_date;
		this.q_id = q_id;
		this.name = name;
		this.photos = photos;
		this.a_title = a_title;
		this.a_content = a_content;
		this.a_date = a_date;
		this.a_id = a_id;
		this.views = views;
	}
	
	
}
