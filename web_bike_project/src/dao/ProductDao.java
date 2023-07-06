package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.NewsDto;
import dto.ProductDto;

public class ProductDao {
	Connection 			con = null;
	PreparedStatement 	ps  = null;
	ResultSet 			rs  = null;		

	//인덱스 목록조회
	public ArrayList<ProductDto> getProductIndex(){
		ArrayList<ProductDto> dtos = new ArrayList<>();
		String query ="select *\r\n" + 
				"from\r\n" + 
				"("+
				"select tbl.*, rownum as rnum\r\n" + 
				"from\r\n" + 
				"("+
				"select no, photos, name, to_char(price,'999,999,999') as price\r\n" + 
				"from bike_최선우_product\r\n" + 
				"order by to_number(priority) desc"+
				")tbl)\r\n" + 
				"where rnum >= 1 and rnum <= 6";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()){
				String no = rs.getString("no");
				String photos 	= rs.getString("photos");
				String name = rs.getString("name");
				String price = rs.getString("price");
				ProductDto dto = new ProductDto(no, photos, name, price);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getProductIndex()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return dtos;
	}
	//삭제
	public int productDelete(String no){
		int result  = 0;
		String query="delete from bike_최선우_product\r\n" + 
					 " where no ='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("productDelete()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return result;
	}
	//수정
	public int productUpdate(ProductDto dto){
		int result =0;
		String query="update bike_최선우_product\r\n" + 
				"set serial_no ='"+dto.getSerial_no()+"',\r\n" + 
				"    name='"+dto.getName()+"',\r\n" + 
				"    photos='"+dto.getPhotos()+"',\r\n" +   
				"    content='"+dto.getContent()+"',\r\n" +
				"    priority='"+dto.getPriority()+"',\r\n" +
				"    huge='"+dto.getHuge()+"',\r\n" +
				"    price='"+dto.getPrice()+"'\r\n" +
				"	 where no ='"+dto.getNo()+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("productUpdate()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return result;
	}
	
	
	//삭제
	public int productDelete(String no){
		int result  = 0;
		String query="delete from bike_최선우_product\r\n" + 
					 " where no ='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("productDelete()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return result;
	}
	//수정
	public int productUpdate(ProductDto dto){
		int result =0;
		String query="update bike_최선우_product\r\n" + 
				"set serial_no ='"+dto.getSerial_no()+"',\r\n" + 
				"    name='"+dto.getName()+"',\r\n" + 
				"    photos='"+dto.getPhotos()+"',\r\n" +   
				"    content='"+dto.getContent()+"',\r\n" +
				"    priority='"+dto.getPriority()+"',\r\n" +
				"    huge='"+dto.getHuge()+"',\r\n" +
				"    price='"+dto.getPrice()+"'\r\n" +
				"	 where no ='"+dto.getNo()+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("productUpdate()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return result;
	}
	
	
	//조회수 상승
	public void setHitCount(String no){
		String query="update bike_최선우_product\r\n" + 
				" set views = views + 1\r\n" + 
				" where no ='"+no+"'";
		System.out.println(query);
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			int result = ps.executeUpdate();
			if(result == 0) System.out.println("product 조회수 증가 오류~~");
		}catch(Exception e) {
<<<<<<< HEAD
			System.out.println("setHitcount()오류 :"+query);
=======
			System.out.println("setViewsCount()오류 :"+query);
>>>>>>> refs/remotes/origin/main
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		
	}
	
	//상세조회
	public ProductDto getProductView(String no){
		ProductDto dto =null;
		String query  ="select no, serial_no, name, photos, content, priority,   \r\n" + 
				"huge, price, to_char(reg_date,'yyyy-MM-dd')as reg_date,\r\n" + 
				"registrant, views\r\n" + 
				"from bike_최선우_product\r\n" + 
				"where no = '"+no+"'";
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
				String views = rs.getString("views");
				
				dto = new ProductDto(no, serial_no, name, photos, content, priority, huge, price, reg_date, registrant, views);
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
				"(select no, photos, serial_no, name, price, views\r\n" + 
				"from bike_최선우_product\r\n" + 
				"where "+select+" like '%"+search+"%')tbl)\r\n" + 
				"where rnum >= "+start+" and rnum <= "+end+"\r\n" +
				"order by no desc";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()){
				String no = rs.getString("no");
				String photos 	= rs.getString("photos");
				String serial_no = rs.getString("serial_no");
				String name = rs.getString("name");
				String price = rs.getString("price");
<<<<<<< HEAD
				String views      = rs.getString("views");
=======
				int    views      = rs.getInt("views");
>>>>>>> refs/remotes/origin/main
				ProductDto dto = new ProductDto(no, photos, serial_no, name, price, views);
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
				"(no, photos, serial_no, content, name,\r\n" + 
				"priority, huge, price, registrant, reg_date)\r\n" + 
				"values\r\n" + 
				"('"+dto.getNo()+"','"+dto.getPhotos()+"','"+dto.getSerial_no()+"','"+dto.getContent()+"','"+dto.getName()+"',\r\n" + 
				"'"+dto.getPriority()+"','"+dto.getHuge()+"','"+dto.getPrice()+"','"+dto.getRegistrant()+"',\r\n" + 
				"to_date('"+dto.getReg_date()+"','yyyy-MM-dd'))";
		
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
	
<<<<<<< HEAD
=======
	//인덱스
	public ArrayList<ProductDto> getProductIndex(){
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		String query ="select *\r\n" + 
					"from\r\n" + 
					"(select rownum as rnum, tbl.*\r\n" + 
					"from\r\n" + 
					"(select no, photos, serial_no, to_char(price, '999,999,999') as price\r\n" + 
					"from bike_최선우_product\r\n" + 
					"order by to_number(registrant) desc, no desc\r\n" + 
					"where rnum >=1 and rnum <=6";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
		while(rs.next()){
			String no = rs.getString("no");
			String photos 	= rs.getString("photos");
			String serial_no = rs.getString("serial_no");
			String price = rs.getString("price");
			ProductDto dto = new ProductDto(no, photos, serial_no, price);
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
>>>>>>> refs/remotes/origin/main
}
