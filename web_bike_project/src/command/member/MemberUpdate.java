package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.MemberDao;
import dto.MemberDto;

public class MemberUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		String id       = request.getParameter("t_id");
		String name     = request.getParameter("t_name");
		
		String area     = request.getParameter("t_area");
		String address  = request.getParameter("t_address");
		String mobile_1 = request.getParameter("t_mobile_1");
		String mobile_2 = request.getParameter("t_mobile_2");
		String mobile_3 = request.getParameter("t_mobile_3");
		String gender   = request.getParameter("t_gender");
		String hobby_travel  = request.getParameter("t_hobby_travel");
		String hobby_reading = request.getParameter("t_hobby_reading");
		String hobby_sports  = request.getParameter("t_hobby_sports");
		if(hobby_travel == null) hobby_travel ="n";
		if(hobby_reading == null) hobby_reading ="n";
		if(hobby_sports == null) hobby_sports ="n";
		String update_date = CommonUtil.getTodayTime();
		MemberDto dto = new MemberDto(id, name, area, address, 
				                      mobile_1, mobile_2, mobile_3, gender, 
				                      hobby_travel, hobby_reading, hobby_sports, update_date);
		int result = dao.memberUpdate(dto);
		String msg ="정보 수정되었습니다.";
		if(result != 1)msg="수정오류~. 관리자에게 문의 바랍니다.";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Index");
				
		
	}

}
