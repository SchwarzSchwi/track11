package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.EtcDto;
import dto.QnaDto;

public class EtcDao {
	Connection 			con = null;
	PreparedStatement   ps  = null;
	ResultSet		    rs  = null;
	
	
//목록수
	public int getTotalCount(String select,String search) {
		int count = 0;
		String query="select count(*) as count\r\n" + 
				"from bike_최선우_etc\r\n" + 
				"where "+select+" like '%"+search+"%'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		}catch(Exception e) {
			System.out.println("getTotalCount()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
//목록
public ArrayList<EtcDto> getEtcListPage(String select,String search,int start,int end){
	ArrayList<EtcDto> dtos = new ArrayList<>();
	String query ="select *\r\n" + 
			"from\r\n" + 
			"(select rownum as rnum, tbl.* \r\n" + 
			"from \r\n" + 
			"(\r\n" + 
			"select etcno, groupno, grouporder, depth, title,\r\n"+
			"to_char(regdate,'yyyy-mm-dd') as regdate, regid\r\n" +
			"from bike_최선우_etc\r\n" +
			"where "+select+" like '%"+search+"%'\r\n" + 
			"order by regdate desc\r\n" +
			") tbl)\r\n" + 
			"where rnum >="+start+" and rnum <="+end+"";
	try {
		con = DBConnection.getConnection();
		ps  = con.prepareStatement(query);
		rs  = ps.executeQuery();
		while(rs.next()) {
			int etcno	= rs.getInt("etcno");
			int groupno	= rs.getInt("groupno");
			int grouporder	= rs.getInt("grouporder");
			int depth	= rs.getInt("depth");
			String title	= rs.getString("title");
			String regdate	= rs.getString("regdate");
			String regid	= rs.getString("regid");
			EtcDto  dto  = new EtcDto(etcno, groupno, grouporder, depth, title, regdate, regid);
			dtos.add(dto);
		}
	}catch(Exception e) {
		System.out.println("getEtcListPage()오류:"+query);
		e.printStackTrace();
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return dtos;
}
	
	
	
//글쓰기시 글 저장
	public int etcSave(EtcDto dto){
		int result = 0;
		String query="insert into bike_최선우_etc\r\n" + 
				"(etcno, groupno, grouporder, depth, title, regdate, regid)\r\n" + 
				"values\r\n" + 
				"('"+dto.getEntno()+"','"+dto.getGroupno()+"','"+dto.getGrouporder()+"',\r\n"+
				"'"+dto.getDepth()+"','"+dto.getTitle()+"',to_date('"+dto.getRegdate()+"','yyyy-mm-dd hh24:mi:ss'),\r\n"+
				"'"+dto.getRegid()+"')";
		System.out.println(query);
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("etcSave()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	//게시글 번호 생성
	public int getMaxNo() { // N001 N002 N003
		int etcno=0;
		String query="select nvl(max(etcno),'0') as etcno\r\n" + 
				     "from bike_최선우_etc";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				etcno = rs.getInt("etcno"); // "N000"
				int n = etcno; // 1
				n = n + 1; // 2 
				etcno = n;
				
			}
		}catch(Exception e) {
			System.out.println("getMaxNo() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return etcno;
	}
}

		
	//댓글달시 댓글 저장

