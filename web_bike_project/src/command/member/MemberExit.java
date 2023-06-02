package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.MemberDao;

public class MemberExit implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sessionId");
		String name = (String)session.getAttribute("sessionName");
		String exitDate = CommonUtil.getTodayTime();

		String msg = name+"님 탈퇴 되었습니다.";
		if(id != null) {
			int result = dao.setMemberExit(id, exitDate);
			if(result == 1){
				session.invalidate();
			}else {	
				msg = "탈퇴 처리 오류! 관리자에게 문의 바랍니다.";
			}
		}else {
			msg = "로그인 정보가 만료 되었습니다.";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Index");
	}

}
