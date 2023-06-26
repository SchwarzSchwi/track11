package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;

public class SnackDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao = new SnackDao();
		String p_code = request.getParameter("t_p_code");
		
		int result = dao.snackDelete(p_code);
		String msg = "삭제 성공";
		String url = "Snack";
		if(result != 1) {
			msg = "삭제 실패";
//			url = "SnackList";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);

	}

}
