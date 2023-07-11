package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.ManageDto;
import dto.ProductDto;

public class ManageDao {
	Connection 			con = null;
	PreparedStatement 	ps  = null;
	ResultSet 			rs  = null;		
	
	//수정
	public int manageUpdate(ManageDto dto){
		int result =0;
		String query="update bike_최선우_productsale\r\n" + 
				"set now_status ='"+dto.getNow_status()+"'\r\n" + 
				"	 where order_no ='"+dto.getOrder_no()+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("manageUpdate()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return result;
	}
	
	//manage 상세보기
	public ManageDto getManageView(String order_no) {
		ManageDto dto = null;
		String query = "select n.order_no,n.now_status,n.serial_no,n.consumer_id,\r\n" + 
				"m.name,l.photos,n.payment,to_char(n.price,'999,999,999')as price, \r\n" + 
				"to_char(n.purchase_date,'yyyy-MM-dd hh24:mi:ss')as purchase_date, \r\n" + 
				"n.post_no,n.address,n.detail_address \r\n" + 
				"from bike_최선우_productsale n, bike_최선우_member m, bike_최선우_product l\r\n" + 
				"where n.consumer_id = m.id\r\n" + 
				"and n.serial_no = l.serial_no\r\n" + 
				"and order_no = '"+order_no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()){
				String now_status 	= rs.getString("now_status");
				String serial_no = rs.getString("serial_no");
				String consumer_id = rs.getString("consumer_id");
				String name			= rs.getString("name");
				String photos		= rs.getString("photos");
				String payment = rs.getString("payment");
				String price = rs.getString("price");
				String purchase_date   = rs.getString("purchase_date");
				String post_no = rs.getString("post_no");
				String address = rs.getString("address");
				String detail_address = rs.getString("detail_address");
				
				dto = new ManageDto(order_no, now_status, serial_no, consumer_id, name, photos, payment,
						price, purchase_date, post_no, address, detail_address);
			}
		}catch(Exception e) {
			System.out.println("getManageView()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return dto;
	}
	//manage 목록
	public ArrayList<ManageDto> getManageList(String select, String search, int start, int end) {
		ArrayList<ManageDto> dtos = new ArrayList<>();
		String query ="select *\r\n" + 
				"from\r\n" + 
				"(select rownum as rnum, tbl.*\r\n" + 
				"from\r\n" + 
				"(select order_no, now_status, serial_no,\r\n" + 
				"consumer_id, to_char(price,'999,999,999')as price,\r\n" + 
				"to_char(purchase_date,'yyyy-MM-dd hh24:mi:ss')as purchase_date \r\n" + 
				"from bike_최선우_productsale \r\n" + 
				"where "+select+" like '%"+search+"%'" +
				"order by order_no desc\r\n" +
				")tbl)\r\n" +
				"where rnum >= "+start+" and rnum <= "+end+"";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()){
				String order_no    = rs.getString("order_no");
				String now_status  = rs.getString("now_status");
				String serial_no   = rs.getString("serial_no");
				String consumer_id = rs.getString("consumer_id");
				String purchase_date = rs.getString("purchase_date");
				String price = rs.getString("price");
				ManageDto dto = new ManageDto(order_no, now_status, serial_no, 
												consumer_id, purchase_date, price);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getManageList()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}			
		return dtos;
	}
	//게시글 수
	public int getTotalCount(String select, String search) {
		int count = 0;
		String query ="select count(*) as count \r\n" + 
				" from bike_최선우_productsale\r\n" + 
				" where "+select+" like '%"+search+"%' "+
				" order by purchase_date desc";
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
