package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.EtcDto;

public class EtcDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
//		dao.deleteDB(no);
	public void deleteDB(String no) {
		String sql1 = "select step from bike_최선우_etc where no = '"+no+"'";
		String sql2 = "";
		String sql3 = "";
		int step = 0;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			if(rs.next()) step = rs.getInt("step");
			
			sql2 = "delete bike_최선우_etc where no = '"+no+"'";
			ps = con.prepareStatement(sql2);
			int k = ps.executeUpdate();
			
			if(k==1) {
				sql3 = "update bike_최선우_etc set step=step-1 where step>"+step;
				ps = con.prepareStatement(sql3);
				ps.execute();
			}else {
				System.out.println("deleteDB 삭제 오류:"+sql2);
			}
		}catch(SQLException e) {
			System.out.println("deleteDB\nsql1:"+sql1+"\nsql2:"+sql2+"\nsql3:"+sql3);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	
	public void insertDB(EtcDto dto) {
		int step=0; int depth=0;
		boolean tf = dto.getNo().equals(dto.getReply());
		
		String sql1 = "select step, depth from bike_최선우_etc where no = '"+dto.getReply()+"'";
		String sql2 = "update bike_최선우_etc set step=step+1 ";
		String sql3 = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			if(rs.next()) {
				step = rs.getInt("step")+1;
				System.out.println(step);
				depth = rs.getInt("depth")+1;
				System.out.println(depth);
			}
			
			if(!tf) sql2 += "where step>="+step;
			ps = con.prepareStatement(sql2);
			ps.execute();
			
			sql3 = "insert into bike_최선우_etc (no,content,reg_id,reg_date,step,depth,reply) values('"+dto.getNo()+"','"+
					dto.getContent()+"','"+dto.getReg_id()+"',to_date('"+dto.getReg_date()+"','yyyy-mm-dd hh24:mi:ss'),"+
					step+","+depth+",'"+dto.getReply()+"')";
			ps = con.prepareStatement(sql3);
			int k = ps.executeUpdate();
			if(k!=1) System.out.println("ETC 작성 에러");
		}catch(SQLException e) {
			System.out.println("insertDB\nsql1:"+sql1+"\nsql2:"+sql2+"\nsql3:"+sql3+"\nstep:"+step+"\tdepth:"+depth);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	
	public String getMaxNo() {
		String result = null;
		String sql = "select nvl(max(no),'E000') as no from bike_최선우_etc";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) result = rs.getString("no");
		}catch(SQLException e) {
			System.out.println("getMaxNo:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		int iResult = Integer.parseInt(result.substring(1))+1;
		DecimalFormat df = new DecimalFormat("E000");
		return df.format(iResult);
	}
	
	public ArrayList<EtcDto> listDB(String search, int start, int end){
		ArrayList<EtcDto> arr = new ArrayList<>();
		String sql = "select e.no, e.content, e.reg_id, m.name as reg_name, to_char(e.reg_date,'yyyy-mm-dd hh24:mi:ss') "
					+ "as reg_date, e.depth, e.reply from bike_최선우_etc e, bike_최선우_member m where e.content "
					+ "like '%"+search+"%' and e.reg_id = m.id order by step asc";
		sql = "select * from (select tbl.*, rownum as rnum from ("+sql+") tbl ) where rnum>="+start+" and rnum<="+end;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String content = rs.getString("content");
				String reg_id = rs.getString("reg_id");
				String reg_name = rs.getString("reg_name");
				String reg_date = rs.getString("reg_date");
				String depth = rs.getString("depth");
				String reply = rs.getString("reply");
				EtcDto dto = new EtcDto(no, content, reg_id, reg_name, reg_date, null, depth, reply);
				arr.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("listDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	public int totalCountViewDB(String search) {
		int k = 0;
		String sql = "select count(*) from bike_최선우_etc where content like '%"+search+"%' and depth=0";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				k = rs.getInt("count(*)");
			}
		}catch(SQLException e) {
			System.out.println("totalCountDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public int totalCountDB(String search) {
		int k = 0;
		String sql = "select count(*) from bike_최선우_etc where content like '%"+search+"%'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				k = rs.getInt("count(*)");
			}
		}catch(SQLException e) {
			System.out.println("totalCountDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}


}