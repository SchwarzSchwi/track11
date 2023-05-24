package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberInfo implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sessionId");
		
		String msg ="", url="";
		if(id==null) {
			msg = "로그인 정보가 만료되었습니다.";
			url = "Member";
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", url);
			request.setAttribute("urlGubun", "noSession");
		}else {
			request.setAttribute("urlGubun", "yesSession");
			MemberDto dto = dao.getMemberInfo(id);
			request.setAttribute("t_dto", dto);
		}
	}

}
