package command.qna;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.QnaDao;
import dto.QnaDto;

public class QnaView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		QnaDao dao = new QnaDao();
		String no = request.getParameter("t_no");
		dao.setViewsCount(no);
		QnaDto dto = dao.getQnaView(no);
		
		request.setAttribute("t_dto", dto);
		
	}


}
