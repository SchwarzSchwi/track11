package kr.com.sts;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import command.member.MemberDelete;
import command.member.MemberList;
import command.member.MemberSave;
import command.member.MemberUpdate;
import command.member.MemberView;
import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

@Controller
public class Member {
	@RequestMapping("Member")
	public String member(HttpServletRequest req) {
		String gubun = req.getParameter("t_gubun");
		if(gubun == null)gubun="list";
		String viewPage = "";
		//list
		if(gubun.equals("list")) {
			MemberList member = new MemberList();
			member.execute(req);
			viewPage = "/memberMvc/member_list";
		//writeForm	
		}else if(gubun.equals("writeForm")) {
			viewPage ="/memberMvc/member_write";
		//memberSave	
		}else if(gubun.equals("memberSave")) {
			CommonExecute member = new MemberSave();
			member.execute(req);
			viewPage = "/common_alert";
		//memberView	
		}else if(gubun.equals("memberView")) {
			CommonExecute member = new MemberView();
			member.execute(req);
			viewPage = "/memberMvc/member_view";
		//memberUpdateForm	
		}else if(gubun.equals("memberUpdateForm")) {
			CommonExecute member = new MemberView();
			member.execute(req);
			viewPage="/memberMvc/member_update";
		//memberUpdate	
		}else if(gubun.equals("memberUpdate")) {
			CommonExecute member = new MemberUpdate();
			member.execute(req);
			viewPage="/common_alert";
		//memberDelete	
		}else if(gubun.equals("memberDelete")) {
			CommonExecute member = new MemberDelete();
			member.execute(req);
			viewPage="/common_alert";
		}
		return viewPage;
	}
	
	
	
	
	
	@RequestMapping("memberDelete")
	public String memberDelete(HttpServletRequest req) {
		MemberDao dao = new MemberDao();
		String id = req.getParameter("t_id");
		int result = dao.memberDelete(id);
		
		return "redirect:memberList";
	}
	@RequestMapping("memberUpdate")
	public String memberUpdate(HttpServletRequest req) {
		MemberDao dao = new MemberDao();
		String id = req.getParameter("t_id");
		String name = req.getParameter("t_name");
		String age = req.getParameter("t_age");
		String reg_date = req.getParameter("t_reg_date");
		
		MemberDto dto = new MemberDto(id, name, Integer.parseInt(age), reg_date);
		int result = dao.memberUpdate(dto);
//		String msg = "등록성공~";
//		if(result != 1)msg = "등록실패";
		
		String msg = result == 1 ? "수정성공":"수정실패!";
		req.setAttribute("t_msg", msg);
		req.setAttribute("t_url", "memberList");
		
//		return "/common_alert";
		return "redirect:memberList";
	}
	//수정폼
	@RequestMapping("memberUpdateForm")
	public String memberUpdateForm(HttpServletRequest req) {
		MemberDao dao = new MemberDao();
		String id = req.getParameter("t_id");
		MemberDto dto = dao.getMemberView(id);
		
		req.setAttribute("t_dto", dto);
		
		return "/member/member_update";
	}
	//상세조회
	@RequestMapping("memberView")
	public String memberView(HttpServletRequest req) {
		MemberDao dao = new MemberDao();
		String id = req.getParameter("t_id");
		MemberDto dto = dao.getMemberView(id);
		
		req.setAttribute("t_dto", dto);
		
		return "/member/member_view";
	}
	
	@RequestMapping("memberWrite")
	public String memberWrite() {
		return "/member/member_write";
	}
	@RequestMapping("memberSave")
	public String memberSave(HttpServletRequest req) {
		MemberDao dao = new MemberDao();
		
		String id = req.getParameter("t_id");
		String name = req.getParameter("t_name");
		String age = req.getParameter("t_age");
		String regdate = req.getParameter("t_regdate");
		
		MemberDto dto = new MemberDto(id, name, Integer.parseInt(age),regdate);
		int result = dao.memberSave(dto);
		String msg = "등록성공~";
		if(result != 1)msg = "등록실패";
		
		req.setAttribute("t_msg", msg);
		req.setAttribute("t_url", "memberList"); 
		
		return "/common_alert";
	}
	@RequestMapping("memberList")
	public String memberList(HttpServletRequest req) {
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
		
		return "/member/member_list";
	}
	
}
