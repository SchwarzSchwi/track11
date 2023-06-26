package command.member;
import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		String age = request.getParameter("t_age");
		String reg_date = request.getParameter("t_reg_date");
		
		MemberDto dto = new MemberDto(id, name, Integer.parseInt(age), reg_date);
		
		int result = dao.memberUpdate(dto);
		String msg = "수정성공";
		String url = "Member";
		if(result!=1) {
			msg="수정실패";
//			url="Memberlist";
			url="Member";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		
	}

}
