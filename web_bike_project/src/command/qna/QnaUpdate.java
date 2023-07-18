package command.qna;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.QnaDao;
import dto.QnaDto;

public class QnaUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		QnaDao dao = new QnaDao();
		String qnaDir = CommonUtil.getFile_dir_qna();
		int maxSize = 1024 * 1024 * 5;
		
		String msg = "질문 수정되었습니다!";
		MultipartRequest mpr = null;
		try {
			mpr = new MultipartRequest(request, qnaDir,
										maxSize,"utf-8",
										new DefaultFileRenamePolicy());
			
		String no = mpr.getParameter("t_no");
		String q_title = mpr.getParameter("q_title");
		String q_content = mpr.getParameter("q_content");
		String q_date = CommonUtil.getTodayTime();
		HttpSession session = request.getSession();
		String q_id = (String)session.getAttribute("sessionId");
		String name = (String)session.getAttribute("sessionName");
		String photos = mpr.getFilesystemName("t_photos");
		int views = 0;
		
			
		QnaDto dto = new QnaDto(no, q_title, q_content,  q_date, q_id, name, photos, views);
		int result = dao.qnaUpdate(dto);
		if(result != 1) msg = "질문수정실패~";
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		request.setAttribute("t_msg", msg );
		request.setAttribute("t_url","Qna" );

	}

}
