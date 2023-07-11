package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManageDao;
import dto.ManageDto;

/**
 * Servlet implementation class ManageStatus
 */
@WebServlet("/ManageStatus")
public class ManageStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManageDao dao = new ManageDao();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String now_status = request.getParameter("t_now_status");
		String order_no = request.getParameter("t_order_no");
		
		ManageDto dto = new ManageDto(now_status, order_no);
		
		int result = dao.manageUpdate(dto);
		if(result == 1)out.print("변경완료");
		else out.print("변경실패");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
