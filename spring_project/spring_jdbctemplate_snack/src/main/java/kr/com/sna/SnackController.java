package kr.com.sna;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import command.snack.SnackDelete;
import command.snack.SnackList;
import command.snack.SnackSave;
import command.snack.SnackUpdate;
import command.snack.SnackView;
import command.snack.SnackWrite;
import common.CommonExecute;
import common.CommonTemplate;
import dto.SnackDto;

@Controller
public class SnackController {
	
	@Autowired
	SnackDto snackDto;
	
	@Autowired
	JdbcTemplate template;
	
	@Autowired
	public void setTemplate() {
		CommonTemplate.setTemplate(template);
	}

	@RequestMapping("Snack")
	public String snack(HttpServletRequest req) {
		
		String gubun = req.getParameter("t_gubun");
		if(gubun == null)gubun = "list";
		String viewPage = "";
		
		//list
		if(gubun.equals("list")) {
			SnackList snack = new SnackList();
			snack.execute(req);
			viewPage = "/snackMvc/snack_list";
		//writeForm	
		}else if(gubun.equals("writeForm")) {
			SnackWrite snack = new SnackWrite();
			snack.execute(req);
			viewPage = "/snackMvc/snack_write";
		//snackSave	
		}else if(gubun.equals("snackSave")) {
			SnackSave snack = new SnackSave();
			snack.execute(req);
			viewPage = "/common_alert";
		//snackView	
		}else if(gubun.equals("snackView")) {
			CommonExecute snack = new SnackView();
			snack.execute(req);
			viewPage = "/snackMvc/snack_view";
		//snackUpdateForm	
		}else if(gubun.equals("snackUpdateForm")) {
			CommonExecute snack = new SnackView();
			snack.execute(req);
			viewPage="/snackMvc/snack_update";
		//snackUpdate	
		}else if(gubun.equals("snackUpdate")) {
			CommonExecute snack = new SnackUpdate();
			snack.execute(req);
			viewPage="/common_alert";
		//snackDelete	
		}else if(gubun.equals("snackDelete")) {
			CommonExecute snack = new SnackDelete();
			snack.execute(req);
			viewPage="/common_alert";
		}	
		return viewPage;	
	}
}
