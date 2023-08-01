package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest req) {
		SnackDao dao = new SnackDao();
		String p_code = req.getParameter("t_p_code");
		SnackDto dto = dao.getSnackView(p_code);
		req.setAttribute("t_dto", dto);
	}

}
