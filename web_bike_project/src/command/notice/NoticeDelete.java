package command.notice;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.NoticeDao;

public class NoticeDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		NoticeDao dao = new NoticeDao();
		String no = request.getParameter("t_no");
		String deleteAttach = request.getParameter("t_attach");
		int result = dao.noticeDelete(no);
		boolean tf = true;
		if(result == 1) {
			if(!deleteAttach.equals("")) {
				File file = new File(CommonUtil.getFile_dir_notice(), deleteAttach);
				tf = file.delete();
				if(!tf)System.out.println("공지사항 게시글 삭제 첨부삭제 오류!");
			}
		}
		String msg="삭제실패!";
		if(result ==1 && tf) msg = "삭제되었습니다.";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Notice");
	}

}
