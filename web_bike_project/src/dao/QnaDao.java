package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.QnaDto;

public class QnaDao {
	Connection 			con = null;
	PreparedStatement   ps  = null;
	ResultSet		    rs  = null;
	
	//답변수정저장
	public int qnaUpdateAnswer(QnaDto dto) {
		int result = 0;
		String query ="update bike_최선우_qna \r\n" + 
				"set a_content = '"+dto.getA_content()+"',\r\n" + 
				"    a_date = to_date('"+dto.getA_date()+"','yyyy-MM-dd hh24:mi:ss'),\r\n" + 
				"    a_id = '"+dto.getA_id()+"' \r\n" + 
				"where no = '"+dto.getNo()+"'";
		System.out.println(query);
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("qnaUpdateAnswer()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	//답변삭제
	public int qnaDeleteAnswer(QnaDto dto) {
		int result = 0;
		String query ="update bike_최선우_qna \r\n" + 
				"set a_title = '"+dto.getA_title()+"',\r\n" + 
				"    a_content = '"+dto.getA_content()+"',\r\n" + 
				"    a_date = to_date('"+dto.getA_date()+"','yyyy-MM-dd hh24:mi:ss'),\r\n" + 
				"    a_id = '"+dto.getA_id()+"' \r\n" + 
				"where no = '"+dto.getNo()+"'";
		System.out.println(query);
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("qnaDeleteAnswer()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	//질문삭제
	public int qnaDelete(String no){
		int result  = 0;
		String query="delete from bike_최선우_qna\r\n" + 
					 " where no ='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("qnaDelete()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return result;
	}
	
	//질문수정저장
	public int qnaUpdate(QnaDto dto) {
		int result = 0;
		String query ="update bike_최선우_qna \r\n" + 
				"set q_title = '"+dto.getQ_title()+"',\r\n" + 
				"    q_content = '"+dto.getQ_content()+"',\r\n" + 
				"    q_date = to_date('"+dto.getQ_date()+"','yyyy-MM-dd hh24:mi:ss'),\r\n" + 
				"    q_id = '"+dto.getQ_id()+"' \r\n" + 
				"    photos = '"+dto.getPhotos()+"' \r\n" + 
				"where no = '"+dto.getNo()+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("qnaUpdate()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	//답변저장
	public int qnaReply(QnaDto dto) {
		int result = 0;
		String query ="update bike_최선우_qna \r\n" + 
				"set a_title = '"+dto.getA_title()+"',\r\n" + 
				"    a_content = '"+dto.getA_content()+"',\r\n" + 
				"    a_date = to_date('"+dto.getA_date()+"','yyyy-MM-dd hh24:mi:ss'),\r\n" + 
				"    a_id = '"+dto.getA_id()+"' \r\n" + 
				"where no = '"+dto.getNo()+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("qnaReply()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	//조회수 증가
	public void setViewsCount(String no) {
		String query ="update bike_최선우_qna\r\n" + 
				"set views = views + 1\r\n" + 
				"where no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			int result = ps.executeUpdate();
			if(result == 0) System.out.println("공지사항 조회수 증가 오류~~");
		}catch(Exception e) {
			System.out.println("setViewsCount()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
	}
		
	//상세보기
	public QnaDto getQnaView(String no) {
		QnaDto dto = null;
		String query ="select n.no, n.q_title, n.q_content, to_char(n.q_date,'yyyy-mm-dd') as q_date, n.q_id, m.name, n.photos,\r\n" + 
				"n.a_title, n.a_content, to_char(n.a_date,'yyyy-mm-dd') as a_date, n.a_id, n.views\r\n" + 
				"from bike_최선우_qna n, bike_최선우_member m\r\n" + 
				"where n.no = '"+no+"'\r\n" +
				"and n.q_id = m.id"; 
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String q_title    = rs.getString("q_title");
				String q_content   = rs.getString("q_content");
				String q_date = rs.getString("q_date");
				String q_id = rs.getString("q_id");
				String name = rs.getString("name");
				String photos = rs.getString("photos");
				String a_title      = rs.getString("a_title");
				String a_content      = rs.getString("a_content");
				String a_date      = rs.getString("a_date");
				String a_id      = rs.getString("a_id");
				int views	= rs.getInt("views");
				
				dto  = new QnaDto(no, q_title, q_content, q_date, q_id, name, photos, a_title, a_content, a_date, a_id, views);
			}
		}catch(Exception e) {
			System.out.println("getQnaView()오류:"+query);
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
				"from bike_최선우_qna n\r\n" + 
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
	
	//질문등록
	public int qnaSave(QnaDto dto){
		int result = 0;
		String query="insert into bike_최선우_qna\r\n" + 
				"(no,q_title,q_content,q_date,q_id, photos, views)\r\n" + 
				"values\r\n" + 
				"('"+dto.getNo()+"','"+dto.getQ_title()+"','"+dto.getQ_content()+"',to_date('"+dto.getQ_date()+"','yyyy-mm-dd hh24:mi:ss'),'"+dto.getQ_id()+"','"+dto.getPhotos()+"','"+dto.getViews()+"')";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("qnaSave()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//목록조회페이지
	public ArrayList<QnaDto> getQnaListPage(String select,String search,int start,int end){
		ArrayList<QnaDto> dtos = new ArrayList<>();
		String query ="select *\r\n" + 
				"from\r\n" + 
				"(select rownum as rnum, tbl.* \r\n" + 
				"from \r\n" + 
				"(\r\n" + 
				"select n.no, n.q_title, n.q_content, to_char(n.q_date,'yyyy-mm-dd') as q_date, n.q_id, m.name, n.photos,\r\n" + 
				"n.a_title, n.a_content, to_char(n.a_date,'yyyy-mm-dd') as a_date, n.a_id, n.views\r\n" + 
				"from bike_최선우_qna n, bike_최선우_member m\r\n" + 
				"where "+select+" like '%"+search+"%'\r\n" + 
				"and n.q_id = m.id\r\n" +
				"order by n.q_date desc\r\n" +
				") tbl)\r\n" + 
				"where rnum >="+start+" and rnum <="+end+"";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String no       = rs.getString("no");
				String q_title    = rs.getString("q_title");
				String q_content   = rs.getString("q_content");
				String q_date = rs.getString("q_date");
				String q_id = rs.getString("q_id");
				String name = rs.getString("name");
				String photos = rs.getNString("photos");
				String a_title      = rs.getString("a_title");
				String a_content      = rs.getString("a_content");
				String a_date      = rs.getString("a_date");
				String a_id      = rs.getString("a_id");
				int views	= rs.getInt("views");
				
				QnaDto  dto  = new QnaDto(no, q_title, q_content, q_date, q_id, name, photos, a_title, a_content, a_date, a_id, views);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getQnaListPage()오류:"+query);
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
					     "from bike_최선우_qna";
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
