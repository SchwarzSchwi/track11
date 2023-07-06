package dto;

public class ProductDto {
	private String no,photos,serial_no,content,name,priority,huge,price,reg_date,registrant,views;
	
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


	public String getViews() {
		return views;
	}
	
	//등록
	public ProductDto(String no, String serial_no, String name, String photos, String content, String priority, String huge,
			String price, String reg_date, String registrant) {
		this.no = no;
		this.serial_no = serial_no;
		this.name = name;
		this.photos = photos;
		this.content = content;
		this.priority = priority;
		this.huge = huge;
		this.price = price;
		this.reg_date = reg_date;
		this.registrant = registrant;
	}
	//상세보기
	public ProductDto(String no, String serial_no, String name, String photos, String content, String priority, String huge,
			String price, String reg_date, String registrant, String views) {
		this.no = no;
		this.serial_no = serial_no;
		this.name = name;
		this.photos = photos;
		this.content = content;
		this.priority = priority;
		this.huge = huge;
		this.price = price;
		this.reg_date = reg_date;
		this.registrant = registrant;
		this.views = views;
	}


	//목록
	public ProductDto(String no, String photos, String serial_no, String name, String price, String views) {
		this.no = no;
		this.photos = photos;
		this.serial_no = serial_no;
		this.name = name;
		this.price = price;
		this.views = views;
	}


	
	//수정
	public ProductDto(String no, String serial_no, String name, String photos,  String content, String priority,
			String huge, String price) {
		this.no = no;
		this.photos = photos;
		this.serial_no = serial_no;
		this.content = content;
		this.name = name;
		this.priority = priority;
		this.huge = huge;
		this.price = price;
	}

	//인덱스목록
	public ProductDto(String no, String photos, String name, String price) {
		this.no = no;
		this.photos = photos;
		this.name = name;
		this.price = price;
	}	
		

	
}
