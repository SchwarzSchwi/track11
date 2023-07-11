package command.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.QnaDao;
import dto.QnaDto;

public class QnaDeleteAnswer implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		QnaDao dao = new QnaDao();
		String msg = "답변 삭제 되었습니다!";
		String no = request.getParameter("t_no");
		String a_title = "";
		String a_content = "";
		String a_date = "";
		HttpSession session = request.getSession();
		String a_id = "";
		
			
		QnaDto dto = new QnaDto(no, a_title, a_content,  a_date, a_id);
		int result = dao.qnaDeleteAnswer(dto);
		if(result != 1) msg = "답변삭제실패~";
		
		request.setAttribute("t_msg", msg );
		request.setAttribute("t_url","Qna" );


	}

}
