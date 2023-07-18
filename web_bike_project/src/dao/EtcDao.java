package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBConnection;
import dto.EtcDto;

public class EtcDao {
	Connection 			con = null;
	PreparedStatement   ps  = null;
	ResultSet		    rs  = null;
	
	//글쓰기시 글 저장
	public int etcSaveTitle(EtcDto dto){
		int result = 0;
		String query="";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("etcSaveTitle()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
		
	//댓글달시 댓글 저장
}
