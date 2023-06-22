package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.ProductDto;

public class ProductDao {
	Connection 			con = null;
	PreparedStatement 	ps  = null;
	ResultSet 			rs  = null;		

	
	//조회수 상승
	public void setHitCount(String no){
		String query="update bike_최선우_product\r\n" + 
				" set hit = hit + 1\r\n" + 
				" where no ='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			int result = ps.executeUpdate();
			if(result == 0) System.out.println("product 조회수 증가 오류~~");
		}catch(Exception e) {
			System.out.println("setHitCount()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		
	}
	
	//상세조회
	public ProductDto getProductView(String no){
		ProductDto dto =null;
		String query  ="select serial_no, name, photos, content, priority,   \r\n" + 
				"huge, price, to_char(reg_date,'yyyy-MM-dd')as reg_date,\r\n" + 
				"registrant\r\n" + 
				"from bike_최선우_product\r\n" + 
				"where serial_no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()){
				String serial_no	= rs.getString("serial_no");
				String name 	= rs.getString("name");
				String photos 	= rs.getString("photos");
				String content = rs.getString("content");
				String priority = rs.getString("priority");
				String huge = rs.getString("huge");
				String price = rs.getString("price");
				String reg_date = rs.getString("reg_date");
				String registrant = rs.getString("registrant");
				
				dto = new ProductDto(serial_no, name, photos, content, priority, huge, price, reg_date, registrant);
			}
		}catch(Exception e) {
			System.out.println("getProductView()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return dto;
	}
	
	//목록조회
	public ArrayList<ProductDto> getProductList(String select,String search,
											int start, int end){
		ArrayList<ProductDto> dtos = new ArrayList<>();
		String query ="select *\r\n" + 
				"from\r\n" + 
				"(select rownum as rnum, tbl.*\r\n" + 
				"from\r\n" + 
				"(select photos, serial_no, name, price, views\r\n" + 
				"from bike_최선우_product\r\n" + 
				"where "+select+" like '%"+search+"%')tbl)\r\n" + 
				"where rnum >= "+start+" and rnum <= "+end+"";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()){
				String photos 	= rs.getString("photos");
				String serial_no = rs.getString("serial_no");
				String name = rs.getString("name");
				String price = rs.getString("price");
				int    views      = rs.getInt("views");
				ProductDto dto = new ProductDto(photos, serial_no, name, price, views);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getProductList()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return dtos;
	}
	
	//등록
	public int productSave(ProductDto dto){
		int result = 0;
		/*
		String query="insert into home_최선우_news\r\n" + 
				"(no,title,content,attach,reg_id,reg_date) "+
				"values\r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getAttach()+"','"+dto.getReg_id()+"','"+dto.getReg_date()+"')";
		*/
		String query="insert into bike_최선우_product\r\n" + 
				"(photos, serial_no, content, name, \r\n" + 
				"priority, huge, price, reg_date, registrant)\r\n" + 
				"values('"+dto.getPhotos()+"','"+dto.getSerial_no()+"','"+dto.getContent()+"','"+dto.getName()+"','"+dto.getHuge()+"','"+dto.getPrice()+"',\r\n" + 
				"to_date('"+dto.getReg_date()+"','yyyy-MM-dd'),'"+dto.getRegistrant()+"','"+dto.getPriority()+"')";
		
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("productSave()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//게시글 번호 생성
	public String getMaxNo() { // N001 N002 N003
		String no="";
		String query="select nvl(max(no),'N000') as no\r\n" + 
				     "from bike_최선우_product";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("no"); // "N000"
				no = no.substring(1); // "000"
				int n = Integer.parseInt(no); // 1
				n = n + 1; // 2 
				
				DecimalFormat df = new DecimalFormat("N000");
				no = df.format(n); // "N002"
			}
		}catch(Exception e) {
			System.out.println("getMaxNo() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return no;
	}
	
	//게시글 수
	public int getTotalCount(String select, String search) {
		int count = 0;
		String query ="select count(*) as count \r\n" + 
				" from bike_최선우_product\r\n" + 
				" where "+select+" like '%"+search+"%' "+
				" order by price desc";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt("count");
			}
		}catch(Exception e) {
			System.out.println("getTotalCount()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return count;
	}
}
