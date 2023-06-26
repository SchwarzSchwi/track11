package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class J0216_student_dao{
	Connection 			con = null;
	PreparedStatement 	ps  = null;
	ResultSet 			rs  = null;
	
	public ArrayList<J0216_student_dto> getStudentList() {
		ArrayList<J0216_student_dto> dtos =
									new ArrayList<>();
		String query ="select id, name, kor, eng, mat, total, result \r\n" + 
				      " from e_홍길동_student \r\n" + 
				      " order by id desc";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()){
				String id   = rs.getString("id");
				String name = rs.getString("name");
				int kor     = rs.getInt("kor"); 
				int eng     = rs.getInt("eng");
				int mat     = rs.getInt("mat");
				int total   = rs.getInt("total");
				String result = rs.getString("result");
				J0216_student_dto dto =
						new J0216_student_dto(id, name, kor, eng, mat, total, result);
				dtos.add(dto);
			}
		}catch(SQLException e){
			System.out.println("getStudentList() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dtos;
	}

	public void resultPrint(ArrayList<J0216_student_dto> dtos) {
		System.out.println("=========================================");
		System.out.println("ID\t성명\t국어\t영어\t수학\t총점\t결과");
		System.out.println("-----------------------------------------");
		if(dtos.size() == 0) {
			System.out.println("\t\t\t정보 없음");
		}
		for(int k=0; k< dtos.size(); k++) {
			System.out.print(dtos.get(k).getId()+"\t");
			System.out.print(dtos.get(k).getName()+"\t");
			System.out.print(dtos.get(k).getKor()+"\t");
			System.out.print(dtos.get(k).getEng()+"\t");
			System.out.print(dtos.get(k).getMat()+"\t");
			System.out.print(dtos.get(k).getTotal()+"\t");
			System.out.print(dtos.get(k).getResult()+"\n");
		}
		System.out.println("-----------------------------------------\n");
	}

	public ArrayList<J0216_student_dto> 
				getSearchList(String gubun, String search) {
		ArrayList<J0216_student_dto> dtos =
									new ArrayList<>();
		String query="select id, name, kor, eng, mat, total, result\r\n" +
					"from e_최선우_student \r\n" +
					"where " +gubun+" like '%"+search+"%' \r\n" +
					" order by id desc ";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String id    = rs.getString("id");
				String name  = rs.getString("name");
				int kor      = rs.getInt("kor");
				int eng      = rs.getInt("eng");
				int mat      = rs.getInt("mat");
				int total    = rs.getInt("total");
				String result= rs.getString("result");
				J0216_student_dto dto =
						new J0216_student_dto(id, name, kor, eng, mat, total, result);
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
				
	public int getTotal(int kor, int eng, int mat) {
		int total=0;
		return kor + eng + mat;
	}

	public String getResult(int total) {
		String result="";
		double ave = total / 3.0;
		if(ave >=90) result="수";
		else if(ave >=80) result="우";
		else if(ave >=70) result="미";
		else if(ave >=60) result="양";
		else result="가";
		
		return result;
	}
	
//등록
	public int saveStudent(J0216_student_dto dto) {
		int result = 0;
		String query="INSERT INTO E_최선우_STUDENT\r\n" + 
				" (ID, NAME, KOR, ENG, MAT, TOTAL, RESULT)\r\n" + 
				" VALUES\r\n" + 
				" ('"+dto.getId()+"','"+dto.getName()+"',"+dto.getKor()+","+dto.getEng()+","+dto.getMat()+","+dto.getTotal()+",'"+dto.getResult()+"')";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result  = ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("saveStudent() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
// 상세정보 조회
	public J0216_student_dto getStudentInfo(String id) {
		J0216_student_dto dto = null;
		String query="SELECT ID, NAME, KOR, ENG, MAT, TOTAL, RESULT\r\n" +
				"FROM E_최선우_STUDENT\r\n" +
				"WHERE ID = '"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
//				String idd  = rs.getString("id");
				String name = rs.getString("name");
				int kor      = rs.getInt("kor");
				int eng      = rs.getInt("eng");
				int mat      = rs.getInt("mat");
				int total    = rs.getInt("total");
				String result= rs.getString("result");
			}
		}catch(SQLException e) {
			System.out.println("getStudentInfo() 오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
		return dto;
	}

	public int updateStudent(J0216_student_dto dto) {
		int result = 0;
		String query="UPDATE E_최선우_STUDENT\r\n" + 
				"SET NAME = '"+dto.getName()+"',\r\n" + 
				"    KOR = "+dto.getKor()+",\r\n" + 
				"    ENG = "+dto.getEng()+",\r\n" + 
				"    MAT = "+dto.getMat()+",\r\n" + 
				"    TOTAL = "+dto.getTotal()+",\r\n" + 
				"    RESULT = '"+dto.getResult()+"'\r\n" + 
				"WHERE ID = '"+dto.getId()+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result  = ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("saveStudent() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}

	public int deleteStudent(String id) {
		int result = 0;
		String query="DELETE FROM E_최선우_STUDENT\r\n" + 
				"WHERE ID ='"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("deleteStudent() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

}














