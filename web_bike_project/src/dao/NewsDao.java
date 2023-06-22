package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.NewsDto;

public class NewsDao {
	Connection 			con = null;
	PreparedStatement 	ps  = null;
	ResultSet 			rs  = null;		

	//삭제
	public int newsDelete(String no){
		int result  = 0;
		String query="delete from home_최선우_news\r\n" + 
					 " where no ='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("newsDelete()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return result;
	}
	
	//수정저장
	public int newsUpdate(NewsDto dto){
		int result =0;
		String query="update home_최선우_news\r\n" + 
				"set title='"+dto.getTitle()+"',\r\n" + 
				"    content='"+dto.getContent()+"',\r\n" + 
				"    attach='"+dto.getAttach()+"',\r\n" +   	
				"    update_date=to_date('"+dto.getUpdate_date()+"','yyyy-MM-dd hh:mi:ss')\r\n" + 
				"where no ='"+dto.getNo()+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("newsUpdate()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return result;
	}
	
	// 다음글 조회
	public NewsDto getNextNews(String no){
		NewsDto dto = null;
		String query="select a.no, b.title \r\n" + 
				"from\r\n" + 
				"(\r\n" + 
				"select min(no) as no\r\n" + 
				"from home_최선우_news\r\n" + 
				"where no > '"+no+"'\r\n" + 
				") a, home_최선우_news b\r\n" + 
				"where a.no = b.no";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()){
				String pre_no 	=rs.getString("no");
				String title 	=rs.getString("title");
				dto = new NewsDto(pre_no, title);
			}
		}catch(Exception e) {
			System.out.println("getNextNews()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}			
		return dto;
	}	
	
	//이전글
	public NewsDto getPreNews(String no){
		NewsDto dto = null;
		String query="select a.no, b.title\r\n" + 
				" from \r\n" + 
				" (select max(no) as no\r\n" + 
				" from home_최선우_news\r\n" + 
				" where no < '"+no+"') a, home_최선우_news b\r\n" + 
				" where a.no = b.no";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()){
				String preNo = rs.getString("no");
				String title = rs.getString("title");
				dto = new NewsDto(preNo, title);
			}
		}catch(Exception e) {
			System.out.println("getPreNews()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return dto;
	}
	
	//조회수증가
	public void setHitCount(String no){
		String query="update home_최선우_news\r\n" + 
				" set hit = hit + 1\r\n" + 
				" where no ='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			int result = ps.executeUpdate();
			if(result == 0) System.out.println("news 조회수 증가 오류~~");
		}catch(Exception e) {
			System.out.println("setHitCount()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		
	}
	
	
	//상세조회
	public NewsDto getNewsView(String no){
		NewsDto dto =null;
		String query  ="select n.no, n.title, n.content, n.attach,  m.name, \r\n" + 
				"        to_char(n.reg_date,'yyyy-MM-dd hh:mi:ss') as reg_date , to_char(n.update_date,'yyyy-MM-dd hh:mi:ss') as update_date, n.hit\r\n" + 
				"from home_최선우_news n, home_최선우_member m\r\n" + 
				"where n.reg_id = m.id\r\n" + 
				"and n.no ='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()){
				String title 	= rs.getString("title");
				String content 	= rs.getString("content");
				String attach 	= rs.getString("attach");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				String update_date = rs.getString("update_date");
				int    hit      = rs.getInt("hit");
				
				dto = new NewsDto(no, title, content, attach, reg_name, reg_date, update_date, hit);
			}
		}catch(Exception e) {
			System.out.println("getNewsView()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return dto;
	}
	
	//목록조회
	public ArrayList<NewsDto> getNewsList(String select,String search,
											int start, int end){
		ArrayList<NewsDto> dtos = new ArrayList<>();
		String query ="select *\r\n" + 
				"from\r\n" + 
				"(select rownum as rnum, tbl.* \r\n" + 
				"from\r\n" + 
				"(select n.no, n.title, m.name, \r\n" + 
				"        to_char(n.reg_date,'yyyy-MM-dd') as reg_date, n.hit\r\n" + 
				" from home_최선우_news n, home_최선우_member m\r\n" + 
				" where n.reg_id = m.id\r\n" + 
				" and "+select+" like '%"+search+"%'  \r\n" + 
				" order by n.no desc\r\n" + 
				" ) tbl)\r\n" + 
				" where rnum >= "+start+" and rnum <="+end+"";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()){
				String no 		= rs.getString("no");
				String title 	= rs.getString("title");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				int    hit      = rs.getInt("hit");
				NewsDto dto = new NewsDto(no, title, reg_name, reg_date, hit);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getNewsList()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return dtos;
	}
	
	//등록
	public int newsSave(NewsDto dto){
		int result = 0;
		/*
		String query="insert into home_최선우_news\r\n" + 
				"(no,title,content,attach,reg_id,reg_date) "+
				"values\r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getAttach()+"','"+dto.getReg_id()+"','"+dto.getReg_date()+"')";
		*/
		String query="insert into home_최선우_news\r\n" + 
				"(no,title,content,attach,reg_id,reg_date)\r\n" + 
				"values('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getAttach()+"','"+dto.getReg_id()+"',\r\n" + 
				"to_date('"+dto.getReg_date()+"','yyyy-MM-dd hh:mi:ss'))";
		
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("newsSave()오류 :"+query);
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
	
	public int getTotalCount(String select, String search) {
		int count = 0;
		String query ="select count(*) as count \r\n" + 
				" from home_최선우_news n, home_최선우_member m\r\n" + 
				" where n.reg_id = m.id\r\n" + 
				" and "+select+" like '%"+search+"%' "+
				" order by n.no desc";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt("count");
			}
		}catch(Exception e) {
			System.out.println("getTotalCount()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return count;
	}
}














