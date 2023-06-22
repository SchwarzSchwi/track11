package command.notice;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.NoticeDao;
import dto.NoticeDto;

public class NoticeView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NoticeDao dao = new NoticeDao();
		String no = request.getParameter("t_no");
		dao.setHitCount(no);
		NoticeDto dto = dao.getNoticeView(no);
		
		//이전글
		NoticeDto preDto = dao.getPreNotice(no);
		//다음글
		NoticeDto nextDto = dao.getNextNotice(no);
		
		request.setAttribute("t_dto", dto);
		request.setAttribute("t_preDto", preDto);
		request.setAttribute("t_nextDto", nextDto);
	}

}
