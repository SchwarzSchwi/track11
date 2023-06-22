package dto;

public class ProductDto {
	private String no,photos,serial_no,content,name,priority,huge,price,reg_date,registrant;
	int views;
	
	public String getNo() {
		return no;
	}


	public String getPhotos() {
		return photos;
	}


	public String getSerial_no() {
		return serial_no;
	}


	public String getContent() {
		return content;
	}


	public String getName() {
		return name;
	}


	public String getPriority() {
		return priority;
	}


	public String getHuge() {
		return huge;
	}


	public String getPrice() {
		return price;
	}


	public String getReg_date() {
		return reg_date;
	}


	public String getRegistrant() {
		return registrant;
	}


	public int getViews() {
		return views;
	}
	

	//등록,상세보기
	public ProductDto(String serial_no, String name, String photos, String content, String priority, String huge,
			String price, String reg_date, String registrant) {
		this.serial_no = serial_no;
		this.photos = photos;
		this.content = content;
		this.name = name;
		this.huge = huge;
		this.price = price;
		this.reg_date = reg_date;
		this.registrant = registrant;
	}


	//목록
	public ProductDto(String photos, String serial_no, String name, String price, int views) {
		this.photos = photos;
		this.serial_no = serial_no;
		this.name = name;
		this.price = price;
		this.views = views;
	}

	
	
}
