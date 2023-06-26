package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.QnaDto;

public class QnaDao {
	Connection          con = null;
	PreparedStatement   ps  = null;
	ResultSet           rs  = null;
	
	//질문수정
			public int qnaUpdate(QnaDto dto) {
				int result=0;
				String query="update home_최선우_qna\r\n" + 
						"set title='"+dto.getTitle()+"',\r\n" + 
						"    content='"+dto.getContent()+"',\r\n" + 
						"    reg_id='"+dto.getReg_id()+"',\r\n" + 
						"    reg_date=to_date('"+dto.getReg_date()+"','yyyy-mm-dd hh24:mi:ss')\r\n" + 
						"where no = '"+dto.getNo()+"'";
				System.out.println(query);
				try {
					con = DBConnection.getConnection();
					ps  = con.prepareStatement(query);
					result = ps.executeUpdate();
				}catch(Exception e) {
					System.out.println("qnaUpdate()오류:"+query);
					e.printStackTrace();
				}finally {
					DBConnection.closeDB(con, ps, rs);
				}
				return result;
			}
	
	//답변삭제
	public int qnaDeleteAnswer(QnaDto dto) {
		int result =0;
		String query ="update home_최선우_qna\r\n" + 
				"set answer = '',\r\n" + 
				"qna_date= ''\r\n" + 
				"where no = '"+dto.getNo()+"'";
		System.out.println(query);
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("qnaDeleteAnswer()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//전체삭제
	public int qnaDelete(String no) {
		int result =0;
		String query ="delete from home_최선우_qna\r\n" + 
				"where no ='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("qnaDelete()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}	
		return result;
	}
	
	//번호 조회
	public int getTotalCount(String select,String search) {
		int count = 0;
		String query="select count(*) as count\r\n" + 
				"from home_최선우_qna n\r\n" + 
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
	
	//답변저장
		public int qnaUpdateReply(QnaDto dto) {
			int result=0;
			String query="update home_최선우_qna\r\n" + 
					"set qna_date=to_date('"+dto.getQna_date()+"','yyyy-mm-dd hh24:mi:ss'),\r\n" + 
					"    answer='"+dto.getAnswer()+"'\r\n" + 
					"where no = '"+dto.getNo()+"'";
			try {
				con = DBConnection.getConnection();
				ps  = con.prepareStatement(query);
				result = ps.executeUpdate();
			}catch(Exception e) {
				System.out.println("qnaUpdateReply()오류:"+query);
				e.printStackTrace();
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			return result;
		}
	//다음글
		public QnaDto getNextQna(String no) {
			QnaDto dto = null;
			String query="select a.no, b.title\r\n" + 
					"from\r\n" + 
					"(select min(no) as no\r\n" + 
					"from home_최선우_qna\r\n" + 
					"where no > '"+no+"') a, home_최선우_qna b\r\n" + 
					"where a.no = b.no";
			try {
				con = DBConnection.getConnection();
				ps  = con.prepareStatement(query);
				rs  = ps.executeQuery();
				if(rs.next()) {
					String nextNo = rs.getString("no");
					String title = rs.getString("title");
					dto = new QnaDto(nextNo, title);
				}	
			}catch(Exception e){
				System.out.println("getNextQna()오류:"+query);
				e.printStackTrace();
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			return dto;
		}
	
	//이전글
		public QnaDto getPreQna(String no) {
			QnaDto dto = null;
			String query="select a.no, b.title\r\n" + 
					"from\r\n" + 
					"(select max(no) as no \r\n" + 
					"from home_최선우_qna\r\n" + 
					"where no < '"+no+"') a, home_최선우_qna b\r\n" + 
					"where a.no = b.no";
			try {
				con = DBConnection.getConnection();
				ps  = con.prepareStatement(query);
				rs  = ps.executeQuery();
				if(rs.next()) {
					String preNo = rs.getString("no");
					String title = rs.getString("title");
					dto = new QnaDto(preNo, title);
				}	
			}catch(Exception e){
				System.out.println("getPreQna()오류:"+query);
				e.printStackTrace();
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			
			return dto;
		}
	
	//조회수 증가
		public void setHitCount(String no) {
			String query ="update home_최선우_qna\r\n" + 
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
	public QnaDto getQnaView(String no) {
		QnaDto dto = null;
		String query ="select n.no, n.title, n.content, m.name, to_char(n.reg_date,'yyyy-mm-dd hh24:mi:ss') as reg_date,\r\n" + 
				"to_char(n.qna_date,'yyyy-mm-dd hh24:mi:ss')as qna_date, n.answer, n.hit\r\n" + 
				"from home_최선우_qna n, home_최선우_member m\r\n" + 
				"where n.reg_id = m.id\r\n" + 
				"and n.no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String title     = rs.getString("title");
				String content   = rs.getString("content");
				String reg_id  = rs.getString("name");
				String reg_date  = rs.getString("reg_date");
				String qna_date = rs.getString("qna_date");
				String answer	 = rs.getString("answer");
				int    hit       = rs.getInt("hit");
				
				dto = new QnaDto(no, title, content, reg_id, reg_date, qna_date, answer, hit);
			}
		}catch(Exception e) {
			System.out.println("getQnaView()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	//목록조회
	public ArrayList<QnaDto> getQnaList(String select,String search,int start,int end){
		ArrayList<QnaDto>dtos = new ArrayList<>();
		String query="select*\r\n" + 
				"from\r\n" + 
				"(select rownum as rnum, tbl.*\r\n" + 
				"from\r\n" + 
				"    ("+
				"select n.no, n.title, m.name, n.answer,\r\n" + 
				"to_char(n.reg_date,'yyyy-mm-dd') as reg_date, n.hit\r\n" + 
				"from home_최선우_qna n, home_최선우_member m\r\n" + 
				"where n.reg_id = m.id\r\n" + 
				"and "+select+" like '%"+search+"%'\r\n" + 
				"order by n.no desc"+
				" ) tbl)\r\n" + 
				"where rnum >="+start+" and rnum <="+end+"";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String no       = rs.getString("no");
				String title    = rs.getString("title");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				String answer = rs.getString("answer");
				int hit         = rs.getInt("hit");
				
				QnaDto dto = new QnaDto(no, title, reg_name, reg_date,answer, hit);
				dtos.add(dto);
			}
			
		}catch(Exception e) {
			System.out.println("getQnaList()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
		
	}
	//등록
	public int qnaSave(QnaDto dto) {
		int result = 0;
		String query="insert into home_최선우_QNA\r\n" + 
				"(no,title,content,reg_id,reg_date)\r\n" + 
				"values\r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getReg_id()+"',\r\n" + 
				"to_date('"+dto.getReg_date()+"','yyyy-mm-dd hh24:mi:ss'))";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("qnaSave()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//게시글 번호 생성
	public String getMaxNo() {
		String no="";
		String query="select nvl(max(no),'N000') as no\r\n" + 
				"from home_최선우_QNA";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("no");
				no = no.substring(1);
				int n = Integer.parseInt(no);
				n = n + 1;
				
				DecimalFormat df = new DecimalFormat("N000");
				no = df.format(n);
			}
		}catch(Exception e) {
			System.out.println("getMaxNo()오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return no;
	}
}
