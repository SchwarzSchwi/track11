package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest req) {
		MemberDao dao = new MemberDao();
		String id = req.getParameter("t_id");
		String name = req.getParameter("t_name");
		String age = req.getParameter("t_age");
		String reg_date = req.getParameter("t_reg_date");
		
		MemberDto dto = new MemberDto(id, name, Integer.parseInt(age), reg_date);
		int result = dao.memberUpdate(dto);
//		String msg = "등록성공~";
//		if(result != 1)msg = "등록실패";
		
		String msg = result == 1 ? "수정성공":"수정실패!";
		req.setAttribute("t_msg", msg);
		req.setAttribute("t_url", "Member");
	}

}
