package dto;

public class OrderDto {
	private String order_no, now_status, serial_no, 
	consumer_id, name, photos, price, payment, purchase_date, post_no, address, detail_address;
	
	

	public String getOrder_no() {
		return order_no;
	}

	public String getNow_status() {
		return now_status;
	}

	public String getSerial_no() {
		return serial_no;
	}

	public String getConsumer_id() {
		return consumer_id;
	}
	public String getName() {
		return name;
	}
	public String getPhotos() {
		return photos;
	}

	public String getPayment() {
		return payment;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public String getPost_no() {
		return post_no;
	}

	public String getAddress() {
		return address;
	}

	public String getDetail_address() {
		return detail_address;
	}

	public String getPrice() {
		return price;
	}

	public OrderDto(String order_no, String now_status, String serial_no, String consumer_id, String purchase_date,
			String price) {
		this.order_no = order_no;
		this.now_status = now_status;
		this.serial_no = serial_no;
		this.consumer_id = consumer_id;
		this.purchase_date = purchase_date;
		this.price = price;
	}

	public OrderDto(String order_no, String now_status, String serial_no, String consumer_id, String name, String photos,
			String payment, String price, String purchase_date, String post_no, String address,
			String detail_address) {
		this.order_no = order_no;
		this.now_status = now_status;
		this.serial_no = serial_no;
		this.consumer_id = consumer_id;
		this.name = name;
		this.photos = photos;
		this.payment = payment;
		this.price = price;
		this.purchase_date = purchase_date;
		this.post_no = post_no;
		this.address = address;
		this.detail_address = detail_address;
	}
	
	
}
