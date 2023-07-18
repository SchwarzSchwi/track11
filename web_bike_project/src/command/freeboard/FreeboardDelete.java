package command.freeboard;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.FreeboardDao;

public class FreeboardDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		FreeboardDao dao = new FreeboardDao();
		String no = request.getParameter("t_no");
		String deleteAttach = request.getParameter("t_attach");
		
		int result = dao.freeboardDelete(no);
		if(result == 1) {
			File file = new File(CommonUtil.getFile_dir_freeboard(),deleteAttach);
			boolean tf = file.delete();
			if(!tf) System.out.println("자유게시판 첨부파일 삭제 오류~~");	
		}
		String msg = "삭제되었습니다~~";
		if(result != 1)msg ="삭제 실패했습니다~~~";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Freeboard");
	}

}
	