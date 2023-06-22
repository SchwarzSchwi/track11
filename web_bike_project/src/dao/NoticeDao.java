package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.NoticeDto;

public class NoticeDao {
	Connection 			con = null;
	PreparedStatement 	ps  = null;
	ResultSet 			rs  = null;		
	
	
	//삭제
	public int noticeDelete(String no) {
		int result =0;
		String query ="delete from home_최선우_notice\r\n" + 
				"where no ='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("noticeDelete()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
		return result;
	}
	
	
	//수정저장
	public int noticeUpdate(NoticeDto dto) {
		int result =0;
		String query ="update home_최선우_notice\r\n" + 
				"set title='"+dto.getTitle()+"',\r\n" + 
				"    content='"+dto.getContent()+"',\r\n" +
				"    attach='"+dto.getAttach()+"'"+
				"where no = '"+dto.getNo()+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("noticeUpdate()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
		return result;
	}
	
	//다음글
	public NoticeDto getNextNotice(String no) {
		NoticeDto dto = null;
		String query="select a.no, b.title\r\n" + 
				"from\r\n" + 
				"(select min(no) as no\r\n" + 
				"from home_최선우_notice\r\n" + 
				"where no > '"+no+"') a, home_최선우_notice b\r\n" + 
				"where a.no = b.no";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String nextNo = rs.getString("no");
				String title = rs.getString("title");
				dto = new NoticeDto(nextNo, title);
			}	
		}catch(Exception e) {
			System.out.println("getNextNotice()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
		return dto;	
	}
	
	
	//이전글
	public NoticeDto getPreNotice(String no) {
		NoticeDto dto = null;
		String query="select a.no, b.title\r\n" + 
				"from\r\n" + 
				"(select max(no) as no\r\n" + 
				"from home_최선우_notice\r\n" + 
				"where no < '"+no+"') a, home_최선우_notice b\r\n" + 
				"where a.no = b.no";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String preNo = rs.getString("no");
				String title = rs.getString("title");
				dto = new NoticeDto(preNo, title);
			}	
		}catch(Exception e) {
			System.out.println("getPreNotice()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
		return dto;	
	}

	//조회수 증가
	public void setHitCount(String no) {
		String query ="update home_최선우_notice\r\n" + 
				"set hit = hit + 1\r\n" + 
				"where no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			int result = ps.executeUpdate();
			if(result == 0) System.out.println("공지사항 조회수 증가 오류~~");
		}catch(Exception e) {
			System.out.println("setHitCount()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
	}
	
	//상세보기
	public NoticeDto getNoticeView(String no) {
		NoticeDto dto = null;
		String query ="select n.no, n.title, n.content, n.attach, m.name, to_char(n.reg_date,'yyyy-mm-dd hh:mi:ss') as reg_date, n.hit\r\n" + 
				"from home_최선우_notice n, home_최선우_member m\r\n" + 
				"where n.reg_id = m.id\r\n" + 
				"and n.no = '"+no+"'";
		System.out.println(query);
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String title    = rs.getString("title");
				String content	= rs.getString("content");
				String attach	= rs.getString("attach");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				int    hit      = rs.getInt("hit");
				
				dto = new NoticeDto(no, title, content, attach, reg_name, reg_date, hit);
			}
		}catch(Exception e) {
			System.out.println("getNoticeView()오류:"+query);
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
				"from home_최선우_notice n\r\n" + 
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
	//목록조회페이지
	public ArrayList<NoticeDto> getNoticeListPage(String select,String search,int start,int end){
		ArrayList<NoticeDto> dtos = new ArrayList<>();
		String query ="select*\r\n" + 
				"from\r\n" + 
				"(select rownum as rnum, tbl.*\r\n" + 
				"from\r\n" + 
				"    ("+
				"    select n.no, n.title, n.attach, m.name, to_char(n.reg_date,'yyyy-mm-dd') as reg_date, n.hit\r\n" + 
				"    from home_최선우_notice n, home_최선우_member m\r\n" + 
				"    where n.reg_id = m.id\r\n" + 
				"    and "+select+" like '%"+search+"%'\r\n" + 
				"    order by n.no desc "+
				" ) tbl)\r\n" + 
				"where rnum >="+start+" and rnum <="+end+"";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String no       = rs.getString("no");
				String title    = rs.getString("title");
				String attach   = rs.getString("attach");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				int    hit      = rs.getInt("hit");
				
				NoticeDto  dto  = new NoticeDto(no, title, attach, reg_name, reg_date, hit);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getNoticeListPage()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
		
	//목록조회
	public ArrayList<NoticeDto> getNoticeList(String select,String search){
		ArrayList<NoticeDto> dtos = new ArrayList<>();
		String query ="select n.no, n.title, m.name, to_char(n.reg_date,'yyyy-mm-dd') as reg_date, n.hit\r\n" + 
				"from home_최선우_notice n, home_최선우_member m\r\n" + 
				"where n.reg_id = m.id\r\n" +
				"and "+select+" like '%"+search+"%'" +
				"order by n.no desc";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String no       = rs.getString("no");
				String title    = rs.getString("title");
				String attach   = rs.getString("attach");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				int    hit      = rs.getInt("hit");
				
				NoticeDto  dto  = new NoticeDto(no, title, attach, reg_name, reg_date, hit);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getNoticeList()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	//등록
	public int noticeSave(NoticeDto dto){
		int result = 0;
/*		String query="insert into home_최선우_notice\r\n" + 
				"(no,title,content,attach,reg_id,reg_date)"+
				"values\r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getAttach()+"','"+dto.getReg_id()+"','"+dto.getReg_date()+"')";
*/		
		String query="insert into home_최선우_notice\r\n" + 
				"(no,title,content,attach,reg_id,reg_date)\r\n" + 
				"values\r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getAttach()+"','"+dto.getReg_id()+"',\r\n" + 
				"to_date('"+dto.getReg_date()+"','yyyy-mm-dd hh24:mi:ss'))";
		System.out.println(query);
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("noticeSave()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//게시글 번호 생성
	public String getMaxNo() { // N001 N002 N003
		String no="";
		String query="select nvl(max(no),'N000') as no\r\n" + 
				     "from home_최선우_notice";
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




