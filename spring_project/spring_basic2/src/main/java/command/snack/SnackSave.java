package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest req) {
		SnackDao dao = new SnackDao();
		
		String p_code = req.getParameter("t_p_code");
		String p_name = req.getParameter("t_p_name");
		String price = req.getParameter("t_price");
		String m_name = req.getParameter("t_m_name");
		
		SnackDto dto = new SnackDto(p_code, p_name, Integer.parseInt(price), m_name);
		int result = dao.snackSave(dto);
		String msg = "등록성공";
		if(result != 1)msg="등록실패";
		
		req.setAttribute("t_msg", msg);
		req.setAttribute("t_url", "Snack");
	}

}
