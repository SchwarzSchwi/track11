package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.StudentDto;

public class StudentDao {
	Connection			con = null; 
	PreparedStatement	ps	= null;
	ResultSet			rs  = null;
	

	//삭제
	public int studentDelete(String syear, String sclass, String sno) {
		int result = 0;
		String query="DELETE FROM H_최선우_STUDENT\r\n" + 
				"WHERE syear = '"+syear+"'\r\n" + 
				"and sclass = '"+sclass+"'\r\n" + 
				"and sno = '"+sno+"'";
		try {
			con     = DBConnection.getConnection();
			ps      = con.prepareStatement(query);
			result  = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("studentDelete() 오류 :"+query);
		}finally {
		DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//수정저장
	public int studentUpdate(StudentDto dto) {
		int result =0;
		String query="update h_최선우_student\r\n" + 
				"set name = '"+dto.getName()+"',\r\n" + 
				"    kor ="+dto.getKor()+",\r\n" + 
				"    eng ="+dto.getEng()+",\r\n" + 
				"    mat ="+dto.getMat()+",\r\n" + 
				"    total ="+dto.getTotal()+",\r\n" + 
				"    ave ="+dto.getAve()+"\r\n" + 
				"where syear='"+dto.getSyear()+"'\r\n" + 
				"and sclass='"+dto.getSclass()+"'\r\n" + 
				"and sno='"+dto.getSno()+"'";
		try {
			con     = DBConnection.getConnection();
			ps		= con.prepareStatement(query);
			result  = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("studentUpdate() 오류 :"+query);
			e.printStackTrace();
		}finally {
		DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	//상세조회
	public StudentDto getStudentView(String syear, String sclass, String sno) {
		StudentDto dto = null;
		String query ="select syear, sclass, sno, name, kor, eng, mat, total, \r\n" + 
				"to_char(ave,'999.99') as ave\r\n" + 
				"from h_최선우_student\r\n" + 
				"where syear='"+syear+"'\r\n" + 
				"and sclass='"+sclass+"'\r\n" + 
				"and sno='"+sno+"'";			
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int total = rs.getInt("total");
				double ave = rs.getDouble("ave");
				dto = new StudentDto(syear, sclass, sno, name, kor, eng, mat, total, ave);
			}
		}catch(Exception e) {
			System.out.println("getStudentlist() 오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//목록조회
	public ArrayList<StudentDto> getStudentList(String searchYear, String select, String search){
		ArrayList<StudentDto>dtos = new ArrayList<>();
		
//		if(searchYear.equals("all")) {
//			String sql ="select syear, sclass, sno, name\r\n" + 
//					"from h_최선우_student\r\n" + 
//					"order by syear, sclass, to_number(sno)"
//		} else {
//			String sql ="select syear, sclass, sno, name\r\n" + 
//					"from h_최선우_student\r\n" + 
//					"where syear = '1'\r\n" + 
//					"order by syear, sclass, to_number(sno);"
//		}
//		
	      String query="select syear, sclass, sno, name\r\n" + 
	                 " from h_최선우_student\r\n";
	      
	            if(searchYear.equals("all")){
	               query = query +" where "+select+" like '%"+search+"%'";
	            }else{
	               query = query +" where syear = '"+searchYear+"'"+
	                                " and "+select+" like '%"+search+"%'";
	            }
	            
	            query = query +" order by syear, sclass, to_number(sno)";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String syear   = rs.getString("syear");
				String sclass  = rs.getString("sclass");
				String sno     = rs.getString("sno");
				String name    = rs.getString("name");
				StudentDto dto = new StudentDto(syear, sclass, sno, name);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getStudentlist() 오류"+query);
			e.printStackTrace();
		}
		
		return dtos;
	}
	
	//학년,반,번호 중복검사
	public int getCheck(String syear,String sclass,String sno) {
		int count =0;
		String query="select count(*) as count from h_최선우_student\r\n" + 
				"where syear = '"+syear+"'\r\n" + 
				"and sclass = '"+sclass+"'\r\n" + 
				"and sno = '"+sno+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs	= ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		}catch(Exception e) {
			System.out.println("getCheck() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}		
	
	//등록
	public int studentSave(StudentDto dto) {
		int result =0;
		String query="insert into H_최선우_STUDENT\r\n" + 
				"(SYEAR, SCLASS, SNO, NAME, KOR, ENG, MAT, TOTAL, AVE)\r\n" + 
				"VALUES\r\n" + 
				"('"+dto.getSyear()+"','"+dto.getSclass()+"','"+dto.getSno()+"','"+dto.getName()+"',"+dto.getKor()+","+dto.getEng()+","+dto.getMat()+","+dto.getTotal()+","+dto.getAve()+")";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("studentSave() 오류 :"+query);
			e.printStackTrace();
		}finally {
		DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	
	//총점
	public int getTotal(String k, String e, String m){
		int total = Integer.parseInt(k)+
				Integer.parseInt(e)+
				Integer.parseInt(m);
		return total;
	}
	//평균
	public double getAve(int total, int count) {
		DecimalFormat df = new DecimalFormat("##.0#");
		double ave = total / (double)count; // 275 / 3.0
		String result = df.format(ave); //"91.67"
//System.out.println("======"+Double.parseDouble(result));
		return Double.parseDouble(result);//91.67
	}
}
