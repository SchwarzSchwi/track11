package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Consulting_최선우_dao {
	Connection 		  con = null;
	PreparedStatement ps  = null;
	ResultSet 		  rs  = null;
	//조회
	public ArrayList<Consulting_최선우_dto> consultingList(String gubun, String search) {
		ArrayList<Consulting_최선우_dto> dtos = new ArrayList<>();
		String query = "select c.no,c.sid,e.name as stuname,c.mid,m.name as mentorname,\r\n" + 
				"    to_char(cdate,'YYYY-MM-DD') as cdate\r\n" + 
				"FROM E_최선우_CONSULTING c,\r\n" + 
				"     E_최선우_EDUCATEE e,  \r\n" + 
				"     E_최선우_MENTOR m\r\n" + 
				"WHERE c.sid = e.id and c.mid = m.id and "+gubun+" like '%"+search+"%'\r\n" + 
				"order by c.no";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String sid = rs.getString("sid");
				String mid = rs.getString("mid");
				String cdate = rs.getString("cdate");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
			}
		}catch(Exception e) {
			System.out.println("consultingList() 오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
		
	}

	public void getPrint(ArrayList<Consulting_최선우_dto> dtos) {
		// TODO Auto-generated method stub
		
	}

}
