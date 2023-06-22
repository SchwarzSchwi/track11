package command.news;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.NewsDao;
import dto.NewsDto;

public class NewsView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NewsDao dao = new NewsDao();
		String no = request.getParameter("t_no");
		dao.setHitCount(no);
		NewsDto dto = dao.getNewsView(no);
		
		NewsDto preDto = dao.getPreNews(no);
		NewsDto nextDto = dao.getNextNews(no);
		
		request.setAttribute("t_dto", dto);
		request.setAttribute("t_preDto", preDto);
		request.setAttribute("t_nextDto", nextDto);
	}
}







