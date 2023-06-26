package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class J0221_최선우_dao {
	Connection          con = null;
	PreparedStatement   ps  = null;
	ResultSet           rs  = null;
	
	public ArrayList<J0221_최선우_dto> getSearchList(String gubun, String search){
		ArrayList<J0221_최선우_dto> dtos =
								new ArrayList<>();
		String query="SELECT ID, NAME, AREA, AGE \r\n" + 
				"FROM E_최선우_MEMBER\r\n" + 
				"WHERE "+gubun+" LIKE '%"+search+"%'\r\n" + 
				"ORDER BY ID ASC";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String id    = rs.getString("id");
				String name  = rs.getString("name");
				String area  = rs.getString("area");
				int age      = rs.getInt("age");
				J0221_최선우_dto dto =
						new J0221_최선우_dto(id, name, area, age);
				dtos.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("getSearchList 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	public void resultPrint(ArrayList<J0221_최선우_dto>dtos) {
		System.out.println("================================");
		System.out.println("id\t성명\t지역\t나이");
		System.out.println("--------------------------------");
		if(dtos.size() == 0) {
			System.out.println("\t\t\t정보 없음");
		}
		for(int k=0; k< dtos.size(); k++) {
			System.out.print(dtos.get(k).getId()+"\t");
			System.out.print(dtos.get(k).getName()+"\t");
			System.out.print(dtos.get(k).getArea()+"\t");
			System.out.print(dtos.get(k).getAge()+"\n");
		}
		System.out.println("---------------------------------\n");
	}
	//등록	
	public int saveMember(J0221_최선우_dto dto) {
		int result = 0;
		String query ="INSERT INTO E_최선우_MEMBER\r\n" + 
				"(ID, NAME, AREA, AGE)\r\n" + 
				"VALUES\r\n" + 
				"('"+dto.getId()+"','"+dto.getName()+"','"+dto.getArea()+"',"+dto.getAge()+")";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("saveMember() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	
	}//수정
	public J0221_최선우_dto getMemberInfo(String id) {
		J0221_최선우_dto dto = null;
		String query ="SELECT ID, NAME, AREA, AGE\r\n" + 
				"FROM E_최선우_MEMBER\r\n" + 
				"WHERE ID = '"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				String area = rs.getString("area");
				int age = rs.getInt("age");
				dto = new J0221_최선우_dto(id, name, area, age);
				
			}
		}catch(SQLException e) {
			System.out.println("getMemberInfo() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	public int updateResult(J0221_최선우_dto dto2) {
		int result = 0;
		String query ="UPDATE E_최선우_MEMBER\r\n" + 
				"SET NAME ='"+dto2.getName()+"'\r\n" + 
				"    AREA = '"+dto2.getArea()+"'\r\n" + 
				"    AGE = "+dto2.getAge()+"\r\n" + 
				"WHERE ID = '"+dto2.getId()+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("updateResult() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}//삭제
	public int deleteMember(String id) {
		int result = 0;
		String query = "DELETE FROM E_최선우_MEMBER\r\n" + 
				"WHERE ID ='"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("deletMember() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

}
