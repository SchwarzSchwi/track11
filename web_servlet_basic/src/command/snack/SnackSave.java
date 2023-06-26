package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao = new SnackDao();
		String p_code = request.getParameter("t_p_code");
		String p_name = request.getParameter("t_p_name");
		String price  = request.getParameter("t_price");
		String m_code = request.getParameter("t_m_code");
		
		SnackDto dto = new SnackDto(p_code, p_name, Integer.parseInt(price), m_code);
		int result = dao.snackSave(dto);
		
		String msg = "등록성공";
		String url = "Snack";
		if(result != 1)	{
			msg = "등록실패";
//			url = "Snack";
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
	}

}
