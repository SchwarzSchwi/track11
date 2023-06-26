package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBConnection;
import dto.MemberDto;

public class MemberDao {
	Connection 		  con = null;
	PreparedStatement ps  = null;
	ResultSet 		  rs  = null;
	//ID 중복검사
	public int checkId(String id) {
		int count =0;
		String query="select count(*) as count\r\n" + 
				"from home_최선우_member\r\n" + 
				"where id = '"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		}catch(Exception e) {
			System.out.println("checkID()오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
		
	}
	//정보수정
	public int memberUpdate(MemberDto dto) {
		int result =0;
		String query = "update home_최선우_member\r\n" + 
				"set name='"+dto.getName()+"',\r\n" + 
				"    job ='"+dto.getJob()+"',   \r\n" + 
				"    tell_1='"+dto.getTell_1()+"',\r\n" + 
				"    tell_2='"+dto.getTell_2()+"',\r\n" + 
				"    tell_3='"+dto.getTell_3()+"',\r\n" + 
				"    mobile='"+dto.getMobile()+"',\r\n" + 
				"    email='"+dto.getEmail()+"'\r\n" + 
				"where id = '"+dto.getId()+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("memberUpdate()오류:"+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	//비밀번호 확인
	public int getCheckPassword(String id, String password){
		int count = 0;
		String query="select count(*) as count\r\n" + 
				"from home_최선우_member\r\n" + 
				"where id = '"+id+"'\r\n" + 
				"and password = '"+password+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		}catch(Exception e) {
			System.out.println("getCheckPassword()오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
	
	//상세보기
	public MemberDto memberView(String id){
		MemberDto dto = null;
		String query="select id,name,job,\r\n" + 
				" tell_1,tell_2,tell_3,\r\n" + 
				" mobile,email,\r\n" + 
				" to_char(reg_date,'yyyy-MM-dd') as reg_date\r\n" + 
				" from home_최선우_member\r\n" + 
				" where id ='"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()){
				String name 	= rs.getString("name");
				String job      = rs.getString("job");
				String tell_1   = rs.getString("tell_1");
				String tell_2   = rs.getString("tell_2");
				String tell_3   = rs.getString("tell_3");
				String mobile   = rs.getString("mobile");
				String email    = rs.getString("email");
				String reg_date = rs.getString("reg_date");
				
				dto = new MemberDto(id, name, "", job, 
						            tell_1, tell_2, tell_3, 
						            mobile, email, reg_date);
			}
		}catch(Exception e) {
			System.out.println("memberView() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return dto;
	}
	
	//로그인
	public String checkLogin(String id, String password){
		String name="";
		String query="select name\r\n" + 
				" from home_최선우_member\r\n" + 
				" where id ='"+id+"'\r\n" + 
				" and password ='"+password+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()){
				name = rs.getString("name");
			}
		}catch(Exception e) {
			System.out.println("checkLogin() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return name;
	}
	
	// 회원가입
	public int  memberJoin(MemberDto dto){
		int result  = 0;
		String query="insert into home_최선우_member\r\n" + 
				"(id,name,password,job,\r\n" + 
				"tell_1,tell_2,tell_3,\r\n" + 
				"mobile,email,reg_date)\r\n" + 
				"values\r\n" + 
				"('"+dto.getId()+"','"+dto.getName()+"','"+dto.getPassword()+"','"+dto.getJob()+"','"+dto.getTell_1()+"','"+dto.getTell_2()+"','"+dto.getTell_3()+"','"+dto.getMobile()+"','"+dto.getEmail()+"','"+dto.getReg_date()+"')";


		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("memberJoin() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return result;
	}
	
	// 암호화
    public String encryptSHA256(String value) throws NoSuchAlgorithmException{
        String encryptData ="";
         
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update(value.getBytes());
 
        byte[] digest = sha.digest();
        for (int i=0; i<digest.length; i++) {
            encryptData += Integer.toHexString(digest[i] &0xFF).toUpperCase();
        }
         
        return encryptData;
    }
	
}
