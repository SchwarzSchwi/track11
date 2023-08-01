package kr.com.sts;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import command.snack.SnackDelete;
import command.snack.SnackList;
import command.snack.SnackSave;
import command.snack.SnackUpdate;
import command.snack.SnackView;
import common.CommonExecute;

@Controller
public class Snack {
	@RequestMapping("Snack")
	public String snack(HttpServletRequest req) {
		String gubun = req.getParameter("t_gubun");
		if(gubun == null)gubun="list";
		String viewPage = "";
		//리스트
		if(gubun.equals("list")) {
			CommonExecute snack = new SnackList();
			snack.execute(req);
			viewPage = "/snackMvc/snack_list";
		//저장 폼	
		}else if(gubun.equals("writeForm")) {
			viewPage ="/snackMvc/snack_write";
		//저장	
		}else if(gubun.equals("snackSave")) {
			CommonExecute snack = new SnackSave();
			snack.execute(req);
			viewPage = "/common_alert";
		//상세보기	
		}else if(gubun.equals("snackView"))	{
			CommonExecute snack = new SnackView();
			snack.execute(req);
			viewPage = "/snackMvc/snack_view";
		//수정 폼	
		}else if(gubun.equals("snackUpdateForm")) {
			CommonExecute snack = new SnackView();
			snack.execute(req);
			viewPage="/snackMvc/snack_update";
		//수정
		}else if(gubun.equals("snackUpdate")) {
			CommonExecute snack = new SnackUpdate();
			snack.execute(req);
			viewPage="/common_alert";
		//삭제	
		}else if(gubun.equals("snackDelete")) {
			CommonExecute snack = new SnackDelete();
			snack.execute(req);
			viewPage="/common_alert";
		}
	return viewPage;
	}
}
