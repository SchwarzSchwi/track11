package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Cstudent_최선우_dao {
	Connection 		  con = null;
	PreparedStatement ps  = null;
	ResultSet         rs  = null;	
	
	// 등록
	public int studentSave(Cstudent_최선우_dto dto){
		int result =0;
		String query ="insert into E_최선우_Educatee\r\n" + 
				"(id, name, age)\r\n" + 
				"values\r\n" + 
				"('"+dto.getId()+"','"+dto.getName()+"',"+dto.getAge()+")";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("studentSave() 오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
		return result;
	}
	//학생조회
	public ArrayList<Cstudent_최선우_dto> getSearchList(String gubun, String search) {
		ArrayList<Cstudent_최선우_dto> dtos = new ArrayList<>();
		String query = "SELECT ID,NAME,AGE\r\n" + 
				"FROM E_최선우_EDUCATEE\r\n" + 
				"WHERE "+gubun+" LIKE '%"+search+"%'\r\n" + 
				"ORDER BY ID DESC";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();	
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Cstudent_최선우_dto dto = new Cstudent_최선우_dto(id,name,age);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getSearchList() 오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	//출력
	public void print(ArrayList<Cstudent_최선우_dto> dtos) {
		System.out.println("===================");
		System.out.println("ID\t성명\t나이\t");
		System.out.println("-------------------");
		
		if(dtos.size() == 0)System.out.println("\t내용없음");
		
		for(int k=0; k<dtos.size(); k++) {
			System.out.print(dtos.get(k).getId()+"\t");
			System.out.print(dtos.get(k).getName()+"\t");
			System.out.print(dtos.get(k).getAge()+"\n");
		}
	}
	//상세조회
	public Cstudent_최선우_dto getStudentInfo(String id) {
		Cstudent_최선우_dto dto = null;
		String query = "SELECT ID,NAME,AGE\r\n" + 
				"FROM E_최선우_EDUCATEE\r\n" + 
				"WHERE ID = '"+id+"'"; 
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				int age     = rs.getInt("age");
				dto = new Cstudent_최선우_dto(id, name, age);
			}
		}catch(Exception e) {
			System.out.println("getStudentInfo() 오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
				
		return dto;
	}
	//개인정보 출력
	public void printinfo(Cstudent_최선우_dto dto) {
		System.out.println("===================");
		System.out.println("ID\t성명\t나이\t");
		System.out.println("-------------------");
		System.out.print(dto.getId()+"\t");
		System.out.print(dto.getName()+"\t");
		System.out.print(dto.getAge()+"\n");
		System.out.println("-------------------");	
	}
	//수정
	public int studentUpdate(Cstudent_최선우_dto updateDto) {
		int result = 0;
		String query = "UPDATE E_최선우_EDUCATEE\r\n" + 
				"SET NAME = '"+updateDto.getName()+"',\r\n" + 
				"    AGE = "+updateDto.getAge()+"\r\n" + 
				"WHERE ID = '"+updateDto.getId()+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result  = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("studentUpdate() 오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	//삭제
	public int studentDelete(String id) {
		int result = 0;
		String query = "DELETE FROM E_최선우_EDUCATEE\r\n" + 
				"WHERE ID = '"+id+"'";
		System.out.println(query);
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();			
		}catch(Exception e) {
			System.out.println("studentDelete() 오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
		return result;
	}
	

}



