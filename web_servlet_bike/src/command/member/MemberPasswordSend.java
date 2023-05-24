package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;

public class MemberPasswordSend implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		String id = request.getParameter("t_id");
		String mobile_1 = request.getParameter("t_mobile_1");
		String mobile_2 = request.getParameter("t_mobile_2");
		String mobile_3 = request.getParameter("t_mobile_3");
		String email = request.getParameter("t_email");
		
		String memberName = dao.getCheckMember(id,mobile_1,mobile_2,mobile_3,email);
		String msg="";
		if(memberName.equals("")) {
			msg ="ID나 전화번호가 정확하지 않습니다.";
		}else {
			msg =memberName+"님 새비밀번호를 발송했습니다.";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Member");
	}

}
