package snack;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SnackDao;
import dto.SnackDto;

/**
 * Servlet implementation class DBSnackSave
 */
@WebServlet("/DBSnackSave")
public class DBSnackSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBSnackSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SnackDao dao = new SnackDao();
		String p_code = request.getParameter("t_p_code");
		String p_name = request.getParameter("t_p_name");
		String price  = request.getParameter("t_price");
		String m_code = request.getParameter("t_m_code");
		
		SnackDto dto = new SnackDto(p_code, p_name, Integer.parseInt(price), m_code);
		int result = dao.snackSave(dto);
		
		String msg = "등록성공";
		String url = "SnackList";
		if(result != 1)	{
			msg = "등록실패";
			url = "SnackWrite";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		
		RequestDispatcher rd = request.getRequestDispatcher("common_alert.jsp");
		rd.forward(request, response);
		
		ArrayList<SnackDto> dtos = dao.getSnackList("id", "","");
		
		request.setAttribute("t_dtos", dtos);
		request.setAttribute("t_select", "id");
		request.setAttribute("t_search", "");
		request.setAttribute("t_radio", "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
