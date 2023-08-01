package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest req) {
		MemberDao dao = new MemberDao();
		String id = req.getParameter("t_id");
		MemberDto dto = dao.getMemberView(id);
		req.setAttribute("t_dto", dto);
	}

}
