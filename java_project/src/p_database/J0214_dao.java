package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class J0214_dao {
//	String name;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
//	성명조회
	String getName(String id) {
		String name="";
		String query = "SELECT NAME FROM MEMBER\r\n" + 
				"WHERE ID = '"+id+"' ";
		
			try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
//				name = rs.getString(1);
				name = rs.getString("name");
				
			}
		} catch (SQLException e) {
			System.out.println("getName() :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return name;
	}
//	회원정보 조회
	J0214_dto getMemberInfo(String id){
		J0214_dto dto = null;
		String query  ="SELECT ID, NAME, AREA, AGE\r\n" + 
				"FROM MEMBER\r\n" + 
				"WHERE ID ='"+id+"'";	
				new J0214_dto("A001","홍길동","대전",25);
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
//				String idd  = rs.getNString(1);
//				String name = rs.getString(2);
//				String area = rs.getNString(3);
//				String age  = rs.getNString(4);
				String idd  = rs.getNString("id");
				String name = rs.getString("name");
				String area = rs.getNString("area");
				String age  = rs.getNString("age");
			}
		}catch(SQLException e){
			System.out.println("getMemberInfo()"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
//	회원목록 조회
	ArrayList<J0214_dto>getMemberList(String search){
		ArrayList<J0214_dto> dtos = new ArrayList<>();
		String query="SELECT ID,NAME, AREA, AGE\r\n" + 
				"FROM MEMBER \r\n" + 
				"WHERE NAME LIKE '%"+search+"%'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String area = rs.getString("area");
				int age	= rs.getInt("age");
				J0214_dto dto = 
						new J0214_dto(id, name, area, age);
				dtos.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("getMemberList() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con,  ps, rs);
		}
		return dtos;
	}
	
}
