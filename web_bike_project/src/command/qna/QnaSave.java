package command.qna;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.QnaDao;
import dto.QnaDto;

public class QnaSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		QnaDao dao = new QnaDao();
		String msg = "등록되었습니다!";
		String no = dao.getMaxNo();
		String q_title = request.getParameter("q_title").replace("\'", "\''").replace("\"", "&quot;");
		String q_content = request.getParameter("q_content").replace("\'", "\''").replace("\"", "&quot;");
		String q_date = CommonUtil.getTodayTime();
		HttpSession session = request.getSession();
		String q_id = (String)session.getAttribute("sessionId");
		String name = (String)session.getAttribute("sessionName");
		int view = 0;
		
			
		QnaDto dto = new QnaDto(no, q_title, q_content,  q_date, q_id, name, view);
		int result = dao.qnaSave(dto);
		if(result != 1) msg = "등록실패~";
		
		request.setAttribute("t_msg", msg );
		request.setAttribute("t_url","Qna" );
	}

}
