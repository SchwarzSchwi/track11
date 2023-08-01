package command.snack;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackList implements CommonExecute {

	@Override
	public void execute(HttpServletRequest req) {
		SnackDao dao = new SnackDao();
		
		String select = req.getParameter("t_select");
		String search = req.getParameter("t_search");
		if(select == null) {
			select = "p_code";
			search = "";
		}
		ArrayList<SnackDto> dtos = dao.getSnackList(select, search);
		
		req.setAttribute("t_dtos", dtos);
		req.setAttribute("t_select", select);
		req.setAttribute("t_search", search);
	}

}
