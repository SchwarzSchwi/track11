package command.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.QnaDao;
import dto.QnaDto;

public class QnaReply implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		QnaDao dao = new QnaDao();
		String msg = "등록되었습니다!";
		String no = request.getParameter("t_no");
		String a_title = request.getParameter("a_title");
		String a_content = request.getParameter("a_content");
		String a_date = CommonUtil.getTodayTime();
		HttpSession session = request.getSession();
		String a_id = (String)session.getAttribute("sessionId");
		
			
		QnaDto dto = new QnaDto(no, a_title, a_content,  a_date, a_id);
		int result = dao.qnaReply(dto);
		if(result != 1) msg = "등록실패~";
		
		request.setAttribute("t_msg", msg );
		request.setAttribute("t_url","Qna" );
	}

}
