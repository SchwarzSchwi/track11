package dto;

public class EtcDto {
	private String no, content, reg_id, reg_name, reg_date, step, depth, reply;

	public EtcDto(String no, String content, String reg_id, String reg_name, String reg_date, String step, String depth,
			String reply) {
		super();
		this.no = no;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.step = step;
		this.depth = depth;
		this.reply = reply;
	}

	public EtcDto(String entno, int groupno, int grouporder, int depth, String title, String regdate, String regid) {
		// TODO Auto-generated constructor stub
	}

	public String getNo() {
		return no;
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

	public String getStep() {
		return step;
	}

	public String getDepth() {
		return depth;
	}

	public String getReply() {
		return reply;
	}

}