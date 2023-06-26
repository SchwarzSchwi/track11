package command.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberList implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		
		String select = request.getParameter("t_select");
		String search = request.getParameter("t_search");
		
		
		if(select == null) {
			select ="id";
			search ="";
		}
		ArrayList<MemberDto> dtos = dao.getMemberList(select,search);
		
		request.setAttribute("t_dtos", dtos);
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);

	}

}
