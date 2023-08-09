package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest req) {
		SnackDao dao = new SnackDao();
		String p_code = req.getParameter("t_p_code");
		String p_name = req.getParameter("t_p_name");
		String price = req.getParameter("t_price");
		String m_code = req.getParameter("t_m_code");
	
		
		SnackDto dto = new SnackDto(p_code, p_name, Integer.parseInt(price), m_code);
		int result = dao.snackUpdate(dto);
//		String msg = "등록성공~";
//		if(result != 1)msg = "등록실패";
		
		String msg = result == 1 ? "수정성공":"수정실패!";
		req.setAttribute("t_msg", msg);
		req.setAttribute("t_url", "Snack");
	}

}
