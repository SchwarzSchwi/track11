package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.FaqDto;

public class FaqDao {
	Connection 			con = null;
	PreparedStatement 	ps  = null;
	ResultSet 			rs  = null;		
	
	
	//삭제
	public int faqDelete(String no) {
		int result =0;
		String query ="delete from home_최선우_faq\r\n" + 
				"where no ='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("faqDelete()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
		return result;
	}
	
	
	//수정저장
	public int faqUpdate(FaqDto dto) {
		int result =0;
		String query ="update home_최선우_faq\r\n" + 
				"set title='"+dto.getTitle()+"',\r\n" + 
				"    content='"+dto.getContent()+"',\r\n" +
				"    attach='"+dto.getAttach()+"'"+
				"where no = '"+dto.getNo()+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("faqUpdate()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
		return result;
	}
	
	//다음글
	public FaqDto getNextFaq(String no) {
		FaqDto dto = null;
		String query="select a.no, b.title\r\n" + 
				"from\r\n" + 
				"(select min(no) as no\r\n" + 
				"from home_최선우_faq\r\n" + 
				"where no > '"+no+"') a, home_최선우_notice b\r\n" + 
				"where a.no = b.no";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String nextNo = rs.getString("no");
				String title = rs.getString("title");
				dto = new FaqDto(nextNo, title);
			}	
		}catch(Exception e) {
			System.out.println("getNextFaq()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
		return dto;	
	}
	
	
	//이전글
	public FaqDto getPreFaq(String no) {
		FaqDto dto = null;
		String query="select a.no, b.title\r\n" + 
				"from\r\n" + 
				"(select max(no) as no\r\n" + 
				"from home_최선우_notice\r\n" + 
				"where no < '"+no+"') a, home_최선우_faq b\r\n" + 
				"where a.no = b.no";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String preNo = rs.getString("no");
				String title = rs.getString("title");
				dto = new FaqDto(preNo, title);
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
		String query ="update home_최선우_faq\r\n" + 
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
	public FaqDto getFaqView(String no) {
		FaqDto dto = null;
		String query ="select n.no, n.title, n.content, m.name, to_char(n.reg_date,'yyyy-mm-dd hh:mi:ss') as reg_date\r\n" + 
				"from home_최선우_faq n, home_최선우_member m\r\n" + 
				"where n.reg_id = m.id\r\n" + 
				"and n.no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String title    = rs.getString("title");
				String content	= rs.getString("content");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				
				dto = new FaqDto(no, title, content, reg_name, reg_date);
			}
		}catch(Exception e) {
			System.out.println("getFaqView()오류:"+query);
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
				"from home_최선우_faq n\r\n" + 
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
	public ArrayList<FaqDto> getFaqListPage(String select,String search,int start,int end){
		ArrayList<FaqDto> dtos = new ArrayList<>();
		String query ="select*\r\n" + 
				"from\r\n" + 
				"(select rownum as rnum, tbl.*\r\n" + 
				"from\r\n" + 
				"    ("+
				"    select n.no, n.title, m.name, to_char(n.reg_date,'yyyy-mm-dd') as reg_date,\r\n" + 
				"    from home_최선우_faq n, home_최선우_member m\r\n" + 
				"    where n.reg_id = m.id\r\n" + 
				"    and "+select+" like '%"+search+"%'\r\n" + 
				"    order by n.no desc "+
				" ) tbl)\r\n" + 
				"where rnum >="+start+" and rnum <="+end+"";
		System.out.println(query);
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String no       = rs.getString("no");
				String title    = rs.getString("title");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				
				FaqDto  dto  = new FaqDto(no, title, reg_name, reg_date);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getFaqList()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
		
	//목록조회
	public ArrayList<FaqDto> getFaqList(String select,String search){
		ArrayList<FaqDto> dtos = new ArrayList<>();
		String query ="select n.no, n.title, m.name, to_char(n.reg_date,'yyyy-mm-dd') as reg_date\r\n" + 
				"from home_최선우_faq n, home_최선우_member m\r\n" + 
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
				
				FaqDto  dto  = new FaqDto(no, title, attach, reg_name, reg_date);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getFaqList()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	//등록
	public int FaqSave(FaqDto dto){
		int result = 0;
/*		String query="insert into home_최선우_faq\r\n" + 
				"(no,title,content,attach,reg_id,reg_date)"+
				"values\r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getReg_id()+"','"+dto.getReg_date()+"')";
*/		
		String query="insert into home_최선우_faq\r\n" + 
				"(no,title,content,reg_id,reg_date)\r\n" + 
				"values\r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getReg_id()+"',\r\n" + 
				"to_date('"+dto.getReg_date()+"','yyyy-mm-dd hh24:mi:ss'))";
System.out.println(query);
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("faqSave()오류 :"+query);
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
				     "from home_최선우_faq";
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




