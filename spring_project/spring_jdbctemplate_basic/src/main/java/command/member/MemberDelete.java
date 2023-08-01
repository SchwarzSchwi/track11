package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;

public class MemberDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest req) {
		MemberDao dao = new MemberDao();
		String id = req.getParameter("t_id");
		int result = dao.memberDelete(id);
		
		String msg = result == 1? "삭제 성공":"삭제 실패";
		
		req.setAttribute("t_msg", msg);
		req.setAttribute("t_url", "Member");
	}

}
