package command.qna;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.QnaDao;

public class QnaDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		QnaDao dao = new QnaDao();
		String no = request.getParameter("t_no");
		
		int result = dao.qnaDelete(no);
		String msg = "삭제되었습니다.";
		if(result != 1)msg = "삭제 실패!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Qna");
	}

}
