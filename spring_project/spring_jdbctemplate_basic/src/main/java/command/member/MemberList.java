package command.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberList implements CommonExecute {

	@Override
	public void execute(HttpServletRequest req) {
		MemberDao dao = new MemberDao();
		
		String select = req.getParameter("t_select");	
		String search = req.getParameter("t_search");
		if(select == null) {
			select = "id";
			search = "";
		}
		
		ArrayList<MemberDto> dtos = dao.getMemberList(select,search);
		
		req.setAttribute("t_dtos",dtos);
		req.setAttribute("t_select",select);
		req.setAttribute("t_search",search);
	}

}
