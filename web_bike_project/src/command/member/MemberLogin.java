package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import common.CommonUtil;
import dao.MemberDao;
import dto.MemberDto;

public class MemberLogin implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao   = new MemberDao();
		String id       = request.getParameter("t_id");
		String password = request.getParameter("t_pw");
		
		try {
			password = dao.encryptSHA256(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
//		String name = dao.getLoginName(id,password);
		MemberDto dto = dao.getLoginName(id, password);
		String msg ="", url="";
		if(dto==null) {
			msg ="아이디나 비밀번호가 맞지 않습니다.";
			url ="Member";
		}else {
			int result = dao.setLoginTime(id,CommonUtil.getTodayTime());
			if(result != 1) {
				System.out.println("로그인 시간 업데이트 오류!");
			}
			msg = dto.getName()+"님 환영합니다!";
			url ="Index";
			
			HttpSession session = request.getSession();
			session.setAttribute("sessionId", id);
			session.setAttribute("sessionName", dto.getName());
			session.setAttribute("sLevel", dto.getMemberLevel());
			session.setMaxInactiveInterval(60*60*3);
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
	}


}
