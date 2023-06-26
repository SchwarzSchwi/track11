package dto;

public class QnaDto {
	String no, title, content, reg_id, reg_date, qna_date, answer;

	int hit;
	
//답변삭제
	public QnaDto(String no) {
		this.no = no;
	}
	
//답변
	public QnaDto(String no, String qna_date, String answer) {
	this.no = no;
	this.qna_date = qna_date;
	this.answer = answer;
}
	

	//이전글, 다음글
	public QnaDto(String no, String title) {
	this.no = no;
	this.title = title;
}

	public QnaDto(String no, String title, String content, String reg_id, String reg_date, String qna_date,
			String answer, int hit) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.qna_date = qna_date;
		this.answer = answer;
		this.hit = hit;
	}


//질문 수정
	public QnaDto(String no, String title, String content, String reg_id, String reg_date) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
	}
	
//목록조회
	public QnaDto(String no, String title, String reg_id, String reg_date, String answer, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.answer = answer;
		this.hit = hit;
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

	public String getReg_id() {
		return reg_id;
	}

	public String getReg_date() {
		return reg_date;
	}

	public String getQna_date() {
		return qna_date;
	}

	public String getAnswer() {
		return answer;
	}

	public int getHit() {
		return hit;
	}
	
	
	
	
}

	
	
