package command.etc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonUtil;
import dao.EtcDao;
import dto.EtcDto;

/**
 * Servlet implementation class EtcWrite
 */
@WebServlet("/EtcWrite")
public class EtcWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtcWrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession ss = request.getSession();
		EtcDao dao = new EtcDao();
		
		String no = dao.getMaxNo();
		String content = request.getParameter("t_content");
		String reg_id = (String)ss.getAttribute("sessionId");
		String reg_date = CommonUtil.getTodayTime();
		String reply = no;
		EtcDto dto = new EtcDto(no, content, reg_id, null, reg_date, null, null, reply);
		dao.insertDB(dto);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}