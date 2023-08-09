package command.snack;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackWrite implements CommonExecute {

	@Override
	public void execute(HttpServletRequest req) {
		// TODO Auto-generated method stub
		SnackDao dao = new SnackDao();
		
		ArrayList<SnackDto> dtos = dao.getCompanyList();
		req.setAttribute("t_dtos",dtos);
	}

}
