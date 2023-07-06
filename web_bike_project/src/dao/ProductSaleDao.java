package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import common.DBConnection;
import dto.ProductSaleDto;

public class ProductSaleDao {
	
	Connection 			con = null;
	PreparedStatement 	ps  = null;
	ResultSet 			rs  = null;		
	
	//주문번호 생성
	public String getMaxNo() { // N001 N002 N003
		String no="";
		String query="select nvl(max(order_no),'N000') as order_no\r\n" + 
				     "from bike_최선우_productsale";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("order_no"); // "N000"
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
	
	//구매
	public int Purchase(ProductSaleDto dto){
		int result = 0;
		/*
		String query="insert into home_최선우_news\r\n" + 
				"(no,title,content,attach,reg_id,reg_date) "+
				"values\r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getAttach()+"','"+dto.getReg_id()+"','"+dto.getReg_date()+"')";
		*/
		String query="insert into bike_최선우_productsale\r\n" + 
				"(order_no, now_status, serial_no, consumer_id, payment,\r\n" + 
				"price, purchase_date, post_no, address, detail_address)\r\n" + 
				"values\r\n" + 
				"('"+dto.getOrder_no()+"','"+dto.getNow_status()+"','"+dto.getSerial_no()+"','"+dto.getConsumer_id()+"','"+dto.getPayment()+"',\r\n" + 
				"'"+dto.getPrice()+"',to_date('"+dto.getPurchase_date()+"','yyyy-MM-dd hh24:mi:ss'),'"+dto.getPost_no()+"','"+dto.getAddress()+"','"+dto.getDetail_address()+"')"; 
			
		
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("purchase() 오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
}
