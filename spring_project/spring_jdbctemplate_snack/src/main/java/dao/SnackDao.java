package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.SnackDto;

public class SnackDao {
	Connection        con = null;
	PreparedStatement  ps = null;
	ResultSet 		   rs = null;

	
//중복체크
	public int checkPcode(String p_code) {
		int count = 0;
		String query ="select count(*) as count \r\n" + 
				"from h_최선우_snack\r\n" + 
				"where p_code ='"+p_code+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		}catch(Exception e) {
			System.out.println("checkPcode() 오류 :"+query);
			e.printStackTrace();
		}finally {
		DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
//삭제
	public int snackDelete(String p_code) {
		int result = 0;
		String query = "delete from h_최선우_snack\r\n" + 
				"where p_code = '"+p_code+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result  = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("snackDelete() 오류 :"+query);
			e.printStackTrace();
		}finally {
		DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
//수정저장
	public int snackUpdate(SnackDto dto){
		int result =0;
		String query = "update h_최선우_snack\r\n" + 
				"set p_name ='"+dto.getP_name()+"',\r\n" + 
				"m_code ='"+dto.getM_code()+"',\r\n" + 
				"price ="+dto.getPrice()+"\r\n" + 
				"where p_code ='"+dto.getP_code()+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result  = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("snackUpdate() 오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
//상세조회
	public SnackDto getSnackView(String p_code) {
		SnackDto dto = null;
		String query = "select s.p_code, s.p_name,\r\n" + 
				"        c.m_code, c.m_name, \r\n" + 
				"        to_char(s.price,'999,999') as price\r\n" + 
				"from h_최선우_snack s,\r\n" + 
				"    commonsnack c\r\n" + 
				"where s.m_code = c.m_code\r\n" + 
				"and s.p_code = '"+p_code+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String p_name = rs.getString("p_name");
				String m_code = rs.getString("m_code");
				String m_name = rs.getString("m_name");
				String strPrice = rs.getString("price");
				dto = new SnackDto(p_code, p_name, m_code, m_name, strPrice);
			}
		}catch(Exception e) {
			System.out.println("getSnackView() 오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}

//목록조회
	public ArrayList<SnackDto> getSnackList(String select,String search){
		ArrayList<SnackDto> dtos = new ArrayList<>();
		String query="select s.p_code, s.p_name,\r\n" + 
				"        c.m_name, \r\n" + 
				"        to_char(s.price,'999,999') as price\r\n" + 
				"from h_최선우_snack s,\r\n" + 
				"    commonsnack c\r\n" + 
				"where s.m_code = c.m_code\r\n" + 
				"and "+select+" like '%"+search+"%'" +
				"order by p_code desc";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String p_code = rs.getString("p_code");
				String p_name = rs.getString("p_name");
				String m_name = rs.getString("m_name");
				String strprice = rs.getString("price");
				SnackDto dto = new SnackDto(p_code, p_name, m_name, strprice);
				dtos.add(dto);
			}	
		}catch(Exception e) {
			System.out.println("getSnacklist() 오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB( con, ps, rs);
		}
		return dtos;
	}
	
//제품등록	
	public int snackSave(SnackDto dto) {
		int result = 0;
		String query="insert into h_최선우_snack\r\n" + 
				"(p_code,p_name,price,m_code)\r\n" + 
				"values\r\n" + 
				"('"+dto.getP_code()+"','"+dto.getP_name()+"','"+dto.getPrice()+"',"+dto.getM_code()+")";
		System.out.println(query);
		try {
			con = DBConnection.getConnection();
			ps	= con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("snackSave() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return result;
	}
//제조사 목록	
	public ArrayList<SnackDto> getCompanyList(){
		ArrayList<SnackDto> dtos = new ArrayList();
		String query="select m_code, m_name\r\n" + 
				"from commonsnack\r\n" + 
				"order by m_name";
		try {
			con = DBConnection.getConnection();
			ps	= con.prepareStatement(query);
			rs 	= ps.executeQuery();
			while(rs.next()) {
				String m_code = rs.getString("m_code");
				String m_name = rs.getString("m_name");
				SnackDto dto = new SnackDto(m_code, m_name);
				
//				SnackDto dto = new SnackDto(rs.getString("m_name"));
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getCompanyList() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return dtos;
	}
}
