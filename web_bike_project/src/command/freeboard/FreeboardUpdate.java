package command.freeboard;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.FreeboardDao;
import dto.FreeboardDto;

public class FreeboardUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		FreeboardDao dao = new FreeboardDao();
		String freeboardDir = CommonUtil.getFile_dir_freeboard();
		int maxSize = 1024 * 1024 * 5;
		
		String msg = "게시물 수정되었습니다!";
		MultipartRequest mpr = null;
		try {
			mpr = new MultipartRequest(request, freeboardDir,
										maxSize,"utf-8",
										new DefaultFileRenamePolicy());
			
		String no = mpr.getParameter("t_no");
		String title = mpr.getParameter("t_title");
		String content = mpr.getParameter("t_content");
		HttpSession session = request.getSession();
		String reg_id = (String)session.getAttribute("sessionId");
		String attach = mpr.getFilesystemName("t_attach");
		String ori_attach = mpr.getParameter("t_ori_attach");
		if(attach == null) {
			attach = ori_attach;
		} else {
			File file = new File(freeboardDir, ori_attach);
			file.delete();
		}
		int hit = 0;
		
			
		FreeboardDto dto = new FreeboardDto(no, title, content, reg_id, attach, hit);
		int result = dao.freeboardUpdate(dto);
		if(result != 1) msg = "게시물수정실패~";
		
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		request.setAttribute("t_msg", msg );
		request.setAttribute("t_url","Freeboard" );

	}
}
