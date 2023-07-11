package command.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.QnaDao;
import dto.QnaDto;

public class QnaUpdateAnswer implements CommonExecute {

	public void execute(HttpServletRequest request) {
		QnaDao dao = new QnaDao();
		String msg = "답변 수정되었습니다!";
		String no = request.getParameter("t_no");
		String a_content = request.getParameter("a_content");
		String a_date = CommonUtil.getTodayTime();
		HttpSession session = request.getSession();
		String a_id = (String)session.getAttribute("sessionId");
		String name = (String)session.getAttribute("sessionName");
		int views = 0;
		
			
		QnaDto dto = new QnaDto(no, a_content, a_date, a_id, name, views);
		int result = dao.qnaUpdateAnswer(dto);
		if(result != 1) msg = "답변수정실패~";
		
		request.setAttribute("t_msg", msg );
		request.setAttribute("t_url","Qna" );

	}

}
