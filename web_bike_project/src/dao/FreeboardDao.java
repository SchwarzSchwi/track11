package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.FreeboardDto;
import dto.QnaDto;

public class FreeboardDao {
	Connection 			con = null;
	PreparedStatement   ps  = null;
	ResultSet		    rs  = null;
	//게시글 삭제
		public int freeboardDelete(String no) {
			int result = 0;
			String query ="delete from bike_최선우_freeboard\r\n" +
						"where no = '"+no+"'";
			System.out.println(query);
			try {
				con = DBConnection.getConnection();
				ps  = con.prepareStatement(query);
				result =ps.executeUpdate();
			}catch(Exception e) {
				System.out.println("freeboardDelete()오류:"+query);
				e.printStackTrace();
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			return result;
		}
	
	//게시글 수정 저장
		public int freeboardUpdate(FreeboardDto dto) {
			int result = 0;
			String query ="update bike_최선우_freeboard \r\n" + 
					"set title = '"+dto.getTitle()+"',\r\n" + 
					"    content = '"+dto.getContent()+"',\r\n" + 
					"    reg_id = '"+dto.getReg_id()+"',\r\n" + 
					"    attach = '"+dto.getAttach()+"',\r\n" + 
					"    hit = '"+dto.getHit()+"'\r\n" + 
					"where no = '"+dto.getNo()+"'";
			try {
				con = DBConnection.getConnection();
				ps  = con.prepareStatement(query);
				result = ps.executeUpdate();
			}catch(Exception e) {
				System.out.println("freeboardUpdate()오류 :"+query);
				e.printStackTrace();
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			return result;
		}
//조회수 증가
	public void setHitCount(String no) {
		String query ="update bike_최선우_Freeboard\r\n" + 
				"set hit = hit + 1\r\n" + 
				"where no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			int result = ps.executeUpdate();
			if(result == 0) System.out.println("조회수 증가 오류~~");
		}catch(Exception e) {
			System.out.println("setHitCount()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
	}
		
//상세보기
public FreeboardDto getFreeboardView(String no) {
	FreeboardDto dto = null;
	String query ="select n.no, n.title, n.content, n.reg_id, to_char(n.reg_date,'yyyy-mm-dd') as reg_date, n.attach, m.name, n.Hit\r\n" + 
			"from bike_최선우_freeboard n, bike_최선우_member m\r\n" + 
			"where n.no = '"+no+"'\r\n" +
			"and n.reg_id = m.id"; 
	try {
		con = DBConnection.getConnection();
		ps  = con.prepareStatement(query);
		rs  = ps.executeQuery();
		if(rs.next()) {
			String title    = rs.getString("title");
			String content   = rs.getString("content");
			String reg_id = rs.getString("reg_id");
			String reg_date = rs.getString("reg_date");
			String attach = rs.getString("attach");	
			String name = rs.getString("name");
			int hit = rs.getInt("hit");

			dto  = new FreeboardDto(no, title, content, reg_id, reg_date, attach, name, hit);
		}
	}catch(Exception e) {
		System.out.println("getFreeboardView()오류:"+query);
		e.printStackTrace();
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}	
	return dto;
}

//목록수
public int getTotalCount(String select,String search) {
	int count = 0;
	String query="select count(*) as count\r\n" + 
			"from bike_최선우_freeboard n\r\n" + 
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

//게시물등록
public int freeboardSave(FreeboardDto dto){
	int result = 0;
	String query="insert into bike_최선우_Freeboard\r\n" + 
			"(no, title, content, reg_id, reg_date, attach, Hit)\r\n" + 
			"values\r\n" + 
			"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getReg_id()+"',\r\n" +
			"to_date('"+dto.getReg_date()+"','yyyy-mm-dd hh24:mi:ss'),\r\n" + 
			"'"+dto.getAttach()+"','"+dto.getHit()+"')";
	System.out.println(query);
	try {
		con = DBConnection.getConnection();
		ps  = con.prepareStatement(query);
		result = ps.executeUpdate();
	}catch(Exception e) {
		System.out.println("freeboardSave()오류 :"+query);
		e.printStackTrace();
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return result;
}

//목록조회페이지
public ArrayList<FreeboardDto> getFreeboardListPage(String select,String search,int start,int end){
	ArrayList<FreeboardDto> dtos = new ArrayList<>();
	String query ="select *\r\n" + 
			"from\r\n" + 
			"(select rownum as rnum, tbl.* \r\n" + 
			"from \r\n" + 
			"(\r\n" + 
			"select n.no, n.title, n.content, n.reg_id, to_char(n.reg_date,'yyyy-mm-dd') as reg_date,\r\n" +
			"to_char(n.update_date,'yyyy-mm-dd') as update_date, n.attach,  m.name, n.download, n.hit\r\n" + 
			"from bike_최선우_freeboard n, bike_최선우_member m\r\n" + 
			"where "+select+" like '%"+search+"%'\r\n" + 
			"and n.reg_id = m.id\r\n" +
			"order by n.no desc\r\n" +
			") tbl)\r\n" + 
			"where rnum >="+start+" and rnum <="+end+"";
	try {
		con = DBConnection.getConnection();
		ps  = con.prepareStatement(query);
		rs  = ps.executeQuery();
		while(rs.next()) {
			String no       = rs.getString("no");
			String title    = rs.getString("title");
			String content   = rs.getString("content");
			String reg_id = rs.getString("reg_id");
			String reg_date = rs.getString("reg_date");
			String update_date =rs.getString("update_date");
			String attach = rs.getString("attach");
			String name = rs.getString("name");
			int download      = rs.getInt("download");
			int hit      = rs.getInt("hit");
			
			FreeboardDto  dto  = new FreeboardDto(no, title, content, reg_id, reg_date, update_date, attach, name, download, hit);
			dtos.add(dto);
		}
	}catch(Exception e) {
		System.out.println("getFreeboardListPage()오류:"+query);
		e.printStackTrace();
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return dtos;
}
	

//게시글 번호 생성
	public String getMaxNo() { // N001 N002 N003
		String no="";
		String query="select nvl(max(no),'N000') as no\r\n" + 
				     "from bike_최선우_freeboard";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("no"); // "N000"
				no = no.substring(1); // "000"
				int n = Integer.parseInt(no); // 1
				n = n + 1; // 2 
				
				DecimalFormat df = new DecimalFormat("N000");
				no = df.format(n); // "N002"
			}
		}catch(Exception e) {
			System.out.println("getMaxNo() 오류:"+query);
				e.printStackTrace();
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}		
			return no;
		}
}
