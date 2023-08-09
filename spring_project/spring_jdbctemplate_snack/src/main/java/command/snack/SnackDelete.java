package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;

public class SnackDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest req) {
		SnackDao dao = new SnackDao();
		String p_code = req.getParameter("t_p_code");
		int result = dao.snackDelete(p_code);
		
		String msg = result == 1? "삭제 성공":"삭제 실패";
		
		req.setAttribute("t_msg", msg);
		req.setAttribute("t_url", "Snack");
	}

}
