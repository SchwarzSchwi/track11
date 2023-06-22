package command.notice;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.NoticeDao;
import dto.NoticeDto;

public class NoticeUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		NoticeDao dao = new NoticeDao();
		
		MultipartRequest mpr = null;
		int maxSize = 1024 * 1024 * 5;
		try {
			mpr = new MultipartRequest(request,CommonUtil.getFile_dir_notice(),
									  maxSize, "utf-8", 
									  new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String no = mpr.getParameter("t_no");
		String title = mpr.getParameter("t_title");
		String content = mpr.getParameter("t_content");
		String attach = mpr.getFilesystemName("t_attach");
		if(attach == null) attach="";
		String oriAttach = mpr.getParameter("t_oriAttach");
		if(oriAttach == null) oriAttach="";
		
		String saveAttachName="";
		
		String deleteAttach = mpr.getParameter("t_deleteCheckbox");
		
		boolean delAttach = true;
		if(deleteAttach != null) {
			File file = new File(CommonUtil.getFile_dir_notice(),deleteAttach);
			boolean tf = file.delete();
			delAttach = false;
			if(!tf)System.out.println("공지사항 첨부파일 삭제 오류");
		}else {
			saveAttachName = oriAttach;
		}
		if(!attach.equals("")) {
			if(!oriAttach.equals("") && delAttach) {
				File file = new File(CommonUtil.getFile_dir_notice(),oriAttach);
				boolean tf = file.delete();
				if(!tf) System.out.println("공지사항 기존 첨부파일 삭제오류~");
			}
			saveAttachName = attach;
		}
		
		NoticeDto dto = new NoticeDto(no, title, content, saveAttachName);
		
		int result = dao.noticeUpdate(dto);
		
		String msg ="수정되었습니다.";
		if(result != 1) msg ="공지사항 수정 실패!";
		request.setAttribute("t_msg", "수정~");
		request.setAttribute("t_url", "Notice");
	}
	

}
