package dto;

public class SnackDto {
	private String p_code, p_name, 
					m_code, m_name, strPrice;
	private int price;
	//목록조회
	
	
	public String getP_code() {
		return p_code;
	}
	public SnackDto(String p_code, String p_name, String m_name, String strPrice) {
		this.p_code = p_code;
		this.p_name = p_name;
		this.m_name = m_name;
		this.strPrice = strPrice;
	}
	public SnackDto(String p_code, String p_name, String m_code, String m_name, String strPrice) {
		this.p_code = p_code;
		this.p_name = p_name;
		this.m_code = m_code;
		this.m_name = m_name;
		this.strPrice = strPrice;
	}
	public String getP_name() {
		return p_name;
	}
	public String getM_code() {
		return m_code;
	}
	public String getM_name() {
		return m_name;
	}
	public int getPrice() {
		return price;
	}
	public String getStrPrice() {
		return strPrice;
	}
	//제품등록
	public SnackDto(String p_code, String p_name,int price,String m_code) {
		this.p_code = p_code;
		this.p_name = p_name;
		this.price = price;
		this.m_code = m_code;
		
	}
	//제조사
	public SnackDto(String m_code, String m_name) {
		this.m_code = m_code;
		this.m_name = m_name;
	}
	
	
}
