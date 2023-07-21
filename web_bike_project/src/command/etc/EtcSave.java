package command.etc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.EtcDao;
import dto.EtcDto;

public class EtcSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		EtcDao dao = new EtcDao();
		
		String msg = "등록되었습니다!";
		
		int entno = dao.getMaxNo();
		int groupno = Integer.parseInt(request.getParameter("groupno").replace("\'", "\''").replace("\"", "&quot;"));
		int grouporder = Integer.parseInt(request.getParameter("grouporder").replace("\'", "\''").replace("\"", "&quot;"));
		int depth = Integer.parseInt(request.getParameter("depth"));
		String regdate = CommonUtil.getTodayTime();
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		String regid = (String)session.getAttribute("sessionId");
		String name = (String)session.getAttribute("sessionName");
		int view = 0;
	
		EtcDto dto = new EtcDto(entno, groupno, grouporder, depth, title, regdate, regid);
		int result = dao.etcSave(dto);
		if(result != 1) msg = "등록실패~";
		
		request.setAttribute("t_msg", msg );
		request.setAttribute("t_url","Etc");
	}


}
