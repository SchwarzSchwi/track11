package command.freeboard;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.FreeboardDao;
import dto.FreeboardDto;

public class FreeboardSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		FreeboardDao dao = new FreeboardDao();
		String freeboardDir = CommonUtil.getFile_dir_freeboard();
		int maxSize = 1024 * 1024 * 5;
		
		
		String msg = "등록되었습니다!";
		MultipartRequest mpr = null;
		try {
			mpr = new MultipartRequest(request, freeboardDir,
										maxSize,"utf-8",
										new DefaultFileRenamePolicy());
	
		String no = dao.getMaxNo();
		String title = mpr.getParameter("t_title").replace("\'", "\''").replace("\"", "&quot;");
		String content = mpr.getParameter("t_content").replace("\'", "\''").replace("\"", "&quot;");
		String reg_date = CommonUtil.getTodayTime();
		HttpSession session = request.getSession();
		String reg_id = (String)session.getAttribute("sessionId");
		String attach = mpr.getFilesystemName("t_attach");
		if(attach == null)attach="";
		String name = (String)session.getAttribute("sessionName");
		int hit = 0;
		
			
		FreeboardDto dto = new FreeboardDto(no, title, content, reg_id, reg_date, attach, hit);
		int result = dao.freeboardSave(dto);
		if(result != 1) msg = "등록실패~";
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		request.setAttribute("t_msg", msg );
		request.setAttribute("t_url","Freeboard" );
	}

}
