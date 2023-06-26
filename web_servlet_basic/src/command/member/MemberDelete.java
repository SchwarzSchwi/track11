package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;

public class MemberDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		String id = request.getParameter("t_id");
		
		int result = dao.memberDelete(id);
		String msg = "삭제성공";
		String url = "Member";
		if(result != 1) {
			msg = "삭제실패";
			url = "Member";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		
	}

}
