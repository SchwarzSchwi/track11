package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestOne
 */
@WebServlet("/TestOne")
public class TestOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("=가나다=");
		
		
		
		out.print("<!DOCTYPE html>\r\n" + 
				"<html> \r\n" + 
				"<head>\r\n" + 
				"	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
				"<!--\r\n" + 
				"	******************************************** \r\n" + 
				"		title : 풀스텍 홍길동\r\n" + 
				"	******************************************** \r\n" + 
				" -->	\r\n" + 
				"	<title>TRACK11 홍길동</title>\r\n" + 
				"	<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.5.0/css/all.css\">	\r\n" + 
				"	<link href=\"../css/common.css\" rel=\"stylesheet\">\r\n" + 
				"	<link href=\"../css/layout.css\" rel=\"stylesheet\" >	\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<div class=\"container\">\r\n" + 
				"\r\n" + 
				"		<div class=\"leftmargin\">\r\n" + 
				"			<img src=\"../images/jsl_logo.png\"><h1>JSL54 홍길동 회원관리</h1>\r\n" + 
				"		</div>		\r\n" + 
				"		<div class=\"search_wrap\">\r\n" + 
				"			<div class=\"record_group\">\r\n" + 
				"				<p>총게시글 : <span>2</span>건</p>\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"search_group\">\r\n" + 
				"				<select class=\"select\">\r\n" + 
				"					<option >ID</option>\r\n" + 
				"					<option >성명</option>\r\n" + 
				"				</select>\r\n" + 
				"				<input type=\"text\" class=\"search_word\">\r\n" + 
				"				<button class=\"btn_search\"><i class=\"fa fa-search\"></i><span class=\"sr-only\">검색버튼</span></button>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<div class=\"board_list\">\r\n" + 
				"		<table class=\"board_table\">\r\n" + 
				"			<colgroup>\r\n" + 
				"				<col width=\"25%\">\r\n" + 
				"				<col width=\"25%\">\r\n" + 
				"				<col width=\"25%\">\r\n" + 
				"				<col width=\"25%\">\r\n" + 
				"			</colgroup>\r\n" + 
				"			<thead>\r\n" + 
				"				<tr>\r\n" + 
				"					<th>ID</th>\r\n" + 
				"					<th>성명</th>\r\n" + 
				"					<th>나이</th>\r\n" + 
				"					<th>가입일</th>\r\n" + 
				"				</tr>\r\n" + 
				"			</thead>\r\n" + 
				"			<tbody>\r\n") ;
		
				for(int k=0; k < 3; k++) {
					out.print("		<tr>\r\n" + 
					"					<td><a href=\"member_view.html\">abcLove</a></td>\r\n" + 
					"					<td>김사랑</td>\r\n" + 
					"					<td>25</td>\r\n" + 
					"					<td>2021-04-01</td>\r\n" + 
					"				</tr>	\r\n");
				}
				out.print(
				"			\r\n" + 
				"			</tbody>\r\n" + 
				"		</table>\r\n" + 
				"		<div class=\"paging\">\r\n" + 
				"			<a href=\"member_write.html\" class=\"write\">회원등록</a>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				" </body>\r\n" + 
				"</html>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
