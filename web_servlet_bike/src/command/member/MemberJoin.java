package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.MemberDao;
import dto.MemberDto;

public class MemberJoin implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		String id       = request.getParameter("t_id");
		String name     = request.getParameter("t_name");
		
		String password = request.getParameter("t_pw_1");
		int password_len = password.length();
		
		try {
			password = dao.encryptSHA256(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
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
		String reg_date = CommonUtil.getTodayTime();	
		
		MemberDto dto = new MemberDto(id, name, password, area, address, mobile_1, mobile_2, mobile_3, gender, hobby_travel, hobby_reading, hobby_sports, reg_date, password_len);
		
		int result = dao.memberJoin(dto);	
		String msg=name+"님 회원가입 되었습니다.";
		
		if(result != 1) msg ="회원가입 실패! 관리자에게 문의 하세요~";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Member");
	}

}
