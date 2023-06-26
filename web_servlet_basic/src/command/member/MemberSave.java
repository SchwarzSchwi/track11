package command.member;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDao;
import dto.MemberDto;

public class MemberSave {
		public void execute(HttpServletRequest request) {
			MemberDao dao = new MemberDao();
			
			String id		 = request.getParameter("t_id");
			String name		 = request.getParameter("t_name");
			String age 		 = request.getParameter("t_age");
			String reg_date  = request.getParameter("t_reg_date");
			
			MemberDto dto = new MemberDto(id, name, Integer.parseInt(age), reg_date);
			
			int result = dao.memberSave(dto);
			
			String msg ="등록성공";
			String url ="Member";
			if(result != 1) {
				msg ="등록실패~";
//				url ="MemberWrite";
			}
			
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", url);
		}
}
