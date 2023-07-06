package command.manage;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.ManageDao;
import dto.ManageDto;

public class ManageView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ManageDao dao = new ManageDao();
		String order_no = request.getParameter("t_no");
		
		ManageDto dto = dao.getManageView(order_no);
		
		request.setAttribute("t_dto", dto);
	}


}
