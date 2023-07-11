package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.ManageDto;
import dto.OrderDto;

public class OrderDao {
	Connection 			con = null;
	PreparedStatement 	ps  = null;
	ResultSet 			rs  = null;		
	
	//order 취소
	public int orderCancel(String no) {
		int result =0;
		String query ="update bike_최선우_productsale set now_status='주문취소'\r\n" + 
				"where order_no ='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("orderCancel()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
		return result;
	}
	
	//order 상세보기
	public OrderDto getOrderView(String order_no) {
		OrderDto dto = null;
		String query = "select n.order_no,n.now_status,n.serial_no,n.consumer_id,\r\n" + 
				"m.name,l.photos,n.payment,to_char(n.price,'999,999,999')as price, \r\n" + 
				"to_char(n.purchase_date,'yyyy-MM-dd hh24:mi:ss')as purchase_date, \r\n" + 
				"n.post_no,n.address,n.detail_address \r\n" + 
				"from bike_최선우_productsale n, bike_최선우_member m, bike_최선우_product l\r\n" + 
				"where n.consumer_id = m.id\r\n" + 
				"and n.serial_no = l.serial_no\r\n" + 
				"and order_no = '"+order_no+"'";
		System.out.println(query);
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
				
				dto = new OrderDto(order_no, now_status, serial_no, consumer_id, name, photos, payment,
						price, purchase_date, post_no, address, detail_address);
			}
		}catch(Exception e) {
			System.out.println("getOrderView()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return dto;
	}
	//order 목록
	public ArrayList<OrderDto> getOrderList(String select, String search, int start, int end, String id) {
		ArrayList<OrderDto> dtos = new ArrayList<>();
		String query ="select *\r\n" + 
				"from\r\n" + 
				"(select rownum as rnum, tbl.*\r\n" + 
				"from\r\n" + 
				"(select order_no, now_status, serial_no,\r\n" + 
				"consumer_id, to_char(price,'999,999,999') as price,\r\n" + 
				"to_char(purchase_date,'yyyy-MM-dd')as purchase_date \r\n" + 
				"from bike_최선우_productsale \r\n" + 
				"where "+select+" like '%"+search+"%' and consumer_id ='"+id+"')tbl)\r\n" + 
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
				OrderDto dto = new OrderDto(order_no, now_status, serial_no, 
												consumer_id, purchase_date, price);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getOrderList()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}			
		return dtos;
	}
	//주문상품 수
	public int getTotalCount(String select, String search, String id) {
		int count = 0;
		String query ="select count(*) as count \r\n" + 
				" from bike_최선우_productsale\r\n" + 
				" where "+select+" like '%"+search+"%' and consumer_id = '"+id+"' "+
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
