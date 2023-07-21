package dto;

public class EtcDto {
	private int entno, groupno, grouporder, depth;
	String title, regdate, updatedate, regid;
	
	
	public int getEntno() {
		return entno;
	}

	
	public int getGroupno() {
		return groupno;
	}



	public int getGrouporder() {
		return grouporder;
	}



	public int getDepth() {
		return depth;
	}






	public String getTitle() {
		return title;
	}



	public String getRegdate() {
		return regdate;
	}



	public String getUpdatedate() {
		return updatedate;
	}



	public String getRegid() {
		return regid;
	}



	public EtcDto(int entno, int groupno, int grouporder, int depth, String title, String regdate, String regid) {
		super();
		this.entno = entno;
		this.groupno = groupno;
		this.grouporder = grouporder;
		this.depth = depth;
		this.title = title;
		this.regdate = regdate;
		this.regid = regid;
	}
}
