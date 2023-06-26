package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.NewsDto;
import dto.NoticeDto;

public class NewsDao {
	Connection 			con = null;
	PreparedStatement 	ps  = null;
	ResultSet 			rs  = null;	
	
	//수정조회
	public NewsDto getNewsUpdateView(String no) {
		NewsDto dto = null;
		String query ="select n.no, n.title, n.content, m.name, to_char(n.reg_date,'yyyy-mm-dd hh24:mi:ss') as reg_date,\r\n" + 
				"to_char(n.update_date,'yyyy-mm-dd hh24:mi:ss') as update_date, n.hit\r\n" + 
				"from home_최선우_news n, home_최선우_member m\r\n" + 
				"where n.reg_id = m.id\r\n" + 
				"and n.no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String title     = rs.getString("title");
				String content   = rs.getString("content");
				String reg_name  = rs.getString("name");
				String reg_date  = rs.getString("reg_date");
				String update_date = rs.getString("update_date");
				int    hit       = rs.getInt("hit");
				
				dto = new NewsDto(no, title, content, reg_name, reg_date, update_date, hit);
			}
		}catch(Exception e) {
			System.out.println("getNewsUpdateView()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//삭제
	public int newsDelete(String no) {
		int result = 0;
		String query ="delete from home_최선우_news\r\n" + 
				"where no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("newsDelete()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	//수정저장
	public int newsUpdate(NewsDto dto) {
		int result =0;
		String query ="update home_최선우_news\r\n" + 
				"set title='"+dto.getTitle()+"',\r\n" + 
				"    content='"+dto.getContent()+"',\r\n" + 
				"    update_date=to_date('"+dto.getUpdate_date()+"','yyyy-mm-dd hh24:mi:ss')\r\n" + 
				"where no = '"+dto.getNo()+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("newsUpdate()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//다음글
	public NewsDto getNextNews(String no) {
		NewsDto dto = null;
		String query="select a.no, b.title\r\n" + 
				"from\r\n" + 
				"(select min(no) as no\r\n" + 
				"from home_최선우_news\r\n" + 
				"where no > '"+no+"') a, home_최선우_news b\r\n" + 
				"where a.no = b.no";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String nextNo = rs.getString("no");
				String title = rs.getString("title");
				dto = new NewsDto(nextNo, title);
			}	
		}catch(Exception e){
			System.out.println("getPreNews()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//이전글
	public NewsDto getPreNews(String no) {
		NewsDto dto = null;
		String query="select a.no, b.title\r\n" + 
				"from\r\n" + 
				"(select max(no) as no \r\n" + 
				"from home_최선우_news\r\n" + 
				"where no < '"+no+"') a, home_최선우_news b\r\n" + 
				"where a.no = b.no";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String preNo = rs.getString("no");
				String title = rs.getString("title");
				dto = new NewsDto(preNo, title);
			}	
		}catch(Exception e){
			System.out.println("getPreNews()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}
	//조회수 증가
	public void setHitCount(String no) {
		String query ="update home_최선우_news\r\n" + 
				"set hit = hit + 1\r\n" + 
				"where no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			int result = ps.executeUpdate();
			if(result == 0)System.out.println("공지사항 조회수 증가 오류~~");
		}catch(Exception e) {
			System.out.println("setHitCount()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
	}
	
	//상세보기
	public NewsDto getNewsView(String no) {
		NewsDto dto = null;
		String query ="select n.no, n.title, n.content, m.name, to_char(n.reg_date,'yyyy-mm-dd hh24:mi:ss') as reg_date,\r\n" + 
				"to_char(n.update_date,'yyyy-mm-dd hh24:mi:ss')as update_date, n.hit\r\n" + 
				"from home_최선우_news n, home_최선우_member m\r\n" + 
				"where n.reg_id = m.id\r\n" + 
				"and n.no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String title     = rs.getString("title");
				String content   = rs.getString("content");
				String reg_name  = rs.getString("name");
				String reg_date  = rs.getString("reg_date");
				String update_date = rs.getString("update_date");
				int    hit       = rs.getInt("hit");
				
				dto = new NewsDto(no, title, content, reg_name, reg_date, update_date, hit);
			}
		}catch(Exception e) {
			System.out.println("getNewsView()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	//목록조회
	public ArrayList<NewsDto> getNewsList(String select,String search){
		ArrayList<NewsDto> dtos = new ArrayList<>();
		String query="select n.no, n.title, m.name, to_char(n.reg_date,'yyyy-mm-dd') as reg_date, n.hit\r\n" + 
				"from home_최선우_news n, home_최선우_member m\r\n" + 
				"where n.reg_id = m.id\r\n" + 
				"and "+select+" like '%"+search+"%'\r\n" + 
				"order by n.no desc";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String no       = rs.getString("no");
				String title    = rs.getString("title");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				int    hit      = rs.getInt("hit");
				
				NewsDto dto = new NewsDto(no, title, reg_name, reg_date, hit);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getNewsList()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	//등록
	public int newsSave(NewsDto dto) {
		int result = 0;
		String query="insert into home_최선우_news\r\n" + 
				"(no,title,content,reg_id,reg_date)\r\n" + 
				"values\r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getReg_id()+"',\r\n" + 
				"to_date('"+dto.getReg_date()+"','yyyy-mm-dd hh:mi:ss'))";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("newsSave()오류:"+query);
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
				     "from home_최선우_news";
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
