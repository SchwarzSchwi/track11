package command.freeboard;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.FreeboardDao;
import dto.FreeboardDto;

public class FreeboardView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		FreeboardDao dao = new FreeboardDao();
		String no = request.getParameter("t_no");
		dao.setHitCount(no);
		FreeboardDto dto = dao.getFreeboardView(no);
		
		request.setAttribute("t_dto", dto);
		
	}

}
